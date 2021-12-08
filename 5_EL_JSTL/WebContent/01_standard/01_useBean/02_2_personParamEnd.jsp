<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 표준 액션 태그 중 useBean의 param 속성 이용하기</h2>
	<!-- person이라는 이름의 Person 객체 생성 -->
	<jsp:useBean id="person" class="action.model.vo.Person">
		<!-- person 객체 안에 있더라도 name을 적어 주어야 함 -->
<%-- 		<jsp:setProperty property="name" name="person" param="name"/>  --%>
		<!-- 이때 param="name"은 input의 이름 -->
<%-- 		<jsp:setProperty property="gender" name="person" param="gender"/> --%>
<%-- 		<jsp:setProperty property="nai" name="person" param="nai"/> --%>

		<!-- property와 param의 값이 같기 때문에 param을 써 주지 않아도 동일한 이름의 값을 알아서 가져옴 -->
<%-- 		<jsp:setProperty property="name" name="person"/>  --%>
<%-- 		<jsp:setProperty property="gender" name="person"/> --%>
<%-- 		<jsp:setProperty property="nai" name="person"/> --%>
		
		<!-- 전체 변수를 한 번에 세팅하는 경우 *를 이용하여 한 줄로 작성 가능 -->
		<jsp:setProperty property="*" name="person"/>
	</jsp:useBean>
	
	이름 : <jsp:getProperty property="name" name="person"/><br>
	성별 : <jsp:getProperty property="gender" name="person"/><br>
	나이 : <jsp:getProperty property="nai" name="person"/><br>
</body>
</html>