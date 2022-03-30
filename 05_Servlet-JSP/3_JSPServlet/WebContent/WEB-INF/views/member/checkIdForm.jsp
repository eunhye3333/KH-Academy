<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="inputValue();">
	<b>아이디 중복 검사</b>
	<br>
	<form action="<%= request.getContextPath() %>/checkId.me" id="idCheckForm">
		<input type="text" id="inputId" name="inputId">
		<input type="submit" value="중복확인">
	</form>
	
	<br>
	
	<%
	Integer result = (Integer)request.getAttribute("result"); // 처음으로 창을 열었을 때는 result라는 값도 없는 상태임 따라서 아무것도 나오면 안 됨
	// null체크를 위해 int가 아니라 Integer에 담아줌
	// int라는 원시값은 null로 사용할 수 없기 때문에 Wrapper 클래스로 바꿔서 사용
	if(result != null) {
		if(result > 0){
	%>
		이미 사용 중인 아이디입니다.
	<% } else{ %>
		사용 가능한 아이디입니다.
	<% } %>
	<%} %>
	
	<br>
	<br>
	
	<input type="button" id="usedId" value="확인">
	<input type="button" id="cancel" value="취소" onclick="window.close();">
	
	<script>
		function inputValue(){
			// int a = 10처럼 특정 공간에 부모한테 있던 값을 가져올게라고 해야 함
// 			document.getElementById('inputId').value = opener.document.joinForm.joinUserId.value; // opener : 나를 열리게 한 부모
			// 페이지가 로드될 때마다 실행됨, 페이지를 불러오면서 위 코드가 계속 실행되기 때문에 input에 있는 값이 계속해서 부모 값으로 덮어씌워짐
			// 위 코드는 result가 null일 때만 실행되어야 함
			
			if(<%= result %> == null){
				document.getElementById('inputId').value = opener.document.joinForm.joinUserId.value;
			} else {
				document.getElementById('inputId').value = '<%= request.getAttribute("checkedId") %>';
			}
		}
		
		document.getElementById('usedId').onclick = function(){
			opener.document.joinForm.joinUserId.value = document.getElementById('inputId').value;
			self.close(); // window.close()도 가능
		}
	</script>
</body>
</html>