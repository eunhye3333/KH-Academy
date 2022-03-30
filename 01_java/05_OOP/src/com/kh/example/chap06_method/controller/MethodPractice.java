package com.kh.example.chap06_method.controller;

import com.kh.example.chap06_method.model.vo.Trainee;

public class MethodPractice {
	// 매개변수 유무와 반환값 유무에 따른 구분
	
	// 1. 매개변수 없고 반환값 없는 메소드
	public void method1() {
		// 반환값x      매개변수x
		String str = "매개변수와 반환값 둘 다 없는 메소드입니다.";
		System.out.println(str);
		// 반환값이 없는 것이고 return문은 존재함. 
		// 생략되어 있음
//		return;
	}
	
	// 2. 매개변수 없고 반환값 있는 메소드
	public int method2() { // This method must return a result of type int 반드시 int 값을 리턴을 해야 한다
		                   // return이 없을 경우 발생
		// 반환값o     매개변수x
//		int i = 0;
//		return i; // 변수명으로 반환
		
		return 0; // 값만으로도 반환 가능
	}
	// 3. 매개변수 있고 반환값 없는 메소드
	public void method3(int num1, int num2) {
		// 반환값x            매개변수 o
		// 매개변수 : 호출하는 쪽에서 넘긴 데이터를 받아오는 역할
		System.out.println(num1);
		System.out.println(num2);
		int sum = num1 + num2;
		System.out.println(sum);
	}
	
	// 4. 매개변수 있고 반환값 있는 메소드
	public String method4(String name, int age) { // 매개변수를 넣을 때는 자리에 맞게 넣어야 함. 막 넣으면 안 됨
		String str = name + "님은 " + age + "살입니다";
		return str;
	}
	
	// 심화 1. 반환 값이 배열일 때
	public char[] method5() {
		char[] chArr = {'j', 'a', 'v', 'a'}; // 선언과 동시에 초기화
		System.out.println("MethodPractice chArr : " + chArr); // chArr 주소값
		
		return chArr;
	}
	
	// 심화 2. 반환 값이 클래스일 때
	public Trainee method6() { // import 해주어야 함
		Trainee t = new Trainee("강건강", 'H', "오전", 98.5);
		System.out.println("MethodPractice t : " + t);
		return t;
	}
}
