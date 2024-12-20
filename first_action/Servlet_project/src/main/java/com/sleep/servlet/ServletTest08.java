package com.sleep.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/servlet/test08")
public class ServletTest08 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String word = request.getParameter("word");
		
		List<String> list = new ArrayList<>(Arrays.asList(
		        "강남역 최고 맛집 소개 합니다.", 
		        "오늘 기분 좋은 일이 있었네요.", 
		        "역시 맛집 데이트가 제일 좋네요.", 
		        "집에 가는 길에 동네 맛집 가서 안주 사갑니다.",
		        "자축 저 오늘 생일 이에요."));
		//신기하네
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title></title></head>");
		out.println("<body>");
		for(String content : list) {
			if (content.contains(word)) {
				content = content.replace(word, "<b>" + word + "</b>");
				out.println(content + "<hr>");
			}
		}
		out.println("</body></html>");
		
		
	}
}
