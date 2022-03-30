<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color:red;">에러 페이지입니다.</h1>
	<%= exception %><br> <!-- isErrorPage="true"가 있어야 exception을 사용할 수 있기 때문에 안 적어 주면 exception을 알 수 없다는 에러 발생 -->
	<%= exception.getMessage() %><br>
	<%= exception.getClass().getName() %>
	<!-- exception에 대한 메시지, 이름 등 롹인 가능 -->
</body>
</html>