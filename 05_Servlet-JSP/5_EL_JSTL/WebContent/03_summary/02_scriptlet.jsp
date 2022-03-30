<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="action.model.vo.Person"%>
<%
	Person p = (Person)request.getAttribute("p");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개인 정보 입력 결과(scriptlet)</h2>
	<table>
		<tr>
			<td>성명</td>
			<td><%= p.getName() %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%= p.getGender() %></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%= p.getNai() %></td>
		</tr>
	</table>
</body>
</html>