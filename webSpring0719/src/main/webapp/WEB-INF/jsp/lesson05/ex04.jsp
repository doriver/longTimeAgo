<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="str1" value="no pain, no gain." />
	
	<div>
	길이구하기
	${fn:length(str1) }
	</div>
	
	<div>
	특정 문자열 있는지 확인
	${fn:contains(str1,"no") }
	${fn:contains(str1,"No") }
	${fn:containsIgnoreCase(str1,"No") }
	</div>
	
	<c:if test="${fn:containsIgnoreCase(str1,'No') }">
		<div>대소문자 구분없이 NO를 확인</div>
	</c:if>
	
	<div>
	특정문자열로 시작, 끝나는지?
	${fn:startsWith(str1, "no") }
	${fn:endsWith(str1,"gain.") }
	</div>
	
	
	<c:set var="str2" value="i love chicken" />
	
	<div>
	문자열 치환
	${fn:replace(str2, "chicken", "bread")}
	${str2 }
	</div>
	
	<div>
	문자열을 구분자로 쪼개기
	${fn:split(str2, " ")[0] }--
	${fn:split(str2, " ")[1] }--
	${fn:split(str2, " ")[2] }
	</div>
	
	<div>
	문자열 자르기
	${fn:substring(str2, 2, 6) }
	</div>
	
	<div>
	모두 소문자로 변환
	${fn:toLowerCase(str2) }
	</div>

	<div>
	모두 대문자로 변환
	${fn:toUpperCase(str2) }
	</div>
	
	<c:set var="str3" value="     hello        " />
	
	<div>
	앞뒤 공백 자르기
	<pre>${str3 }</pre>
	<pre>${fn:trim(str3) }</pre>
	</div>
	
</body>
</html>