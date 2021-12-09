<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>숫자 데이터 포맷 지정 : formatNumber</h3>
	천단위 구분 : <fmt:formatNumber value="123456789"/><br>
	천단위 구분 : <fmt:formatNumber value="123456789" groupingUsed="true"/><br>
	<!-- 자리수 구분 기호가 생김 -->
	
	숫자 그대로 : <fmt:formatNumber value="123456789" groupingUsed="false"/><br>
	<!-- 자리수 구분을 하고 싶지 않은 경우 사용 -->
	
	<br>
	
	<b>실수값 소수점 아래 자리수 지정 : pattern(#, 0)</b><br>
	<fmt:formatNumber value="1.234567"/><br>
	<fmt:formatNumber value="1.234067"/><br>
	<fmt:formatNumber value="1.234567" pattern="#.##"/><br>
	<fmt:formatNumber value="1.238567" pattern="#.##"/><br>
	<fmt:formatNumber value="1.2" pattern="#.##"/><br>
	<fmt:formatNumber value="1.2" pattern="#.00"/><br>
	
	<h3>백분율, 통화 기호 표시 : type</h3>
	<fmt:formatNumber value="0.12" type="percent"/><br> 
	<!-- 0.12에 대한 퍼센트 값이 출력됨 -->
	
	<fmt:formatNumber value="123456789" type="currency"/><br>
	<!-- 앞에 원화 기호 붙일 수 있음 -->
	<fmt:formatNumber value="123456789" type="currency" currencySymbol="$"/><br>
	<!-- 기호 변경 -->
	
	<h3>지역대 설정 : setLocale</h3>
	<fmt:setLocale value="ko_kr"/>
	<fmt:formatNumber value="123456789" type="currency"/><br>
	<!-- 지역이 다른 경우 원화 기호가 아니라 다른 기호가 출력될 수 있음 -->
</body>
</html>