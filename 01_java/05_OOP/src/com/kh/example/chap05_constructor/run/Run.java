package com.kh.example.chap05_constructor.run;

import java.util.Date;

import com.kh.example.chap05_constructor.model.vo.User;

public class Run {
	public static void main(String[] args) {
		User u1 = new User();
//		System.out.println("u1 : " + u1); // this�� �ش� ��ü �ּҰ� ����
//		User   u1    =      new   User();
//		Ŭ������ ������ ���Կ����� new������   ??
		// User�̶�� �޼ҵ带 ����� ���� �ʾ��� 
		// �޼ҵ� �̸��� �빮�ڷ� �������� ����, Ŭ������� �Ȱ���
		// => User()�� �����ڴ�.
		// �׷��� �Ұ�ȣ�� �ƹ� �Ű������� ���� -> �⺻ ������
		
		u1.inform();
		
//		int[] arr = new int[3]; // 0 0 0�� �� �ִ� ����
//		arr[0] = 1;
//		arr[1] = 2;
//		arr[2] = 3;
//		// 1 2 3�� ����
//		
//		int[] arr = {1, 2, 3}; // �ٷ� 1, 2, 3�� �� (������ ����)
		
		User u2 = new User("user01", "pass011", "���ǰ�", new Date()); // �Ű����� ������
//		System.out.println("u2 : " + u2);
		u2.inform(); // user01, pass011, ���ǰ�, Thu Aug 19 14:46:22 KST 2021
		
		User u3 = new User("user02", "pass02", "������");
//		System.out.println("u3 : " + u3);
		u3.inform();
		
		User u4 = new User("user03", "pass03");
//		System.out.println("u4 : " + u4);
		u4.inform();
		
	}
}
