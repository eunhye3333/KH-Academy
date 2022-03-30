package com.kh.example.chap04_Math.controller;

import java.util.Random;

public class MathController {
	public void method() {
		// Math Ŭ���� : ���� ������ �ϱ⿡ ������ �޼ҵ���� ��Ƴ��� Ŭ����
		// �̱��� ���� ����
		//     static�� �̿��� ���ø����̼��� ������ �� �� �� ���� �ν��Ͻ��k ����� �޸� �Ҵ�
		//     �� �� �� ���� �ν��Ͻ��� ����ϰԲ� ���� ����
		//     -> �����ڰ� private, ��� ����� public static
		//     �ٸ� �������� ��ü ���� �� �ϰ�, �ȿ� �ִ� ���� �� ��� �����ϵ��� -> ���� �� ���� ����� ������ �ʳ״� ��븸 �ض�
		
		double num = 4.949;
		double num2 = 4.123;
		
		// Ŭ���� �ȿ��� ���� ���� ��� �ʵ�鵵 ������
		System.out.println(Math.PI);
		System.out.println(Integer.MAX_VALUE); // int�� �ִ밪
		System.out.println(Integer.MIN_VALUE);
		
		System.out.println(Math.abs(-num)); // ���밪 ��� �Լ� : ��ȣ�� ������� ���� ���� ��� |a|
		
		System.out.println(Math.ceil(num)); // �ø�
		System.out.println(Math.ceil(num2));
		
		System.out.println(Math.round(num)); // �ݿø� : long ���� ��ȯ�ؼ� .0�� ��� �� ��
		System.out.println(Math.round(num2));
		
		System.out.println(Math.floor(num)); // ����
		System.out.println(Math.floor(num2));
		
		int random = (int)(Math.random() * 4) + 1;
		System.out.println(random);
		
		Random r = new Random(); // ���� Ŭ������ ������ java.util
		System.out.println(r.nextInt()); // int ���� �ȿ� �ִ� ���� ���� �� ������ ��
		System.out.println(r.nextInt(4)); // ������ �־� �ָ� 0 ~ 3���� 4���� ���� ������ �� 1 ~ 4 ������ ���� ���� ��� +1
		
		System.out.println(Math.rint(num)); // �ش� ���ڿ��� �� ����� ���� ����
		System.out.println(Math.rint(num2));
		
		System.out.println(Math.sqrt(3)); // ��Ʈ 3
		System.out.println(Math.pow(2, 3)); // 2�� 3��
		
		System.out.println(Math.max(10, 4)); // �� �� �� ū ��
		System.out.println(Math.min(10, 4)); // �� �� �� ���� ��
	}
}
