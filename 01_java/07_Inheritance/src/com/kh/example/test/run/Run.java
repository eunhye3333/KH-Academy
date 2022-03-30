package com.kh.example.test.run;

import com.kh.example.test.controller.InheritanceTest;

public class Run {
	public static void main(String[] args) {
//		InheritanceTest it = new InheritanceTest(); // it는 new InheritanceTest() 객체
//		it.method(); // 한 객체에서 불러올 메소드가 많을 경우 주로 사용
		
		new InheritanceTest().method(); // 변수로 굳이 만들지 않고 바로 객체를 만들어서 사용
		// 한 객체당 하나의 메소드만 불러오면 될 때 주로 사용
		
	}
}
