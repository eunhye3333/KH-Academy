<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#pwdTable{margin: auto;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>
	<h1 align="center">비밀번호 수정</h1>
	<form action="${ contextPath }/mPwdUpdate.me" method="post"> 
	<!-- onsubmit="return pwdCheck();"-->
		<table id="pwdTable">
			<tr>
				<td>* 현재 비밀번호</td>
				<td><input type="password" name="userPwd" required></td>
			</tr>
			<tr>
				<td>* 새 비밀번호</td>
				<td><input type="password" name="newPwd" required></td>
			</tr>
			<tr>
				<td>* 새 비밀번호 확인</td>
				<td><input type="password" name="newPwd2" required></td>
			</tr>
			<tr>
				<td colspan="2">
					<div align="center">
						<br>
						<input type="submit" value="수정하기">
						<button type="reset">취소</button>
					</div>
				</td>
			</tr>
		</table>
	</form>
<script>
// 	function pwdCheck() {
// 		var newPwd1 = document.getElementsByName("newPwd");
// 		var newPwd2 = document.getElementsByName("newPwd2");
		
// 		if(newPwd1.value == newPwd2.value){
// 			return true;
// 		} else {
// 			alert("비밀번호가 서로 다릅니다.");
// 			newPwd2.focus();
// 			return false;
// 		}
// 	}
</script>
</body>
</html>