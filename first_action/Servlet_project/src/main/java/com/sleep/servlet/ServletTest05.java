package com.sleep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test05")
public class ServletTest05 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html"); // 브라우저가 어떻게 표현?할지를 결정
		
		String numberString = request.getParameter("number");
		int number = Integer.parseInt(numberString);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>구구단</title></head>");
		out.println("<body><ul>");
		for (int i = 1; i <= 9; i++) {
			out.println("<li>" + number + "x" + i + " = " + (number * i) + "</li>");
		}
		out.println("</ul></body>");
		out.println("</html>");
		
	}
}
