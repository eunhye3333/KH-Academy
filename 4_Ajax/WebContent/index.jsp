<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery-3.6.0.min.js"></script>
<style>
	.test{border: 1px solid orange; min-height: 70px;}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1>jQuery를 이용한 Ajax 구현</h1>
	<h3>1. 버튼 선택 시 전송 값 서버에 출력</h3>
	이름 : <input type="text" id="myName">
	<button id="nameBtn">이름 전송</button>
	<script>
		$('#nameBtn').on('click', function() {
			var myName = $('#myName').val(); 
			
			$.ajax({
				url: 'jQueryAjax1.do',
				data: {name:myName}, // name이라는 변수에 myName 값을 집어넣겠다
				type: 'get',
				success: function(data) {
					console.log('서버 전송 성공 시 호출되는 함수');
				}, 
				error: function() {
					console.log('서버 전송 실패 시 호출되는 함수');
				},
				complete: function() {
					console.log('서버 전송 성공/실패 여부와 상관없이 무조건 호출되는 함수');
				}
			});
		});
	</script>
	
	<h3>2. 버튼 선택 시 서버에서 보낸 값 사용자가 수신</h3>
	<button id="getServerTextBtn">서버에서 보낸 값 확인</button>
	<p class="test" id="p1"></p>
	<script>
		$('#getServerTextBtn').click(function() {
			$.ajax({
				url: 'jQueryAjax2.do',
				success: function(data) {
					console.log(data); // 보낸 값이 찍히게 됨
					$('#p1').text(data);
				}, 
				error: function(data) {
					console.log(data);
				}
			});
		});
	</script>
	
	<h3>3. 서버로 기본형 전송 값이 있고 결과로 문자열을 받아 처리</h3>
	<h4>두 개의 값을 더한 결과를 받아옴</h4>
	첫 번째 숫자 : <input type="text" id="firstNum"><br>
	두 번째 숫자 : <input type="text" id="secondNum"><br>
	<button id="plusBtn">더하기</button>
	<p class="test" id="p2"></p>
	<script>
		$('#plusBtn').click(function() {
			var firstNum = $('#firstNum').val();
			var secondNum = $('#secondNum').val();
			
			$.ajax({
				url: 'jQueryAjax3.do',
				data: {firstNum:firstNum, secondNum:secondNum},
				success: function(data) {
					console.log(typeof data); // 넘길 때 println으로 넘어가기 때문에 String 타입이 됨
					// 현재 p 태그에만 넘기는 것은 타입이 상관없지만 넘어온 후 연산이 필요하다면 파싱을 또 해줘야 함
					$('#p2').text(data);
				}, 
				error: function(data) {
					console.log(data);
				}
			});
		});
	</script>
	
	<h3>4. Object 형태의 데이터를 서버에 전송, 서버에서 처리 후 서버 console로 출력</h3>
	학생 1 : <input type="text" id="student1"><br>
	학생 2 : <input type="text" id="student2"><br>
	학생 3 : <input type="text" id="student3"><br>
	<button id="studentTest">결과 확인</button>
	<script>
		// 학생 1, 2, 3의 이름을 받아와 ajax를 통해 jQueryAjax4.do로 넘기고
		// 해당 서블릿에서 콘솔에 학생들 이름 출력
		$('#studentTest').click(function() {
			var student1 = $('#student1').val();
			var student2 = $('#student2').val();
			var student3 = $('#student3').val();
			
			var students = {student1:student1, student2:student2, student3:student3}; // 분리해서 써도 됨
			
			$.ajax({
				url: 'jQueryAjax4.do',
				data: students,
				success: function(data) {
					console.log('통신 성공');
				}, 
				error: function(data) {
					console.log('통신 실패');
				}
			});
		});
	</script>
	
	<h3>5. 서버로 기본형 데이터 전송, 서버에서 객체 반환</h3>
	<h4>유저 번호 보내서 해당 유저 정보 가져오기</h4>
	유저 번호 : <input type="text" id="userNo"><br>
	<button id="getUserInfoBtn">정보 가져오기</button>
	<p class="test" id="p3"></p>
	<textarea class="test" id="textarea3" cols="40" rows="5"></textarea>
	<script>
		$('#getUserInfoBtn').click(function() {
			$.ajax({
				url: 'jQueryAjax5.do',
				data: {userNo:$('#userNo').val()},
				success: function(data) {
					console.log(data);
					console.log(typeof data);
					
					var resultStr = null;
					if(data != null){
						resultStr = data.userNo + ", " + data.userName + ", " + data.userNation;
						// 넘어온 data가 객체가 아니라 String이기 때문에 이렇게 작성하면 받아올 수 없음 (String을 객체처럼 활용할 수 없기 때문)
						// 보내고자 하는 것이 기본 자료형이면 그냥 보내면 되는데 객체를 보내는 경우에는 JSON으로 보내야 함
					} else {
						resultStr = '해당 회원이 없습니다.';
					}
					
					$('#p3').text(resultStr);
					$('#textarea3').val(resultStr);
				}, 
				error: function(data) {
					console.log(data);
				}
			});
		});
	</script>
	
	<h3>6. 서버로 기본 값 전송, 서버에서 리스트 객체 반환</h3>
	<h4>유저 번호 요청 --> 해당 유저가 있는 경우 유저 정보, 없는 경우 전체 가져오기</h4>
	유저 번호 : <input type="text" id="userNo2"><br>
	<button id="getUserInfoBtn2">정보 가져오기</button>
	<p class="test" id="p4"></p>
	<textarea class="test" id="textarea4" cols="40" rows="5"></textarea>
	<script>
		$('#getUserInfoBtn2').click(function() {
			$.ajax({
				url: 'jQueryAjax6.do',
				data: {userNo:$('#userNo2').val()},
				success: function(data) {
					console.log(data); // 배열을 가지고 옴
					var resultStr = "";
					for(var i in data){
						var user = data[i];
						resultStr += user.userNo + ", " + user.userName + ", " + user.userNation + "<br>";
						resultStr2 += user.userNo + ", " + user.userName + ", " + user.userNation + "\n";
					}
					
					$('#p4').html(resultStr);
// 					$('#textarea4').val(resultStr); // 줄바꿈이 안 되고 <br>이 보임
					$('#textarea4').val(resultStr2); // <p>에 넣을 때랑 <textarea>에 넣을 때랑 줄바꿈 표시가 다름
				},
				error: function(data) {
					console.log(data);
				}
			});
		});
	</script>
	
	<h3>7. 서버로 데이터 여러 개 전송, 서버에서 리스트 객체 반환</h3>
	<h4>유저 번호 전송 --> 현재 있는 유저 정보만 모아서 출력</h4>
	<h4>10 이상의 숫자는 ','로 쓸 수 없다고 설정</h4>
	유저 번호(번호, 번호, 번호) : <input type="text" id="userNo3"><br>
	<button id="getUserInfoBtn3">정보 가져오기</button>
	<textarea class='test' id='textarea5' cols="40" rows="5"></textarea>
	<script>
		$('#getUserInfoBtn3').click(function() {
			$.ajax({
				url: 'jQueryAjax7.do',
				data: {userNo:$('#userNo3').val()},
				success: function(data){
					console.log(data);
					
					var result = '';
					
					for(var i in data.list){ // 이렇게 해야 배열이 나타남
						result += data.list[i].userNo  + ", " +  data.list[i].userName + ", " + data.list[i].userNation + "\n";
					}
					
					$('#textarea5').val(result);
				},
				error: function(data){
					console.log(data);
					
				}
			});
		});
	</script>
	
	<h3>8. 서버 유저 정보로 표 구성하기</h3>
	<button id="userInfoBtn">유저 정보 불러오기</button>
	<table id="userInfoTable" border='1' cellpadding='0' cellspacing='0'>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국적</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<script>
		$('#userInfoBtn').click(function() {
			$.ajax({
				url: 'jQueryAjax8.do',
				success: function(data) {
					console.log(data);
					
					var $tableBody = $('#userInfoTable tbody'); // 변수 앞에 $를 붙이면 jQuery를 이용해서 만든 값이 들어가있다는 것을 구분할 수 있음
					// 해당 변수가 제이쿼리를 통해서 집어넣은 객체다라고 구분하기 위해 사용, 따로 기능이 생기는 것은 아니고 구분하기 위한 용어
					
					$tableBody.html(''); // 비워 주는 것이기 때문에 여러 번 눌러도 이어붙여서 나오지 않게 됨
					
					$.each(data, function(index, value) {
						var $tr = $('<tr>');
						var $noId = $('<td>').text(value.userNo);
						var $nameId = $('<td>').text(value.userName);
						var $nationId = $('<td>').text(value.userNation);
						
						$tr.append($noId);
						$tr.append($nameId);
						$tr.append($nationId);
						
						$tableBody.append($tr);
					});
				},
				error: function(data) {
					console.log(data);
				}
			});
		});
	</script>
	
	<h3>9. 서버에서 List 객체 반환받아 select 태그를 이용해서 보여줌</h3>
	유저 이름 : <input type="text" id="selectUserName">
	<button id="selectListBtn">검색</button>
	<select id="selectListTest"></select>
	<script>
		$('#selectListBtn').click(function() {
			$.ajax({
				url: 'jQueryAjax8.do',
				success: function(data) {
					console.log(data);
					
					$select = $('#selectListTest');
					$select.find('option').remove(); // 이어서 쌓이지 않게 option을 지워줌
					
					for(var i = 0; i < data.length; i++){
						var name = data[i].userName;
						var selected = (name == $('#selectUserName').val()) ? 'selected' : '';
						
						$select.append('<option value="' + data[i].userNo + '" ' + selected + ">" + name + "</option>"); // val로 넣을 수도 있지만 option을 직접 써도 됨
					}
					
				},
				error: function(data) {
					console.log(data);
				}
			});
		});
	</script>
	
	<h3>10. Gson을 이용한 List 반환</h3>
	<button id="gsonListBtn">list 가져오기</button>
	<select id="gsonListSelect"></select>
	<script>
		$('#gsonListBtn').click(function() {
			$.ajax({
				url: 'jQueryAjax9.do',
				success: function(data) {
					console.log(data);
					
					$select = $('#gsonListSelect');
					$select.find('option').remove();
					
					for(var i in data){
						var $option = $('<option>');
						$option.val(data[i].userNo);
						$option.text(data[i].userName);
						
						$select.append($option);
					}
				},
				error: function(data) {
					console.log(data);
				}
			});
		});
	</script>
</body>
</html>