package com.kh.practice2.func;

import java.util.Scanner;

public class CastingPractice2 {
	public void method() {
		// �Ǽ������� ����, ����, ���� �� ������ ������ �Է¹޾� ������ ����� ����ϼ���
		// �̶� ������ ����� ���������� ó���ϼ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		double korean = sc.nextDouble();
		
		System.out.print("���� : ");
		double english = sc.nextDouble();
		
		System.out.print("���� : ");
		double math = sc.nextDouble();
		
		int sum = (int)(korean + english + math);
		
		System.out.println("���� : " + sum);
		System.out.println("��� : " + (sum / 3));		
	}
}
