<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, java.util.HashMap"%>
<%@ page import="java.util.HashSet" errorPage="error/errorPage.jsp"%>
<%--
	page 지시어 : 현재 JSP 페이지에서 필요한 속성을 기술하는 부분, 보통 맨 위에 위차
		language		사용할 스크립트 언어 유형 지정
		contentType		브라우저가 받아볼 페이지 인코딩 방식
		pageEncoding	JSP 파일에 기록된 소스코드 자체의 인코딩 방식
		--> 기본적인 것들
		import			자바의 import와 동일, 유일하게 여러 번 사용 가능하며, 한 번에 여러 개 값 import 가능
		errorPage		현재 JSP 페이지에서 오류가 발생했할 경우 호출할 페이지 지정
		isErrorPage		오류를 처리할 페이지에 설정, false 기본값, true로 지정하면 exception이라는 내장 객체 사용 가능
		--> 추가 설정 가능
 --%>
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
		
		ArrayList<String> list = new ArrayList<String>(); // import를 하지 않아서 오류가 발생 -> java 파일이 아니라 JSP 파일이라서 ctrl + shift + o로 import 안됨
		// page 지시어에 직접 import로 적어 줘야 함
		
		HashMap<String, String> map = new HashMap<String, String>();
		HashSet<String> set = new HashSet<String>();
		
		list.add(0, null);
		System.out.println(list.get(0).charAt(0)); // null에서 charAt()을 사용하려고 했기 때문에 java.lang.NullPointerException 발생
	%>
	
	expression 출력 : 1부터 10까지의 합은 <%= total %> 입니다.
	<br>
	<br>
	scriptlet 출력 : 1부터 10까지의 합은 <% out.println(total); // 세미콜론 꼭 붙여야 함 %> 입니다.
</body>
</html>