<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="family" value="신형만,봉미선,신짱구,신짱아"/>
	<c:forTokens items="${ family }" delims="," var="f">
		${ f }
	</c:forTokens>

	<br>

	<c:set var="family2" value="신형만,봉미선.신짱구/신짱아.둘리,또치,도우너.희동/길동"/>
	<!-- 여러 개의 구분자 -->	
	<c:forTokens items="${ family2 }" delims=",/." var="f">
		${ f }
	</c:forTokens>
</body>
</html>