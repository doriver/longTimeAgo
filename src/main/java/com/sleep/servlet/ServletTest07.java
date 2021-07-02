package com.sleep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test07")
public class ServletTest07 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String address = request.getParameter("address");
		String card = request.getParameter("card");
		String priceString = request.getParameter("price");
		
		int price = Integer.parseInt(priceString);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>배탈의 민족</title></head>");
		out.println("<body>");
		if (!address.contains("서울시")) {
			out.println("배달불가 지역입니다.");
		} else if (card.equals("신한카드")) {
			out.println("결제불가 카드입니다.");
		} else {
			out.println("<b>" + address + ",배달 준비중. </b> <hr>");
			out.println("결제금액 : " + price);
		}
		out.println("</body></html>");
		
		
	}
}
