<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sleep.common.MysqlService" %>
<%@ page import="java.sql.ResultSet" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<%
	MysqlService mysqlService = MysqlService.getInstance();
	mysqlService.connection();
	String query = "select * from `new_user`;";
	ResultSet resultSet = mysqlService.select(query);
%>
	<div class="container">
		<table class="table text-center">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>생년월일</th>
					<th>자기소개</th>
					<th>이메일</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<% while(resultSet.next()) { %>
				<tr>
					<td><%=resultSet.getInt("id") %></td>
					<td><%=resultSet.getString("name") %></td>
					<td><%=resultSet.getString("yyyymmdd") %></td>
					<td><%=resultSet.getString("introduce") %></td>
					<td><%=resultSet.getString("email") %></td>
					<td>
						<a href="/db/ex02_delete?id=<%=resultSet.getInt("id") %>" class="btn btn-danger">삭제</a>
					</td>
				</tr>
			<%} %>
			</tbody>
		</table>
	</div>

</body>
</html>