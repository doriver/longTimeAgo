<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userId = request.getParameter("user_id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
	%>
	
	<b>아이디 : </b> <%=userId%> 
	<b>이름 : </b>
	<b>나이 : </b>

</body>
</html>