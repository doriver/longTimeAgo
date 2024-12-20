<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>java 제어문 활용</title>
</head>
<body>
	 <%
	 Map<String, Integer> scoreMap = new HashMap<>();
	 scoreMap.put("korean",85);
	 scoreMap.put("english",72);
	 scoreMap.put("math",85);
	 scoreMap.put("science",65);
	 %>
	
	 <table border="1">
	
	 <%
	 Set<String> keys = scoreMap.keySet();
	 for (String key : keys) { %>
	 	<tr>
	 		<td>
	 		<%
				if (key.equals("korean")) { %>
					국어 
				<%
				}
			%>
			</td>
	 		<td><%=scoreMap.get(key) %></td>
	 	</tr>
	 <%	 
	 }
	 %>
	
	 </table>
	 
</body>
</html>