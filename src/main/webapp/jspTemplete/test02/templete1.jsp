<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

	<style>
		#wrap {width:1200px; height:800px; margin:auto}
		nav {height:50px}
		header {height:80px}
		section {height:500px}
		footer {height:80px}
	</style>
</head>
<body>
	<%@ include file="data.jsp" %>

	<div id="wrap">

		<jsp:include page="header.jsp" />
		<jsp:include page="menu.jsp" />
		<section>
			<article class="d-flex">
				<img width="150" src="<%=artistInfo.get("photo") %>">
				<div>
					<%=artistInfo.get("name") %> <br>
					<%=artistInfo.get("agency") %> <br>
					<%=artistInfo.get("debute") %> 데뷔
				</div>
			</article>
		
			<article>
				<table class="table" border="1">
					<thead>
						<tr>
							<th>no</th>
							<th>제목</th>
							<th>앨범</th>
						</tr>
					</thead>
					<tbody>
	<% for (Map<String, Object> info : musicList) {
		%>		
						<tr>
							<td><%=info.get("id") %></td>
							<td>
								<a href="/jspTemplete/test02/templete2.jsp?id=<%=info.get("id") %>">
									<%=info.get("title") %>
								</a>
							</td>
							<td><%=info.get("album") %></td>
						</tr>			
		
	  	<%	
		}
	%>
		
					</tbody>
				</table>
			</article>
		</section>

		<jsp:include page="footer.jsp" />

	</div>
</body>
</html>