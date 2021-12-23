<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 위 부분이 없으면 글자가 깨짐 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>#tb{margin: auto; width: 700px;}</style>
</head>
<body>
	<c:import url="common/menubar.jsp"/>
	
	<h1 align="center">게시글 TOP5 목록</h1>
	<table id="tb" border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
				<th>첨부파일</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	
	<script>
		function topList() {
			$.ajax({
				url: 'topList.bo',
				success: function(data) {
					console.log(data);
					
					$tableBody = $('#tb tbody');
					$tableBody.html('');
					
					var $tr;
					var $no;
					var $title;
					var $writer;
					var $date;
					var $count;
					var $file;
					
					for(var i in data){
						$tr = $('<tr>');
						$no = $('<td align="center">').text(data[i].boardId);
						$title = $('<td>').text(data[i].boardTitle);
						$writer = $('<td width="100" align="center">').text(data[i].nickName);
						$date = $('<td width="100" align="center">').text(data[i].boardCreateDate);
						$count = $('<td align="center">').text(data[i]. boardCount);
						
						var hasFile = data[i].originalFileName;
						
						if(typeof hasFile == "undefined"){
							$file = $('<td>').text('');
						} else {
							$file = $('<td align="center">').text('◎');
						}
						
						console.log(data[i].originalFileName);
						
						$tr.append($no);
						$tr.append($title);
						$tr.append($writer);
						$tr.append($date);
						$tr.append($count);
						$tr.append($file);
						
						$tableBody.append($tr);
					}
				},
				error: function(data) {
					console.log(data);
				}
			});
		}
		
		$(function() {
			topList();
			
			setInterval(function() {
				topList();
			}, 5000);
		});
		
	</script>
</body>
</html>
