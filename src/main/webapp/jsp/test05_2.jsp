<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	double length = Integer.parseInt(request.getParameter("length"));
	String[] unitArray = request.getParameterValues("unit");
	%>
	
	<h2>변환결과</h2>
	<%= length %>cm 
	<hr>
	<%
	if (unitArray != null) {
		double result = 0;
		for (String unit : unitArray) {
			if (unit.equals("inch")) {
				result = 1;
				%>
				
				<%=result %>in <br>
				
				<%
			} else if (unit.equals("yard")) {
				result = 2;
				out.println(result + "yd <br>");
			} else if (unit.equals("feet")) {
				result = 3;
				%> 
				
				<%=result %>ft <br>
				
				<%
			} else if (unit.equals("m")) {
				result = 4;
				out.println(result + "m <br>");
			}
		}
	} else { %>
			<b>체크박스를 체크하세요!</b>	
	<% } %>
</body>
</html>