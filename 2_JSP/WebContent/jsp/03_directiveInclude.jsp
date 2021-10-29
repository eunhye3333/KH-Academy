<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<%
	Date now = new Date();
	String today = String.format("%tY년 %tm월 %td일 %tA", now, now, now, now);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		오늘 날짜 <span style="color: lightgray;"><%= today %></span><br>
		<!-- 중간에 JSP 코드가 있기 때문에 전체 주석처리 할 경우 HTMl 주석 처리를 하면 JSP 부분은 주석이 안 됨 짜라서 JSP 주석 처리해야 함 -->
		오늘 날짜 <span style="color: lightgray"><%@ include file="today.jsp" %></span>
	</h2>
</body>
</html>