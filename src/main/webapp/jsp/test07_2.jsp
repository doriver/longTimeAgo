<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
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
	// Object 로 하면 모든형태들 다 받을수 있음
	List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> map = new HashMap<String, Object>() {{ put("name", "버거킹"); put("menu", "햄버거"); put("point", 4.3); } };
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "BBQ"); put("menu", "치킨"); put("point", 3.8); } };
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "교촌치킨"); put("menu", "치킨"); put("point", 4.1); } };
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "도미노피자"); put("menu", "피자"); put("point", 4.5); } };
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "맥도날드"); put("menu", "햄버거"); put("point", 3.8); } };
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "BHC"); put("menu", "치킨"); put("point", 4.2); } };
    list.add(map);
    map = new HashMap<String, Object>() {{ put("name", "반올림피자"); put("menu", "피자"); put("point", 4.3); } };
    list.add(map);
    
    String menu = request.getParameter("menu");
    String except = request.getParameter("point");
	%>
	
	<h3>검색결과</h3>
	<table class = "table">
		<thead>
			<tr>
				<th>메뉴</th>
				<th>상호</th>
				<th>별점</th>
			</tr>
		</thead>
		<tbody>
			<%
			// 만들어 놓고 조건 넣는게 좋데 , 리스트에서 맵꺼네기
			// 전달받은 메뉴명에 해당하는 맵들을 걸러내야함
			// 리스트 원소인 맵을 하나씩 확인해햐함
			// 출력해야 할껀 전달받은 메뉴명에 해당하는 맵의 상호, 별점
			// out.println(except);  except or null
			// for (Map<String, Object> info : list)
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> info = list.get(i);
				Double point = (Double)info.get("point");
				if (info.get("menu").equals(menu)) {
					if (except != null) {
						if (point > 4) {
							%>
							<tr>
								<td><%=menu %></td>
								<td><%=info.get("name") %></td>
								<td><%=info.get("point") %></td>
							</tr>
						<%			
						}
					} else { %>
						<tr>
							<td><%=menu %></td>
							<td><%=info.get("name") %></td>
							<td><%=info.get("point") %></td>
						</tr>
					<%				
					} 
				}
			}%>
		</tbody>
	</table>
</body>
</html>