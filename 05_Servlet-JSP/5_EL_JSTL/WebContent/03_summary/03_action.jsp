<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="p" class="action.model.vo.Person" scope="request"/>
	<h2>개인 정보 입력 결과(JSP표준액션)</h2>
	<table>
		<tr>
			<td>성명</td>
			<td><jsp:getProperty property="name" name="p"/></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><jsp:getProperty property="gender" name="p"/></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><jsp:getProperty property="nai" name="p"/></td>
		</tr>
	</table>
</body>
</html>