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
		<h1>학생정보 추가</h1>
		
		<form method="get" action="/lesson04/ex02/add_student">
			<label>이름</label> <input type="text" name="name"><br>
			<label>휴대폰번호</label> <input type="text" name="phoneNumber"><br>
			<label>이메일 주소</label> <input type="text" name="email"><br>
			<label>장래희망</label> <input type="text" name="dreamJob"><br>
			
			<button type="submit">추가</button>
		</form>
		
	</div>


</body>
</html>