<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pizza = (String)request.getAttribute("orderPizza");
	String[] topping = (String[])request.getAttribute("orderTopping"); // 배열로 받아옴
	String[] side = (String[])request.getAttribute("orderSide");
	int total = (int)request.getAttribute("total");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>주문 내역</h2>
	<h3>
		피자는 <span style="color: red;"><%= pizza %></span> 
		토핑은 
		<span style="color: green;">
			<%
				for(int i = 0; i < topping.length; i++){ // 배열을 보냈기 때문에 배열 자체로 for문 돌림
					if(i == 0){
				// 스크립틀릿을 갈라서 작성, 분리해서 작성 가능
			%>
						<%= topping[i] %>
			<%
					} else {
			%>
						, <%= topping[i] %>
			<%
					}
				}
			%>
		</span>
		사이드는
		<span style="color: blue">
			<%
				for(int i = 0; i < side.length; i++){
					if(i == 0){
						out.println(side[i]);
					} else {
						out.println(", " + side[i]);
					}
				}
			%>
		</span>
		주문하셨습니다.
		
		<br><br><br>
		
		총합 : <span style="text-decoration: underline;"><%= total %></span>원
	</h3>
	
	<br><br>
	
	<h2 style="color: pink;">즐거운 식사시간 되세요~</h2>
</body>
</html>