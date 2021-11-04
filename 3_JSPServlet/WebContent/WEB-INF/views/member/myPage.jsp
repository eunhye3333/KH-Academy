<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 	Member m = (Member)request.getAttribute("member"); // menubar에 이미 import 되어 있어서 import 안 해도 에러가 안 남
	Member m = (Member)session.getAttribute("loginUser"); // 세션에서 가져오기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.outer{
		width: 48%; height: 450px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 5%;
	}
	#myForm td {text-align: center;}
	#myForm>table{margin: auto;}
	#updateBtn {background: #D1B2FF; color: white;}
	#updatePwdBtn {background: #FFD8D8; color: white;}
	#deleteBtn {background: #D5D5D5; color: white;}
	#goMain {background: #B2CCFF; color: white;}
</style>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">내 정보 보기</h2>
		
		<form action="<%= request.getContextPath() %>/updateForm.me" method="post" id="myForm" name="myForm">
			<table>
				<tr>
					<td width="200px">아이디</td>
					<td width="200px">
					<%= m.getUserId() %>
						<input type="hidden" maxlength="13" name="myId" required value="<%= m.getUserId() %>">
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
					<%= m.getUserName() %>
						<input type="hidden" name="myName" required value="<%= m.getUserName() %>">
					</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>
					<%= m.getNickName() %>
						<input type="hidden" maxlength="15" name="myNickName" required value="<%= m.getNickName() %>">
					</td>
				</tr>
				<tr>
					<td>연락처</td>
					<td>
					<%= m.getPhone() == null ? "-" : m.getPhone() %>
						<input type="hidden" maxlength="11" name="myPhone" placeholder="(-없이)01012345678" value="<%= m.getPhone() %>">
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
					<%= m.getEmail() == null ? "-" : m.getEmail() %>
						<input type="hidden" name="myEmail" value="<%= m.getEmail() %>">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
					<%= m.getAddress() == null ? "-" : m.getAddress() %>
						<input type="hidden" name="myAddress" value="<%= m.getAddress() %>">
					</td>
				</tr>
				<tr>
					<td>관심분야</td>
					<td>
						<%= m.getInterest() == null ? "-" : m.getInterest() %>
						<input type="hidden" name="myInterest" value="<%= m.getInterest() %>">
					</td>
				</tr>
			</table>
			
			<br>
			
			<div class="myPageBtns" align="center">
				<input id="updateBtn" type="submit" value="수정하기">
				<input id="updatePwdBtn" type="button" value="비밀번호 변경 하기" onclick="location.href='updatePwdForm.me'">
				<input id="deleteBtn" type="button" value="탈퇴하기" onclick="deleteMember();">
				<input type="button" id="goMain" onclick="goMain();" value="메인으로">
			</div>
		</form>
	</div>
	
	<script>
		function deleteMember(){
			// 정말 삭제할거냐고 물어본 후, 삭제하겠다고 하면 delete.me로 요청
			var bool = confirm('정말 탈퇴하시겠습니까?');
			if(bool){
				location.href='<%= request.getContextPath() %>/delete.me';
			}
		}
	</script>
</body>
</html>