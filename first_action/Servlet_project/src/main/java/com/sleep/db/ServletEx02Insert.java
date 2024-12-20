package com.sleep.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sleep.common.MysqlService;

@WebServlet("/db/ex02_insert")
public class ServletEx02Insert extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		
		String name = request.getParameter("name");
		String yyyymmdd = request.getParameter("yyyymmdd");
		String introduce = request.getParameter("introduce");
		String email = request.getParameter("email");
		
		MysqlService mysqlService = MysqlService.getInstance();
		mysqlService.connection();
		String insertQuery ="insert into `new_user`\r\n"
				+ "(`name`,`yyyymmdd`,`email`,`introduce`,`createdAt`,`updatedAt`)\r\n"
				+ "value('" + name + "','" + yyyymmdd + "','" + email + "','" + introduce + "',now(),now());";
//		
//		PrintWriter out = response.getWriter();
//		out.println(insertQuery);
		
		try {
			mysqlService.update(insertQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mysqlService.disconnect();
		
		// 다른페이지로 이동
		response.sendRedirect("/db/ex02.jsp");
	}
}
