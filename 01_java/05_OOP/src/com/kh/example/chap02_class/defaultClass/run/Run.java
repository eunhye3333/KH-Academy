package com.kh.example.chap02_class.defaultClass.run;

public class Run {
	public static void main(String[] args) {
//		DefaultClassTest dct = new DefaultClassTest(); // import 안 됨
		// DefaultClassTest는 default 클래스
		// default 클래스는 접근 범위가 같은 패키지 내에서만 가능
		// 현재 패키지는 DefaultClassTest 클래스와 같은 패키지가 아니므로 접근 불가능
		// Run 클래스를 같은 패키지 안에 만들어 줘야 함
	}
}
