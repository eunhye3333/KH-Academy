package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice1 {
	public void method() {
		// Ű����� ���� �ϳ��� �Է¹޾� �� ������ �����ڵ带 ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		char ch = sc.nextLine().charAt(0);
		int num = ch;
		
		System.out.println(ch + " unicode : " + num);
	}
}
