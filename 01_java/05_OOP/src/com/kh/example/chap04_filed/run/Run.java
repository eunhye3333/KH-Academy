package com.kh.example.chap04_filed.run;

import com.kh.example.chap04_filed.controller.KindsOfVariable2;

public class Run {
	public static void main(String[] args) {
		KindsOfVariable2 k2 = new KindsOfVariable2();
		int a1 = k2.staticNum; // 노란색 줄: 경고성 메시지, 없는 게 좋음
		// a1 : The value of the local variable a1 is not used => 사용하지 않았다
		// staticNum : The static field KindsOfVariable2.staticNum should be accessed in a static way
		// => 해당 변수는 static 접근 방식으로 접근하여야 한다. 지금 한 방식은 static 접근 방식이 아님
		
		// static 접근 방식
		// static 예약어가 들어가 있는 것에 대한 접근은 객체를 만들 필요가 없다
		// 객체 생성 없이 클래스명.필드명 / 클래스명.메소드명 으로 접근 가능
		int a2 = KindsOfVariable2.staticNum; // 노란 줄 안 뜸
		// 그래서 Arrays.copyOf라고 객체를 만들지 않고 가져옴 (static으로 선언되어 있어서)
		//static final도 많이 사용함
		
		k2.method();
		k2.method();
		
		KindsOfVariable2 k22 = new KindsOfVariable2();
		k22.method(); // testNum : 11, staticTestNum : 13
		// static은 프로그램이 시작될 때 발생
	}
}
