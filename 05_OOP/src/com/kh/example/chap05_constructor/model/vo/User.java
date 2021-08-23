package com.kh.example.chap05_constructor.model.vo;

import java.util.Date;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private Date enrollDate;
	
	// 생성자의 사용 목적
	//		객체를 생성하면서 필드 초기화하기 위해 사용
	
	// 생성자 특징
	// 		1. 생성자명은 클래스명과 동일(대소문자까지)
	//	 	2. 반환 타입이 존재하지 않음
	
	// 기본 생성자
	// 		아무 매개변수가 없는 생성자
	// 		써 주지 않아도 JVM이 기본적으로 생성해줌
	// 		기본 생성자가 없는 상태에서 매개변수 있는 생성자만 만들어주면 기본 생성자는 자동으로 생성되지 않음
	// 생략되었었던 기본 생성자
	
//	{
//		System.out.println(this); // 모든 생성자에 들어가야 할 내용이라면 초기화블럭 사용하는 것이 더 간편
//	}
	
	public User() {
		// 기본 생성자를 만들고 ctrl + 클릭하면 이 기본 생성자쪽으로 옴
		// 생략되어 있는 경우 생략되어 있어 찾을 수 없기 때문에 클래스를 가리키는 것임
	}
	
	// 매개변수 있는 생성자
	// 		매개변수가 있는 생성자
	// 		넘겨받은 매개변수를 이용하여 필드를 초기화할 경우 사용
	
	public void inform() {
		System.out.println(userId + ", " + userPwd + ", " + userName + ", " + enrollDate);
	}
	
//	private Date editDate;
	
//	public User(String id, String pwd, String name, Date enrollDate, Date editDate) {
//		userId = id;
//		userPwd = pwd;
//		userName = name;
//		enrollDate = enrollDate; // The assignment to variable enrollDate has no effect
//		editDate = editDate;     // 지역변수(매개변수)에 지역변수를 대입함
//		this.enrollDate = enrollDate; 
//		this.editDate = editDate;
//		// 왜 전역 변수를 인식하지 못하는가 -> 해당 생성자는 지역변수의 영역임
//		// 지역변수는 자기 영역 안에 있으면 자기가 우선순위가 됨. 전역변수보다 우선
//		
//	}

//	public User(String id, String pwd, String name, Date date) { // 변수를 8개를 쓰게 됨. 이름을 필드랑 똑같이 만들어서 4개만 쓰면 가독성이 더 좋아짐
//																 // 어떤 변수가 어디에 들어가는지 알 수 있음
//		userId = id;
//		userPwd = pwd;
//		userName = name;
//		enrollDate = date;
//	}
	
	public User(String userId, String userPwd, String userName, Date enrollDate) { // 변수 개수 줄이고 가독성 높이기
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		this(userId, userPwd, userName);
		this.enrollDate = enrollDate;
		
//		this.userId = userId; // 중복됨
//		this.userPwd = userPwd;
//		this.userName = userName;
	}
	
	public User(String userId, String userPwd, String userName) {
//		this.userId = userId;
//		this.userPwd = userPwd;
		this(userId, userPwd); // 중복 방지를 위한 this 생성자. 매개변수가 String 두 개인 생성자를 호출하는 것
		this.userName = userName;
		
//		this.userId = userId;  // 중복됨
//		this.userPwd = userPwd;
	}
	
	public User(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

//	public User(String id, String name) { // 매개변수의 타입, 개수, 순서가 다 같아서 오버로딩 안 됨
//	                                      // 위에 있는 거랑 같은 거라서 에러가 같이 뜸. 이름이 다른 건 소용없음
//		userId = id;
//		userName = name;
//	}
}
