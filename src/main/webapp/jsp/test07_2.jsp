<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
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
	<table>
		<tr>
			<td>메뉴</td>
			<td>상호</td>
			<td>별점</td>
		</tr>
		<%
		// 만들어 놓고 조건 넣는게 좋데 , 리스트에서 맵꺼네기
		// 전달받은 메뉴명에 해당하는 맵들을 걸러내야함
		// 리스트 원소인 맵을 하나씩 확인해햐함
		// 출력해야 할껀 전달받은 메뉴명에 해당하는 맵의 상호, 별점
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> info = list.get(i);
			Double point = (Double)info.get("point");
			if (list.get(i).containsValue(menu) && except.equals("except") ) {
				if (point > 4) {	%>				
				<tr>
					<td><%=menu %></td>
					<td><%=list.get(i).get("name") %></td>
					<td><%=list.get(i).get("point") %></td>
				</tr>
				
					<%
				}
			} else if (list.get(i).containsValue(menu)) { %>
				<tr>
					<td><%=menu %></td>
					<td><%=list.get(i).get("name") %></td>
					<td><%=list.get(i).get("point") %></td>
				</tr>
				<%
			}
		}
		%>
		
		
	</table>
</body>
</html>