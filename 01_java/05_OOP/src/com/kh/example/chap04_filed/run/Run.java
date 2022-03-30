package com.kh.example.chap04_filed.run;

import com.kh.example.chap04_filed.controller.KindsOfVariable2;

public class Run {
	public static void main(String[] args) {
		KindsOfVariable2 k2 = new KindsOfVariable2();
		int a1 = k2.staticNum; // ����� ��: ��� �޽���, ���� �� ����
		// a1 : The value of the local variable a1 is not used => ������� �ʾҴ�
		// staticNum : The static field KindsOfVariable2.staticNum should be accessed in a static way
		// => �ش� ������ static ���� ������� �����Ͽ��� �Ѵ�. ���� �� ����� static ���� ����� �ƴ�
		
		// static ���� ���
		// static ���� �� �ִ� �Ϳ� ���� ������ ��ü�� ���� �ʿ䰡 ����
		// ��ü ���� ���� Ŭ������.�ʵ�� / Ŭ������.�޼ҵ�� ���� ���� ����
		int a2 = KindsOfVariable2.staticNum; // ��� �� �� ��
		// �׷��� Arrays.copyOf��� ��ü�� ������ �ʰ� ������ (static���� ����Ǿ� �־)
		//static final�� ���� �����
		
		k2.method();
		k2.method();
		
		KindsOfVariable2 k22 = new KindsOfVariable2();
		k22.method(); // testNum : 11, staticTestNum : 13
		// static�� ���α׷��� ���۵� �� �߻�
	}
}
