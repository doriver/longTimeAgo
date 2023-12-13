package com.sleep.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test10")
public class ServletTest10 extends HttpServlet{
	private final Map<String, String> userMap =  new HashMap<String, String>() {
	    {
	        put("id", "hagulu");
	        put("password", "asdf");
	        put("name", "김인규");
	    }
	};
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>로그인 결과</title></head>");
		out.println("<body>");
//		out.println(id);
//		out.println(userMap.get("id"));
//		out.println(userMap.get("id") != id);
		
		if (! userMap.get("id").equals(id)) {
			out.println("id가 일치하지 않습니다.");
		} else if (! userMap.get("password").equals(password)) {
			out.println("password가 일치하지 않습니다");
		} else {
			out.println("<h1>" + userMap.get("name") + "님 환영합니다 <h1>");			
		}
		out.println("</body></html>");
	}
}
