<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center;">
		<h1>Error</h1>
		<!-- error가 난 것처럼 보여줌, 단순 msg에 대한 데이터 출력 -->
		<h2 style="color: red;"><%= request.getAttribute("msg") %></h2>
		<!-- 진짜 error가 발생 -->
		<h2 style="color: blue;"><%= request.getAttribute("javax.servlet.error.message") %></h2>
		<a href="home.do">시작 페이지로 돌아가기</a>
	</div>
</body>
</html>