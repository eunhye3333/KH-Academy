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
	<%
		String[] nameArr = {"신형만", "봉미선", "신짱구", "신짱아"};
		request.setAttribute("family", nameArr);
		
		for(String f : nameArr){
	%>
		<%= f %>
	<%
		}
	%>
	
	<br>
	
	<!-- request 영역의 family 속성에 값을 담았기 때문에 EL에서 family라는 이름으로 접근 가능 -->
	<c:forEach items="${ family }" var="f">
		${ f }
	</c:forEach>
	
	<br>
	
	<!-- c:set을 이용하여 배열 지정 가능 -->
	<c:set var="alphabet">
		a, b, c, d, e, f, g
	</c:set>
	
	<c:forEach items="${ alphabet }" var="a" varStatus="vs">
		${ a }<br>
		vs.first : ${ vs.first }<br>
		vs.last : ${ vs.last }<br>
		vs.index : ${ vs.index }<br> 
		vs.count : ${ vs.count }<br>
		vs.current : ${ vs.current }<br><br>
	</c:forEach>
</body>
</html>