<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%
	Date now = new Date();
	String today = String.format("%tY년 %tm월 %td일 %tA", now, now, now, now);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style>
	table, tr, td, th {
		border: 1px solid black;
		border-collapse: collapse;
	}
	
	tr {
		height: 45px;
	}
	
	td:not(.price):not(.type){
		padding-left: 10px;
	}
	
	.type {
		text-align: center;
	}
	
	.price {
		text-align: center;
	}
</style>
</head>
<body>
	<h1>오늘은 <span style="color: pink"><%= today %></span>입니다.</h1>
	<br>
	<h1>피자 아카데미</h1>
	<table>
		<tr>
			<th width="60px">종류</th>
			<th width="150px">이름</th>
			<th width="50px">가격</th>
			<td rowspan="12"></td>
			<th width="60px">종류</th>
			<th width="150px">이름</th>
			<th width="50px">가격</th>
		</tr>
		<tr>
			<td rowspan="5" class="type">피자</td>
			<td class="menu">치즈피자</td>
			<td class="price">5000</td>
			<td rowspan="11" class="type">사이드</td>
			<td class="menu">오븐구이통닭</td>
			<td class="price">9000</td>
		</tr>
		<tr>
			<td class="menu">콤비네이션피자</td>
			<td class="price">6000</td>
			<td class="menu">치킨스틱&윙</td>
			<td class="price">4900</td>
		</tr>
		<tr>
			<td class="menu">포테이토피자</td>
			<td class="price">7000</td>
			<td class="menu">치즈오븐스파게티</td>
			<td class="price">4000</td>
		</tr>
		<tr>
			<td class="menu">고구마피자</td>
			<td class="price">7000</td>
			<td class="menu">새우링&웨지감자</td>
			<td class="price">3500</td>
		</tr>
		<tr>
			<td class="menu">불고기피자</td>
			<td class="price">8000</td>
			<td class="menu">갈릭포테이토</td>
			<td class="price">3000</td>
		</tr>
		<tr>
			<td rowspan="6" class="type">토핑</td>
			<td class="menu">고구마무스</td>
			<td class="price">1000</td>
			<td class="menu">콜라</td>
			<td class="price">1500</td>
		</tr>
		<tr>
			<td class="menu">콘크림무스</td>
			<td class="price">1500</td>
			<td class="menu">사이다</td>
			<td class="price">1500</td>
		</tr>
		<tr>
			<td class="menu">파인애플토핑</td>
			<td class="price">2000</td>
			<td class="menu">갈릭소스</td>
			<td class="price">500</td>
		</tr>
		<tr>
			<td class="menu">치즈토핑</td>
			<td class="price">2000</td>
			<td class="menu">피클</td>
			<td class="price">300</td>
		</tr>
		<tr>
			<td class="menu">치즈크러스트</td>
			<td class="price">2000</td>
			<td class="menu">핫소스</td>
			<td class="price">100</td>
		</tr>
		<tr>
			<td>치즈바이트</td>
			<td class="price">3000</td>
			<td>파마산 치즈가루</td>
			<td class="price">100</td>
		</tr>
	</table>
	
	<br><br>
	
	<form id="pizzaForm" action="/2_JSP/orderPizza.do" method="post">
		피자 : 
		<select name="pizza">
			<option value="치즈피자" price="5000">치즈피자</option>
			<option value="콤비네이션피자" price="6000">콤비네이션피자</option>
			<option value="포테이토피자" price="7000">포테이토피자</option>
			<option value="고구마피자" price="7000">고구마피자</option>
			<option value="불고기피자" price="8000">불고기피자</option>
		</select>
		
		<br>
		
		토핑 : 
		<input type="checkbox" name="topping" value="고구마무스" price="1000">고구마무스
		<input type="checkbox" name="topping" value="콘크림무스" price="1500">콘크림무스
		<input type="checkbox" name="topping" value="파인애플토핑" price="2000">파인애플토핑
		<input type="checkbox" name="topping" value="치즈토핑" price="2000">치즈토핑
		<input type="checkbox" name="topping" value="치즈크러스트" price="2000">치즈크러스트
		<input type="checkbox" name="topping" value="치즈바이트" price="3000">치즈바이트
		
		<br>
		
		사이드 : 
		<input type="checkbox" name="side" value="오븐구이통닭" price="9000">오븐구이통닭
		<input type="checkbox" name="side" value="치킨스틱&윙" price="4900">치킨스틱&윙
		<input type="checkbox" name="side" value="치즈오븐스파게티" price="4000">치즈오븐스파게티
		<input type="checkbox" name="side" value="새우링&웨지감자" price="3500">새우링&웨지감자
		<input type="checkbox" name="side" value="갈릭포테이토" price="3000">갈릭포테이토
		<input type="checkbox" name="side" value="콜라" price="1500">콜라
		<input type="checkbox" name="side" value="사이다" price="1500">사이다
		<input type="checkbox" name="side" value="갈릭소스" price="500">갈릭소스
		<input type="checkbox" name="side" value="피클" price="300">피클
		<input type="checkbox" name="side" value="핫소스" price="100">핫소스
		<input type="checkbox" name="side" value="파마산치즈가루" price="100">파마산치즈가루
		<input type="hidden" name="totalPrice" id="total">
		<br><br>
		
		<button type="submit" id="confirm">확인</button>
	</form>
	
	<script>
		var sum = 0;
		
		$('input').click(function() {
			var price = Number($(this).attr('price'));
			if($(this).is(":checked")){
				sum += price;
			} else {
				sum -= price;
			}
		});
		
		$('#pizzaForm').submit(function() {
			var select = $("select[name=pizza]").val();
			var price = Number($("select option[value=" + select + "]").attr('price'));
			
			sum += price;
			
			$('#total').attr('value', sum);
		});
	</script>
</body>
</html>