<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test01</title>
</head>
<body>
	<%
	int[] scores = {80, 90, 100, 95, 80};
	int sum = 0;
	for (int i = 0; i < scores.length; i++) {
		sum += scores[i];
	}
	double average = sum / (double)scores.length;
	%>
	<h3>제 평균은 <%=average%> 입니다</h3>
	<!-- 서버가 할일은 최소화 하는게 좋음 , 그래서 자바쪽을 간단하게 하는게 좋음 -->
	<%
	List<String> scoreList = Arrays.asList(new String[]{"X", "O", "O", "O", "X", "O", "O", "O", "X", "O"});
	sum = 0;
	for (String answer : scoreList) {
		if (answer.equals("O")) {
			sum += 10;
		}
	}
	//int score = sum;
	%>
	<h3>체점결과는 <%=sum%>점 입니다.</h3>
	
	<%!
	
	public int getSum(int number) {
		int sum = 0;
		for (int i = 1; i <= number; i++) {
			sum += i;
		}
		return sum;
	}
	%>
	<h3>1에서 50까지의 합은 <%=getSum(50)%></h3>
	
	<%
	String birthDay = "20010820";
	int year = Integer.parseInt(birthDay.substring(0, 4));
	int age = 2021 - year + 1;
	%>
	<h3><%=birthDay %>의 나이는 <%=age%>살 입니다.</h3>
</body>
</html>