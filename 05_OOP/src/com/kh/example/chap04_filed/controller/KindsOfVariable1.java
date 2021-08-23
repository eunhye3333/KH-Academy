package com.kh.example.chap04_filed.controller;

// 변수 선언 위치에 따른 구분
public class KindsOfVariable1 { // <-- 클래스 영역의 시작

	// 클래스 영역에 작성하는 변수 : 필드 = 멤버 변수 = 멤버 필드 = 전역 변수
	private int global; // 선언된 이후부터 끝까지 영향을 미침
	
	public void method1(int num) { // <-- 메소드 영역의 시작
		//              ------- -> 외부에서 데이터를 받아오는 변수 : 매개 변수
		
		// 메소드 영역에 작성하는 변수 : 지역변수
		// 매개 변수도 메소드 안에 있기 때문에 일종의 지역변수로 치부함
		// 지역변수는 선언 외에 다시 사용하기 위해서는 꼭 초기화 필요 -> 쓰레기 값이 들어갈 수 있어서
		// 하지만 예외적으로 매개변수는 초기화가 필요하지 않음
		int local;
//		System.out.println(local); // 선언만 하고 초기화를 하지 않아서 에러 발생(값이 없음)
		System.out.println(num); // 초기화하지 않아도 오류가 안 남
		// 외부에서 데이터를 받아오는 애라서 저 안에는 무조건 값이 있을 수밖에 없기 때문에 초기화를 안 해도 됨
		// 넘어올 때부터 초기화가 된 상태로 봄
		
		System.out.println(global); // 영향을 끼칠 수 있는 범위 안이기 때문에 오류 발생하지 않음
		
	} // <-- 메소드 영역의 끝
	
	public void method2() {
		System.out.println(global); // 글로벌은 여기에서도 영향을 미칠 수 있음
//		System.out.println(local); // 로컬은 method1만 커버하기 때문에 사용 불가능. 사용하는 경우 에러가 발생
//		System.out.println(num);
	}
} // <-- 클래스 영역의 끝
