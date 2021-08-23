package com.kh.example.chap04_filed.controller;

public class KindsOfVariable2 {
	public static int staticNum; // static -> 공유, 클래스 변수
	// 공유해야 하는데 나만 사용할 수 있게 private로 쓰면 좀 이상함. public으로 더 많이 씀
	
	private int testNum = 10; // 인스턴스 변수
	private static int staticTestNum = 10; // 클래스 변수
	
	public void method() {
		testNum++;
		System.out.println("testNum : " + testNum);
		staticTestNum++;
		System.out.println("staticTestNum : " + staticTestNum);
	}
}
