<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리</title>
</head>
<body>
	<h2>변수 정의하기 c:set var value</h2>
	<c:set var="number1" value="100"/>
	<c:set var="number2">200</c:set>
	<h4>number1 : ${number1 }</h4>
	<h4>number2 : ${number2 }</h4>
	<h4>number1 + number2 = ${number1 + number2 }</h4>
	
	<h2>변수 출력하기 c:out value escapeXml</h2>
	<h4><c:out value="10"/></h4>
	<h4><c:out value="${number1 }"/></h4>
	<c:out value="<script>alert('출력');</script>"/>
	<c:out value="<script>alert('뜬다')</script>" escapeXml="false"/> <%--스크립트가 실행 --%>
	
	<h2>조건문 c:if test</h2>
	<c:if test="true">
		<h4>조건 참이면 나옴</h4>
	</c:if>
	
	<c:if test="${number1 > 50 }">
		<h4>number1이 50보다 크다</h4>
	</c:if>
	
	<c:if test="${number1 == 100 }">
		<h4>number1은 100이다</h4>
	</c:if>
	
	<c:if test="${number1 eq 100 }">
		<h4>number1은 100이다</h4>
	</c:if>
	
	<c:if test="${!empty number1 }">
		<h4>number1은 비어있지 않다</h4>
	</c:if>

</body>
</html>