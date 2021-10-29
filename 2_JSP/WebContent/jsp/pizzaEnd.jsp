<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String pizza = (String)request.getAttribute("pizza");
	String topping = (String)request.getAttribute("topping");
	String side = (String)request.getAttribute("side");
	String totalPrice = (String)request.getAttribute("totalPrice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	#pizza {
		color: red;
	}
	
	#topping {
		color: green;
	}
	
	#side {
		color: blue;
	}
	
	#price {
		text-decoration: underline;
	}
</style>
</head>
<body>
	<h3>주문 내역</h3>
	<b>피자는 <span id="pizza"><%= pizza %></span>, 토핑은 <span id="topping"><%= topping %></span>, 사이드는 <span id="side"><%= side %></span> 주문하셨습니다.</b>
	
	<br><br><br>
	
	<b>총합 : <span id="price"><%= totalPrice %>원</span></b>
	
	<h3 style="color: pink">즐거운 식사시간 되세요 ~</h3>
	
	<script>
		$(function() {
			var top = '<%= topping %>';
			var sid = '<%= side %>';
			if(top == '없음'){
				$('#topping').css('color', 'black');
			}
			
			if(sid == '없음'){
				$('#side').css('color', 'black');
				
			}
		});
	</script>
</body>
</html>