<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>공인중개사 추가</h1>
		
		<form method="post" action="/lesson04/test02/add_realtor">
			<label>상호명</label> <input type="text" name="office"><br>
			<label>전화번호</label> <input type="text" name="phoneNumber"><br>
			<label>주소</label> <input type="text" name="address"><br>
			<label>등급</label> <input type="text" name="grade"><br>
			
			<button type="submit">추가</button>
		</form>
		
	</div>

</body>
</html>