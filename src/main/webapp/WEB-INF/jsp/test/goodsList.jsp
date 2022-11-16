<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Goods List</title>
</head>
<body>

<c:forEach var="goods" items="${goodsList }">
	
	<h4>
		${goods }<br>
		${goods.id }. ${goods.title } 
	</h4>
		
	</div>
	<div>
		${goods.price }
	</div>
	<div>
		${goods.description }
	</div>
	<div>
		${goods.picture }
	</div>
	<div>
		${goods.sellerId }
	</div>
</c:forEach>

</body>
</html>