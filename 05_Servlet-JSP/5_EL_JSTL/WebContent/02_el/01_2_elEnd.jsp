<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="action.model.vo.Person"%>
<%
	Person person = (Person)request.getAttribute("person");
	String beverage = (String)request.getAttribute("beverage");
	int year = (int)request.getAttribute("year");
	String[] products = (String[])request.getAttribute("products");
	String book = (String)request.getAttribute("book");
	String movie = (String)request.getAttribute("movie");
	
	String name = person.getName();
	char gender = person.getGender();
	int age = person.getNai();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>scriptlet을 통해 request 객체에 저장된 데이터 출력하기</h2>
	<h4>개인 정보(<%= year %>)</h4>
	이름 : <%= name %><br>
	성별 : <%= gender %><br>
	나이 : <%= age %><br>
	<h4>취향정보</h4>
	<%= name %> 님이 가장 좋아하는 음료 : <%= beverage %><br>
	<%= name %> 님이 가장 좋아하는 물건 : <% for(int i = 0; i < products.length; i++) { %>
								   <%	if(i == 0) { %>
								   			<%=	products[i] %>
								   <%	} else {%>
								   			<%= ", " + products[i] %>
								   <%	} %>
								   <%} %><br>
<%-- 	<%= name %> 님이 가장 좋아하는 도서 : <%= book %><br> --%>
<%-- 	<%= name %> 님이 가장 좋아하는 영화 : <%= movie %><br> --%>
	<!-- book과 movie는 각각 session, application 영역에 존재하는데 값을 가져온 건 request 영역에서 가지고 왔기 때문에 null이 출력됨 -->
	<%= name %> 님이 가장 좋아하는 도서 : <%= session.getAttribute("book") %><br>
	<%= name %> 님이 가장 좋아하는 영화 : <%= application.getAttribute("movie") %><br>
	<!-- 단순 출력이므로 형변환 하지 않음 -->
	<hr>
	
	<h2>el의 내장  객체 XXXScope를 통해 저장된 데이터 출력하기</h2>
	<h4>개인 정보(${ requestScope.year })</h4>
	이름 : ${ requestScope.person.name }<br> <!-- requestScope.person까지만 적으면 주소값이 나오게 됨 따라서 getter 사용하지 않고 바로 변수에 접근 -->
	성별 : ${ requestScope.person.gender }<br>
	나이 : ${ requestScope.person.nai }<br>
	<h4>취향정보</h4>
	${ requestScope.person.name } 님이 가장 좋아하는 음료 : ${ requestScope.beverage }<br>
	${ requestScope.person.name } 님이 가장 좋아하는 물건 : ${ requestScope.products[0] }, ${ requestScope.products[1] }, ${ requestScope.products[2] }<br>
	${ requestScope.person.name } 님이 가장 좋아하는 도서 : ${ requestScope.book }<br>
	${ requestScope.person.name } 님이 가장 좋아하는 영화 : ${ requestScope.movie }<br>
	<!-- 스클립틀릿과 다르게 값이 없는 영역은 아무것도 출력 안 됨 -->
	${ requestScope.person.name } 님이 가장 좋아하는 도서 : ${ sessionScope.book }<br>
	${ requestScope.person.name } 님이 가장 좋아하는 영화 : ${ applicationScope.movie }<br>
	
	<hr>
	
	<h2>scope 생략하여 저장된  데이터 출력하기</h2>
	<p>
		el 내장객체 pageScope, requestScope, sessionScope, applicationScope 생략 가능<br>
		<!-- 생략한다고 하면 모든 스코프를 뒤져 봐야 함  -->
		el은 pageScope -> requestScope -> sessionScope -> applicationScope 순으로 데이터를 찾음<br>
		여러 scope에 동일한 속성을 기록해서 이름 충돌이 의심되면 명시적으로 scope를 지정해야 해당 scope의 속성을 가져올 수 있음
	</p>
	<h4>개인 정보(${ year })</h4>
	이름 : ${ person.name }<br> 
	성별 : ${ person.gender }<br>
	나이 : ${ person.nai }<br>
	<h4>취향정보</h4>
	${ person.name } 님이 가장 좋아하는 음료 : ${ beverage }<br>
	${ person.name } 님이 가장 좋아하는 물건 : ${ products[0] }, ${ products[1] }, ${ products[2] }<br>
	${ person.name } 님이 가장 좋아하는 도서 : ${ book }<br>
	${ person.name } 님이 가장 좋아하는 영화 : ${ movie }<br>
	${ person.name } 님이 가장 좋아하는 도서 : ${ book }<br>
	${ person.name } 님이 가장 좋아하는 영화 : ${ movie }<br>
</body>
</html>