<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp연습</title>
</head>
<body>
	<%
	// 주석
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
	%>
	<!-- 웹 소스에서 보이는 주석 -->
	<%--웹 소스에서 안보이는 주석 --%>
	<b>합계 : </b> <u><%=sum %></u>
	
	<input type="text">
	
	<%
		
		List<String> animal = new ArrayList<>();
		animal.add("dog");
	%>
	<b><%=animal.get(0) %></b>
	
	<%!
	private int num = 100;
		public String getHelloWorld() {
			return "Hello world";
		}
	%>
	
	<%=getHelloWorld() %>
	
	<%= num * 10 + 123 %>
</body>
</html>