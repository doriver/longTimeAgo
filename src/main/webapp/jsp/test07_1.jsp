<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 메뉴 명을 입력 받고 해당하는 가게 리스트를 보여주는 기능 -->
	<form method="post" action="jsp/test07_2.jsp">
		<h3>메뉴검색</h3>
		<input type="text" name="menu">
		<input type="checkbox" name="point" value="except">4점이하 제외 <br>
		<input type="submit" value="검색">
	</form>
</body>
</html>