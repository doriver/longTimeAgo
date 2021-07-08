<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// Date : 날짜와 시간을 저장하는 클래스
		// Calendar : Date객체를 포함하고, 날짜 계산을 수월하게 해주는 클래스
		Calendar today = Calendar.getInstance();
		out.println(today);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		out.println(format.format(today.getTime()) + "<br>");
		
		//어제 날짜 출력
		today.add(Calendar.DATE, -100);
		out.println(format.format(today.getTime()) + "<br>");
		
		today.add(Calendar.MONTH, -5);
		out.println(format.format(today.getTime()) + "<br>");
		
		today.add(Calendar.YEAR, -6);
		out.println(format.format(today.getTime()) + "<br>");
	%>

</body>
</html>