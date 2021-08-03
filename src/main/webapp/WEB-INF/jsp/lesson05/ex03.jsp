<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="number" value="123456789" />
	<h3>숫자 출력</h3>
	<div>
		<fmt:formatNumber value="${number }" />
	</div>
	
	<div>
		<fmt:formatNumber value="${number }" type="number"/>
	</div>
	
	<div>
		<fmt:formatNumber value="1" type="percent"/>
	</div>
	
	<div>
		<fmt:formatNumber value="0.35" type="percent"/>
	</div>
	
	<div>
		<fmt:formatNumber value="${number }" type="currency"/>
		<fmt:formatNumber value="${number }" type="currency" currencySymbol="$" />
	</div>
	 
	<div>
		<fmt:formatNumber value="3.14565891" pattern="#.##"/>
		<fmt:formatNumber value="3.14565891" pattern="#.##############"/>
		<fmt:formatNumber value="4.123456" pattern="0.00" />
		<fmt:formatNumber value="4.123456" pattern="0.0000000000000000" />
	</div>

</body>
</html>