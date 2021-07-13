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
			곡 정보
			<article class="d-flex">
			<%
			if (request.getParameter("search") == null ) {
				
				int receivedId = Integer.parseInt(request.getParameter("id"));
				
				for (Map<String, Object> info : musicList) {
					
					int id = (Integer)info.get("id");
					
					if (id == receivedId ) { %>
				
					<img width="150" src="<%=info.get("thumbnail") %>">
					<div>
						<%=info.get("title") %> <br>
						<%=info.get("singer") %> <br>
						<small>
							앨범 <%=info.get("album") %> <br>
							재생시간 <%=((Integer)info.get("time")) / 60 %>:<%=((Integer)info.get("time")) % 60 %> <br>
							작곡가 <%=info.get("composer") %> <br>
							작사가 <%=info.get("lyricist") %>
						</small>
					</div>
					<%				
					}
				}	
			} else {
				
				for (Map<String, Object> info : musicList) {
						
					if (info.get("title").equals(request.getParameter("search"))) { %>
				
					<img width="150" src="<%=info.get("thumbnail") %>">
					<div>
						<%=info.get("title") %> <br>
						<%=info.get("singer") %> <br>
						<small>
							앨범 <%=info.get("album") %> <br>
							재생시간 <%=((Integer)info.get("time")) / 60 %>:<%=((Integer)info.get("time")) % 60 %> <br>
							작곡가 <%=info.get("composer") %> <br>
							작사가 <%=info.get("lyricist") %>
						</small>
					</div>
					<%				
					}
				}	
			}%>
			
			
				
			</article>
		
			<article>
			가사 <hr>
			가사정보 없음
			<hr>
			</article>
		</section>

		<jsp:include page="footer.jsp" />

	</div>
</body>
</html>