<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- c라는 이름으로 사용하겠다고 해서 앞에 c라는 접두어를 붙이는 것, 만약 prefix를 core라고 쓴다면 아래 실제 사용할 때도 core를 접두어로 붙여줘야 함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jstl core라이브러리</h1>
	<p>
		사용할 태그 라이브러리 선언하기 : taglib 지시자 사용<br>
		prefix : 앞 첨자, 다른 태그와 구분할 수 있는 name space<br>
		uri    : 실제 웹상 주소가 아니라 태그 라이브러리를 나타내는 식별자
	</p>
	<h2>c:set 태그</h2>
	<c:set var="no1" value="${ param.num1 }"/>
	<c:set var="no2" value="${ param.num2 }"/>
	${ param.num1 }
	${ param.num2 }
	${ no1 }
	${ no2 }<br>
	<!-- 변수로 설정했기 때문에 이헐게 쓸 수 있음 -->
	
	<br>
	
	<c:set var="result" value="${ no1 * no2 }"/>
	${ no1 } 곱하기 ${ no2 }의 값은? ${ result }입니다.
	
	<hr>
	
	<h2>c:remove</h2>
	<p>지정한 변수를 모든 scope에서 검색해 삭제하거나 지정한 scope에서 삭제</p>
	<c:set var="result" value="9999" scope="request"/>
	삭제 전 result : ${ result }<br>
	삭제 전 requestScope.result : ${ requestScope.result }<br>
	
	<br>
	
<%-- 	<c:remove var="result"/> --%>
	<!-- 둘 다 삭제됨 -->
<%-- 	<c:remove var="result" scope="request"/> --%>
	<!-- 두 번째 것만 지워짐 -->
	<c:remove var="result" scope="page"/>
	<!-- 둘 다 9999가 출력 => page에 있는 속성이 사라졌기 때문에 처음 부분에서도 request에 저장된 값을 불러오게 됨 -->
	삭제 후 result : ${ result }<br>
	삭제 후 requestScope.result : ${ requestScope.result }<br>
	
</body>
</html>