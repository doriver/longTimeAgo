package com.sleep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/ex05")
public class ServletEx05 extends HttpServlet{
	// doPost로 하면 html에서 이동했을때 
	// http://localhost:8080/servlet/ex05로 뒤에 ?~~ 가 안나옴
	// 원래 한글은 꺠져서 나오는데 filter만들어서 해주니까 한글도 제대로 출력됨
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>회원정도</title></head>");
		out.println("<body>");
		out.println("<table border=1>");
		out.println("<tr><th>아이디</th><td>" + userId + "</td></tr>");
		out.println("<tr><th>이름</th><td>" + name + "</td></tr>");
		out.println("<tr><th>생년월일</th><td>" + birth + "</td></tr>");
		out.println("<tr><th>이메일</th><td>" + email +"</td></tr>");
		out.println("</table></body></html>");
	}
}
