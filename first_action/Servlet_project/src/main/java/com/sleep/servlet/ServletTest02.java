package com.sleep.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest02 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
		
		PrintWriter out = response.getWriter();
		// 질문 해볼까                HttpServletResponse에 있는 함수일꺼같아
		
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH시 mm분 ss초"); // 24시간 기준은 대문자
		String formatDate = format.format(now);
		out.println("현재시간은 " + formatDate + "입니다.");
	}
}
