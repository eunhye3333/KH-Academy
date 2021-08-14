package com.kh.example.chap01.run;

import com.kh.example.chap01.condition.A_If;
import com.kh.example.chap01.condition.B_Switch;

public class Run {
	public static void main(String[] args) {
		A_If ai = new A_If(); // 클래스가 달라서 알맹이를 만들어 줌
//		ai.method1(); // A_if 안에 있는 메소드 출ㄺ
//		ai.method2();
//		ai.method3();
		
		B_Switch bs = new B_Switch();
//		bs.method1();
//		bs.method2();
		bs.method3();
		
	}
}
