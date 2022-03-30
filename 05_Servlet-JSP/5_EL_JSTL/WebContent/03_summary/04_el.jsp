<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개인 정보 입력 결과(EL)</h2>
	<table>
		<tr>
			<td>성명</td>
			<td>${ p.name }</td>
		</tr>
		<tr>
			<td>성별</td>
			<td>${ p.gender }</td>
		</tr>
		<tr>
			<td>나이</td>
			<td>${ p.nai }</td>
		</tr>
	</table>
</body>
</html>