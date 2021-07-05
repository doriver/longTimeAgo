<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="java.lang.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
	//SimpleDateFormat format = new SimpleDateFormat("yyyy년 M월 d일 .HH시 m분 s초");
	//String formatDate = format.format(now);
	//String day = formatDate.split(".")[0];             .이 특수부호라서 안됐음 딴 부호로 하면 됨
	//String time = formatDate.split(".")[1]; 

	String what = request.getParameter("what");

	Date now = new Date();
	
	String text = null;
	if (what.equals("time")) {
		SimpleDateFormat format = new SimpleDateFormat("현재시간 H시 m분 s초");
		text = format.format(now);
	} else {
		SimpleDateFormat format = new SimpleDateFormat("현재날짜 yyyy년 M월 d일");
		text = format.format(now);
	}
	%>
	
	<%=text %>
	
	
</body>
</html>