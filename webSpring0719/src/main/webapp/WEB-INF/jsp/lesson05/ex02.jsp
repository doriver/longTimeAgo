<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl core 라이브러리</title>
</head>
<body>
	<h2>조건문 if, else if, else (choose, when, otherwise)</h2>
	<c:set var="weight" value="60" />
	<c:choose>
		<c:when test="${weight <= 70 }">
			<div>치킨먹자</div>
		</c:when>
		<c:when test="${weight <= 80 }">
			<div>샐러드 먹자</div>
		</c:when>
		<c:otherwise>
			<div>굶어</div>
		</c:otherwise>
	</c:choose>
	
	<h2>반복문 (forEach)</h2>
	<!-- 
	for(int i = 0; i <= 4; i++) {}
	 -->
	<c:forEach var="i" begin="0" end="4" step="1">
		${i }
	</c:forEach>
	<br>
	<c:forEach var="i" begin="16" end="20" step="1" varStatus="status">
		${i } ${status.current } ${status.first } ${status.last } ${status.count } ${status.index } <br>
	</c:forEach>
	<!-- for(String fruit : fruits){} -->
	<c:forEach var="fruit" items="${fruits }" varStatus="status">
		<div>${fruit} ::::: ${status.count } ${status.index }</div>
	</c:forEach>
	
	
	<c:forEach var="user" items="${users }" varStatus="status">
		<h3>${status.count }번째 사람 정보</h3>
		<ul>
			<li>이름 : ${user.name }</li>
			<li>나이 : ${user.age }</li>
			<li>취미 : ${user.hobby }</li>
		</ul>
	</c:forEach>
	
	
</body>
</html>