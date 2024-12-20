<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/jsp/test05_2.jsp">
		<h2>길이변환</h2>
		<input type="text" class="form-control" name="length"><span>cm</span> <br>
		
		<label>인치<input type="checkbox" name="unit" value="inch"></label>
		<label>야드<input type="checkbox" name="unit" value="yard"></label>
		<label>피트<input type="checkbox" name="unit" value="feet"></label> 
		<label>미터<input type="checkbox" name="unit" value="m"></label> <br>
		
		<input type="submit" value="변환">
	</form>

</body>
</html>