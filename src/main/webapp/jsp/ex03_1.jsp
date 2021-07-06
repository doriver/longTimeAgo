<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post method</title>
</head>
<body>
	<form method="post" action="/jsp/ex03_2.jsp">
		1.type="text" <input type="text" name="hobby"> <br><br>
		2.type="radio"<br>
		<label>강아지<input type="radio" name="pet" value="dog"></label>
		<label>고양이<input type="radio" name="pet" value="cat"></label>
		<label>고슴도치<input type="radio" name="pet" value="hedgehog"></label> <br><br>
		3.type="checkbox" <br>
		<label>민트초코<input type="checkbox" name="food" value="mincho"></label>
		<label>피자<input type="checkbox" name="food" value="pizza"></label>
		<label>번데기<input type="checkbox" name="food" value="pupa"></label> <br><br>
		4.select <br>
		<select name="fruit">
			<option value="apple">사과</option>
			<option value="banana">바나나</option>
			<option>복숭아</option>
			<option>딸기</option>
		</select> <br>

		<input type="submit" value="제출">
	</form>
</body>
</html>