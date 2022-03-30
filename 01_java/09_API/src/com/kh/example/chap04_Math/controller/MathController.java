package com.kh.example.chap04_Math.controller;

import java.util.Random;

public class MathController {
	public void method() {
		// Math 클래스 : 수학 연산을 하기에 유용한 메소드들을 모아놓은 클래스
		// 싱글톤 패턴 구성
		//     static을 이용해 애플리케이션이 시작할 때 딱 한 번만 인스턴스릏 만들어 메모리 할당
		//     딱 한 번 만든 인스턴스를 사용하게끔 만든 패턴
		//     -> 생성자가 private, 모든 멤버가 public static
		//     다른 곳에서는 객체 생성 못 하고, 안에 있는 것은 다 사용 가능하도록 -> 내가 한 번만 만들어 놓으면 너네는 사용만 해라
		
		double num = 4.949;
		double num2 = 4.123;
		
		// 클래스 안에는 여러 가지 상수 필드들도 존재함
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE); // int의 최대값
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Math.abs(-num)); // 절대값 출력 함수 : 부호에 상관없이 순수 값만 출력 |a|
		
		System.out.println(Math.ceil(num)); // 올림
		System.out.println(Math.ceil(num2));
		
		System.out.println(Math.round(num)); // 반올림 : long 값을 반환해서 .0이 출력 안 됨
		System.out.println(Math.round(num2));
		
		System.out.println(Math.floor(num)); // 내림
		System.out.println(Math.floor(num2));
		
		int random = (int)(Math.random() * 4) + 1;
		System.out.println(random);
		
		Random r = new Random(); // 랜덤 클래스가 존재함 java.util
		System.out.println(r.nextInt()); // int 범위 안에 있는 랜덤 값을 다 가지고 옴
		System.out.println(r.nextInt(4)); // 범위를 넣어 주면 0 ~ 3까지 4개의 수를 가지고 옴 1 ~ 4 가지고 오고 싶을 경우 +1
		
		System.out.println(Math.rint(num)); // 해당 숫자에서 더 가까운 값이 나옴
		System.out.println(Math.rint(num2));
		
		System.out.println(Math.sqrt(3)); // 루트 3
		System.out.println(Math.pow(2, 3)); // 2의 3승
		
		System.out.println(Math.max(10, 4)); // 두 값 중 큰 값
		System.out.println(Math.min(10, 4)); // 두 값 중 작은 값
	}
}
