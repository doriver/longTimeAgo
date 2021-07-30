<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl core라이브러리</title>
</head>
<body>
	<c:set var="number1" value="36" />
	<c:set var="number2">3</c:set>
	
	<div>첫번째 수 : ${number1 }</div>
	<div>두번째 수 : ${number2 }</div>
	
	<div>더하기 : ${number1 + number2 }</div>
	<div>빼기 : ${number1 - number2 }</div>
	<div>곱하기 : ${number1 * number2 }</div>
	<div>나누기 : ${number1 / number2 }</div>
	
	<c:out value="<title>core out</title>" />
	
	<!-- 
	<c:set var="avg"> ${(number1 + number2) / 2 }</c:set> 
	이렇게 하면 [class java.lang.String] to [class java.lang.Long]이런 오류났음
	 -->
	<c:set var="avg" value="${(number1 + number2) / 2 }"/>
	
	<c:if test="${avg >= 10}">
		<h1>${avg }</h1>
	</c:if>
	
	<c:if test="${avg < 10 }">
		<h3>${avg }</h3>
	</c:if>
	
	<c:if test="${(number1 * number2) > 100 }">
		<c:out value="<script>alert('너무큰수입니다')</script>" escapeXml="false"/>
	</c:if>

</body>
</html>