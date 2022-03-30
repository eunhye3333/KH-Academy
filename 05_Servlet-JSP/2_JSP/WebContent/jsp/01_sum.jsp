<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- HTML 주석 : 완벽하게 숨겨지는 것이 아니라 화면에서만 안 보이게 해 줌 페이지 소스보기로 볼 수 있음 -->
	<%-- JSP 주석 : 소스 보기에서도 볼 수 없음, 클라이언트에게 전달이 되지 않는 주석 --%>
	
	<% 
		// 스크립트릿에는 자바 코드 사용 가능, 주석도 //로 사용
		// 화면에서 볼 수 없음
		int total = 0;
		
		for(int i = 1; i <= 10; i++){
			total += i;
//			out.println("안녕<br>"); // println을 썼다고 줄바꿈이 되지는 않음 <br>을 넣어야 함
			// out : JSP에서 사용 가능한 내장 객체
	%>
		반가워<br>
	<%
		} // 중간을 끊어서 넣어도 됨 반가워가 for문에 들어가 있는 것
		System.out.println("또 보자"); // 웹에서 출력되는 것이 아니라 콘솔에 출력됨
	%>
	
	expression 출력 : 1부터 10까지의 합은 <%= total %> 입니다.
	<br>
	<br>
	scriptlet 출력 : 1부터 10까지의 합은 <% out.println(total); // 세미콜론 꼭 붙여야 함 %> 입니다.
</body>
</html>