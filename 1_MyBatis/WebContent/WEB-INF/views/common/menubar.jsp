<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${ contextPath }/js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style>
	#welcome{background: black; text-shadow: -1px -1px 0 red, 1px -1px 0 white, -1px 1px 0 white, 1px 1px 0 white;}
	.login-area {height:100px;}
	.btn-login {height:50px;}
	.loginTable{text-align: right; float: right;}
	#logoutBtns>a{text-decoration: none; color: black;}
	#logoutBtns>a:hover{text-decoration: underline; font-weight: bold;}
	.nav-area{backgrouns: black; height: 50px;}
	.menu{
		display: table-cell; width: 250px; height: 50px; text-align:center;
		vertical-align: middle; font-size: 20px; background: black; color: white;
	}
	.menu:hover{background: orangered; cursor: pointer;}
</style>
</head>
<body>
	<c:set var="contextPath" value="${ pageContext.servletContext.contextPath }" scope="application"/>
	<!-- 어디서든 사용 가능하도록 scope를 application으로 지정 -->
	
	<h1 id="welcome" align="center">Welcome to MyBatis World!!</h1>
	<br>
	
	
	<!-- ----------------------1. 회원 관련 서비스 -------------------------- -->
	<div class="login-area">	  
		<!-- 1_1. 로그인 관련 폼 만들기 -->
		<c:if test="${ empty sessionScope.loginUser }">
			<form action="${ contextPath }/login.me" method="post">
				<table class="loginTable">
					<tr>
						<td>아이디 : </td>
						<td>
							<input type="text" name="userId">
						</td>
						<td rowspan="2">
							<button id="login-btn" class="btn btn-login">로그인</button>
						</td>
					</tr>
					<tr> 
						<td>비밀번호 : </td>
						<td>
							<input type="password" name="userPwd">
						</td>
					</tr>
					<tr>
						<td colspan="3" id="logoutBtns">
							<a href="${ contextPath }/memberInsertForm.me">회원가입</a>
							<a href="${ contextPath }/findMemberForm.me">아이디/비밀번호 찾기</a>
						</td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${ !empty sessionScope.loginUser }">
			<table class="loginTable">
				<tr>
					<td colspan="2"><h3>${ loginUser.nickName }님 환영합니다</h3></td>
				</tr>
				<tr>
					<td><button onclick="location.href='${contextPath}/info.me'">내 정보 보기</button></td>
					<td><button onclick="location.href='${contextPath}/logout.me'">로그아웃</button></td>
				</tr>
			</table>
		</c:if>
	</div>
	
	<!-- 2. 게시판 관련 서비스 -->
	<div class="nav-area" align="center">
		<div class="menu" onclick="location.href='${contextPath}'">HOME</div>
		<div class="menu" onclick="location.href='${contextPath}/selectList.bo'">BOARD</div>
		<div class="menu">etc.</div>
	
	</div>
	
	<script>
		function home(){
			location.href="${ contextPath }";
		}
	</script>
</body>
</html>