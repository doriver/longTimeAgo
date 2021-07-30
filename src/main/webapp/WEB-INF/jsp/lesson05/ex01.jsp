<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>변수정의 set</h3>
	<c:set var="number1">200</c:set>
	<c:set var="number2">300</c:set>
	<div>number1 : ${number1}</div>
	
	<div>${number1 + number2}</div>
	
	<c:out value="<script>alert('출력')</script>" />
	<!--<c:out value="<script>alert('출력')</script>" escapeXml="false" />
	-->
	
	<h2>조건문 if</h2>
	
	<c:if test="true">
		<div>조건이 참이다</div>
	</c:if>
	
	<c:if test="${number1 > 50 }">
		<div>number1은 50보다 크다</div>
	</c:if>
	
	<c:if test="${number1 == 100 }">
		<div>number1은 100이다</div>
	</c:if>

	<c:if test="${number1 eq 100 }">
		<div>number1은 100이다</div>
	</c:if>

	<c:if test="${number1 ne 100 }">
		<div>number1은 100아님</div>
	</c:if>
	
	<c:if test="${empty number1 }">
		<div>number1 비어있다</div>
	</c:if>
	
	<c:if test="${!empty number1 }">
		<div>number1은 비어있지 않다</div>
	</c:if>
	
	
</body>
</html>