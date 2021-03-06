<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<h1 align="center">Spring에서의 Ajax 사용</h1>
	
	<button onclick="location.href='test.do'">테스트</button>
	
	<ol>
		<li>
			서버 쪽 컨트롤러로 값 보내기 <button id="test1">테스트</button>
			<script>
				$("#test1").on('click', function() {
					$.ajax({
						url: 'test1.do',
						data: {name: '강건강', age:20},
						success: function(data) {
							console.log(data);
							if(data.trim() == 'ok'){
								alert('전송 성공');
							} else if(data.trim() == 'fail'){
								alert('전송 실패');
							}
						},
						error: function(data) {
							console.log(data);
						}
					});
				});
			</script>
		</li>
		
		<li>
			컨트롤러에서 리턴하는 JSON 객체 받아서 출력하기 <button id="test2">테스트</button>
			<div id="d2"></div>
			<script>
				$('#test2').click(function() {
					$.ajax({
						url: 'test2.do',
						dataType: 'json',
						success: function(data) {
							console.log(data);
							
// 							data = JSON.parse(data); // 파싱
							
// 							$('#d2').text(data.no + ", " + data.title + ", " + data.writer + ", " + data.content);
							$('#d2').html('번호 : ' + data.no
										+ '<br>제목 : ' + data.title
// 										+ '<br>작성자 : ' + decodeURIComponent(data.writer)
// 										+ "<br>내용 : " + decodeURIComponent(data.content.replace(/\+/g, ' '))
																							 // /\+/g 정규표현식 (하나가 아니라 모든 +를 바꾸는 것이기 때문에 g 사용)
// 										+ "<br>내용 : " + decodeURIComponent(data.content.replaceAll('+', ' '))); // 더 간단하게 사용
										+ '<br>작성자 : ' + data.writer
										+ "<br>내용 : " + data.content);
						},
						error: function(data) {
							console.log(data);
						}
					});
				});
			</script>
		</li>
		<li>
			컨트롤러에서 리턴하는 JSON 배열을 받아서 출력하기 <button id="test3">테스트</button>
			<div id="d3"></div>
			<script>
				$('#test3').on('click', function() {
					$.ajax({
						url: 'test3.do',
						success: function(data) {
							console.log(data);
							
							var values = '';
							for(var i in data){
								// 방법 1.
// 								document.getElementById('d3').innerHTML += user.userId + ", " + user.userPwd + ", " + user.userName + ", " +  user.age + ", " + user.email + ", " + user.phone + "<br>";
								
								// 방법 2.
// 								var user = data[i];
								
// 								values += user.userId + ", " + user.userPwd + ", " + user.userName + ", " +  user.age + ", " + user.email + ", " + user.phone + "<br>";
								values += data[i].userId + ", " 
										+ data[i].userPwd + ", " 
										+ data[i].userName + ", " 
										+ data[i].age + ", " 
										+ data[i].email + ", " 
										+ data[i].phone + "<br>";
							}
							
							$('#d3').html(values);
						},
						error: function(data) {
							console.log(data);
						}
					});
				});
			</script>
		</li>
	</ol>
</body>
</html>
