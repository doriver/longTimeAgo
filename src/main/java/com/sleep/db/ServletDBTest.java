package com.sleep.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/db/test")
public class ServletDBTest extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		MysqlService mysqlService = new MysqlService();
		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/leesang",
					"root",
					"root");
			
			Statement statement = conn.createStatement();
			
//			String inserQuery = "INSERT INTO `user`\r\n"
//					+ "(`name`, `yyyymmdd`, `hobby`, `introduce`, `createdAt`,`updatedAt`,`email`)\r\n"
//					+ "VALUE ('김인규','2011112','멍때리기','자기소개입니다',now(),now(),'haglu@haglu.com');";
//			
//			statement.executeUpdate(inserQuery);
//			
//			int count = statement.executeUpdate(inserQuery);
//			out.println("인서트 개수 :" + count);
			
			String selectQuery = "select * from `user`";
			ResultSet result = statement.executeQuery(selectQuery);
			
			while(result.next()) {
				out.println(result.getInt("id"));
				out.println(result.getString("name"));
				out.println(result.getString("hobby"));
			}
			
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.println("db 연동 테스트");
	}

}
