package com.sleep.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/test06")
public class ServletTest06 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		String number1String = request.getParameter("number1");
		String number2String = request.getParameter("number2");
		
		int number1 = Integer.parseInt(number1String);
		int number2 = Integer.parseInt(number2String);
		
		PrintWriter out = response.getWriter();
		
//		{addition: 123, subtraction: 123, mutiplication: 123, division: 4}
		String additionString = "\"addition\":" + (number1 + number2);
		String subtractionString = "\"subtraction\":" + (number1 - number2);
		String mutiplicationString = "\"mutiplication\":" + (number1 * number2);
		String divisionString = "\"division\":" + (number1 / number2);
		
		out.println("{" + additionString + "," + subtractionString + "," + mutiplicationString + "," + divisionString + "}");
		// 여기 쌤은 한번에 한거같아
		
	}
}
