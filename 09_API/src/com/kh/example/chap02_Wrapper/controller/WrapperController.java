package com.kh.example.chap02_Wrapper.controller;

public class WrapperController {
	public void method1() {
		int num1 = 10; // 원시 타입
		Integer integer1 = new Integer(num1); // 원시 타입 -> 클래스 타입 : boxing
		int num2 = integer1.intValue(); // 클래스 타입 -> 원시 타입 : unboxing
		// 옛날 버전
		
		// JDK1.5부터 오토박싱/오토언박싱 제공
		Integer integer2 = num1; // new로 객체를 만들지 않아도 됨. auto-boxing
		int num3 = integer2; // auto-unboxing
		// 옛날에는 이렇게 쓰면 에러 
	}
}
