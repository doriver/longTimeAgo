package com.sleep.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sleep.common.MysqlService;

@WebServlet("/db/test01")
public class ServletDBTest01 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		
		// 1. 워크밴치에서 한다음에 복붙해야 오류 잡기 쉬움
		String insertQuery = "insert into `real_estate`\r\n"
		+ "(`realtorId`,`address`,`area`,`type`,`price`,`rentPrice`,`createdAt`,`updatedAt`)\r\n"
		+ "value (3,'헤라펠리스 101동 5305호',350,'매매',1500000,null,now(),now());";
		
		int count = 0;
		try {
			count = mysqlService.update(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("1.예외 발생");
		}
		
		out.println(count + "행 insert");
		
		// 2.
		String selectQuery = "SELECT * FROM `real_estate`\r\n" 
		+ "ORDER BY `id` DESC \r\n"
		+ "LIMIT 10;";
		
		// 트라이 케치로 묶여야
		ResultSet resultSet;
		try {
			resultSet = mysqlService.select(selectQuery);
			
			while (resultSet.next()) {
				out.print("매물주소: " + resultSet.getString("address") + ", ");
				out.print(resultSet.getInt("area") + ", ");
				out.println(resultSet.getString("type"));
			}
			
			mysqlService.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
