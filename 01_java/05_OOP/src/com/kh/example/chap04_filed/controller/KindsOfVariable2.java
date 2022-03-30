package com.kh.example.chap04_filed.controller;

public class KindsOfVariable2 {
	public static int staticNum; // static -> ����, Ŭ���� ����
	// �����ؾ� �ϴµ� ���� ����� �� �ְ� private�� ���� �� �̻���. public���� �� ���� ��
	
	private int testNum = 10; // �ν��Ͻ� ����
	private static int staticTestNum = 10; // Ŭ���� ����
	
	public void method() {
		testNum++;
		System.out.println("testNum : " + testNum);
		staticTestNum++;
		System.out.println("staticTestNum : " + staticTestNum);
	}
}
