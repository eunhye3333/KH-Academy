<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, notice.model.vo.Notice"%>
<%
	ArrayList<Notice> list = (ArrayList)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.outer{
		width: 800px; height: 500px; background: rgba(255, 255, 255, 0.4); border: 5px solid white;
		margin-left: auto; margin-right: auto; margin-top: 50px;
	}
	#listArea{text-align: center;}
	.tableArea{width:650px; height:350px; margin:auto;}
	th{border-bottom: 1px solid grey;}
	#writeNoBtn{background: #B2CCFF;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">공지사항</h2>
		<div class="tableArea">
			<table id="listArea">
				<tr>
					<th>글번호</th>
					<th width="300px">글제목</th>
					<th width="100px">작성자</th>
					<th>조회수</th>
					<th width="100px">작성일</th>
				</tr>
				<% if(list.isEmpty()) {%>
				<tr>
					<td colspan="5">존재하는 공지사항이 없습니다.</td>
				</tr>
				<%} else { 
// 					for(Notice i : list){
					for(int i = 0; i < list.size(); i++){%>
						<tr>
							<td><%= /* i.getNoticeNo()*/ list.get(i).getNoticeNo() %></td>
							<td><%= /* i.getNoticeTitle() */ list.get(i).getNoticeTitle() %></td>
							<td><%= /* i.getNoticeWriter() */ list.get(i).getNoticeWriter() %></td>
							<td><%= /* i.getNoticeCount() */ list.get(i).getNoticeCount() %></td>
							<td><%= /* i.getNoticeDate() */ list.get(i).getNoticeDate() %></td>
						</tr>
					<%} %>
				<%} %>
			</table>
		</div>
		
		<div align="right">
		<% if(loginUser != null && loginUser.getUserId().equals("admin")){ // 로그인 안 된 경우 에러 방지를 위해 null 체크 %>
					<input type="button" id="writeNoBtn" value="글쓰기" onclick="location.href='<%= request.getContextPath() %>/writeNoticeForm.no'">
		<%} %>
		</div>
	</div>
	
	<script>
		$('#listArea td').mouseenter(function() {
			$(this).parent().css({'background':'darkgray', 'cursor':'pointer'});
		}).mouseout(function() {
			$(this).parent().css({'background':'none'});
			
		}).click(function() {
			var num = $(this).parent().children().eq(0).text();
			location.href='<%= request.getContextPath() %>/detail.no?no=' + num;
			// 받아온 num을 no에 쿼리스트링처럼 연결하겠다
		});
	</script>
</body>
</html>