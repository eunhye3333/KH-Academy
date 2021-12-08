<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ param.num1 > param.num2 }">
		${ param.num1 } 숫자는 ${ param.num2 }보다 크다
	</c:if>
	<!-- else나 else if가 없기 때문에 조건이 생길 때마다 c:if를 작성해 주어야 함 -->
	<c:if test="${ param.num1 < param.num2 }">
		${ param.num2 } 숫자는 ${ param.num1 }보다 크다
	</c:if>
	<c:if test="${ param.num1 == param.num2 }">
		${ param.num1 } 숫자는 ${ param.num2 } 숫자와 같다
	</c:if>
	<!-- 문자형 비교가 되므로 제대로 비교 불가능 -->
	
	<hr>
	
	<c:if test="${ Integer.parseInt(param.num1) > Integer.parseInt(param.num2) }">
		${ param.num1 } 숫자는 ${ param.num2 }보다 크다
	</c:if>
	<!-- else나 else if가 없기 때문에 조건이 생길 때마다 c:if를 작성해 주어야 함 -->
	<c:if test="${ Integer.parseInt(param.num1) < Integer.parseInt(param.num2) }">
		${ param.num2 } 숫자는 ${ param.num1 }보다 크다
	</c:if>
	<c:if test="${ param.num1 == param.num2 }">
		${ param.num1 } 숫자는 ${ param.num2 } 숫자와 같다
		<!-- 같은 경우에는 형변환하지 않아도 됨 -->
	</c:if>
	
	
</body>
</html>