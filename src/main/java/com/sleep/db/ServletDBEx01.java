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

@WebServlet("/db/ex01")
public class ServletDBEx01 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		
		// 1.
//		String query = "insert into `used_goods`\r\n"
//				+ "(`title`,`price`,`description`,`sellerId`,`createdAt`,`updatedAt`)\r\n"
//				+ "value ('고양이 간식',2000,'고양이 입맛까다라옴',5,now(),now());";
//		
//		int count = 0;
//		
//		//try catch로 감싸야
//		try {
//			mysqlService.update(query);
//			count++;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		//
//		
//		out.println(count + "행 insert");
		
		// 2.select
		String query = "SELECT * FROM `used_goods`";
		
		// 트라이 케치로 묶여야
		ResultSet resultSet;
		try {
			resultSet = mysqlService.select(query);
			
			while (resultSet.next()) {
				out.println(resultSet.getInt("id"));
				out.println(resultSet.getString("title"));
				out.println(resultSet.getInt("price"));
				out.println(resultSet.getString("description"));
			}
			
			mysqlService.disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
	}
}
