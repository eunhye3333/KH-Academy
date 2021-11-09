<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="board.model.vo.Board, board.model.vo.PageInfo, java.util.ArrayList"%>
<%
	ArrayList<Board> list = (ArrayList)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
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
	.tableArea{width:650px;	height:350px; margin-left:auto;	margin-right:auto;}
	th{border-bottom: 1px solid grey;}
	.pagingArea button{border-radius: 15px; background: #D5D5D5;}
	.buttonArea{margin-right: 50px;}
	.buttonArea button{background: #D1B2FF; border-radius: 5px; color: white; width: 80px; heigth: 25px; text-align: center;}
	button:hover{cursor: pointer;}
	#numBtn{background: #B2CCFF;}
	#choosen{background: #FFD8D8;}
	#listArea{margin: auto;}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">게시판</h2>
		<div class="tableArea">
			<table id="listArea">
				<tr>
					<th width="100px">글번호</th>
					<th width="100px">카테고리</th>
					<th width="300px">글제목</th>
					<th width="100px">작성자</th>
					<th width="100px">조회수</th>
					<th width="150px">작성일</th>
				</tr>
				<% if(list.isEmpty()) { %>
				<tr>
					<td colspan="6">조회된 리스트가 없습니다.</td>
				</tr>
				<% } else { 
						for(Board b : list) { %>
							<tr>
								<td><%= b.getBoardId() %></td>
								<td><%= b.getCategory() %></td>
								<td><%= b.getBoardTitle() %></td>
								<td><%= b.getNickName() %></td>
								<td><%= b.getBoardCount() %></td>
								<td><%= b.getModifyDate() %></td>
							</tr>
					<% 	}
				   } %>
			</table>
		</div>
		
		<div class="pagingArea" align="center">
			<!-- 버튼 종류 -->
			<!-- 맨 처음으로 -->
			<button onClick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=1'">&lt;&lt;</button>
			
			<!-- 이전 페이지로 -->
<%-- 			<button onClick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getCurrentPage() - 1 < 1 ? 1 : pi.getCurrentPage() - 1  %>'">&lt;</button> --%>
			<button id="beforeBtn" onClick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getCurrentPage() - 1 %>'">&lt;</button>
			<script>
				if(<%= pi.getCurrentPage() %> <= 1) {
					$('#beforeBtn').prop('disabled', true);
				}
			</script>
			
			<!-- 숫자 버튼 -->
			<% for(int p = pi.getStartPage(); p <= pi.getEndPage(); p++){ %>
			<%		if(p == pi.getCurrentPage()){ %>
						<button id="choosen" disabled><%= p %></button>
			<%		} else{ %>
						<button id="numBtn" onclick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= p %>'"><%= p %></button>
						<!-- 제대로 한다면 id가 아니라 class로 들어가는게 맞음, 지금은 이 아이디를 쓸 일이 없어서 그냥 쓴 것  -->
			<% 		} %>
			<%	} %>
			
			<!-- 다음 페이지로 -->
<%-- 			<button onClick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getCurrentPage() + 1 > pi.getMaxPage() ? pi.getMaxPage() : pi.getCurrentPage() + 1 %>'">&gt;</button> --%>
			<button id="afterBtn" onClick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getCurrentPage() + 1 %>'">&gt;</button>
			<script>
				if(<%= pi.getCurrentPage() %> >= <%= pi.getMaxPage() %>) {
					$('#afterBtn').prop('disabled', true);
				}
			</script>
			
			<!-- 맨 끝으로 -->
			<button onClick="location.href='<%= request.getContextPath() %>/list.bo?currentPage=<%= pi.getMaxPage() %>'">&gt;&gt;</button>
		</div>
		
		<div class="buttonArea" align="right">
			<% if(loginUser != null) { %>
				<button onclick="location.href='<%= request.getContextPath() %>/writeBoardForm.bo'">작성하기</button>
			<% } %>
		</div>
	</div>
	<script>
		$('#listArea td').mouseenter(function() {
			$(this).parent().css({'background':'darkgray', 'cursor':'pointer'});
		}).mouseout(function() {
			$(this).parent().css('background', 'none');
		}).click(function() {
			var bId = $(this).parent().children().eq(0).text();
			
			if('<%= loginUser %>' != 'null'){
				location.href='<%= request.getContextPath() %>/detail.bo?bId=' + bId;
			} else {
				alert('회원만 이용할 수 있는 서비스입니다.');
			}
		});
	</script>
</body>
</html>