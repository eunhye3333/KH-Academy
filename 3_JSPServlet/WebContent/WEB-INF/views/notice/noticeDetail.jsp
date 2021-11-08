<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="notice.model.vo.Notice" %>
<%	Notice n = (Notice)request.getAttribute("notice"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.outer{
		width: 600px; height: 500px; background-color: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	.tableArea {width:450px; height:350px; margin-left:auto; margin-right:auto;}
	#updateNoBtn{background: #D1B2FF;}
	#cancelBtn{background: #B2CCFF;}
	#deleteNoBtn{background: #D5D5D5;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">공지사항</h2>
		<div class="tableArea">
			<form action="<%= request.getContextPath() %>/noticeUpdateForm.no" id="detailForm" name="detailForm" method="post">
				<table>
					<tr>
						<th>제목</th>
						<td colspan="3" width="300px">
							<%= n.getNoticeTitle() %>
							<input type="hidden" size="50" name="title" value="<%= n.getNoticeTitle() %>">
						</td>				
					</tr>
					<tr>
						<th>작성자</th>
						<td>
							<%= n.getNickName() %>
							<input type="hidden" name="nickName" value="<%= n.getNickName() %>">
						</td>
						<th>작성일</th>
						<td>
							<%= n.getNoticeDate() %>
							<input type="hidden" name="date" value="<%= n.getNoticeDate() %>">
						</td>
					</tr>
					<tr>
						<th>내용</th>
					</tr>
					<tr>
						<td colspan="4">
							<textarea name="content" cols="60" rows="15" style="resize:none;" readonly><%= n.getNoticeContent() %></textarea> 
							<input type="hidden" name="no" value="<%= n.getNoticeNo() %>">
						</td>
					</tr>
				</table>
			
				<br>
				
				<div align="center">
				<% if(loginUser != null && loginUser.getNickName().equals(n.getNickName())) { %>
					<input type="submit" id="updateNoBtn" value="수정">
					<input type="button" id="deleteBtn" value="삭제" onclick="deleteNotice()">
				<% } %>
					<input type="button" onclick="location.href='javascript:history.go(-1);'" id="cancelBtn" value="취소">
				</div>
			</form>
		</div>
	</div>
	
	<script>
		function deleteNotice(){
			var bool = confirm('정말 삭제하시겠습니까?');
			if(bool){
// 				location.href='delete.no'; // 단순하게 delete.no로 href 즉, 주소만 바꿔준 것이기 때문에 parameter로 넘기고 싶은 값들이 넘어가지 않음
				// 따라서 내가 파라미터로 값을 넘기고 싶으면 form을 이용하여 넘겨야 하기 때문에 form에 대한 action 값을 바꿔 주고 그 form에 대해 submit을 해줘야 함
				$('#detailForm').attr('action', 'delete.no');
				$('#detailForm').submit();
			}
		}
	</script>
</body>
</html>