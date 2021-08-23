package com.kh.example.chap06_method.run;

import com.kh.example.chap06_method.controller.MethodPractice;
import com.kh.example.chap06_method.model.vo.Trainee;

public class Run {
	public static void main(String[] args) {
		MethodPractice mp = new MethodPractice();
		
//		String str = mp.method1(); // ����, ��ȯ���� ��� Type mismatch: cannot convert from void to String
		// � �ڷ������� ���� �� ���� 
		// �ƹ��͵� ��� �� �Ǵ� �� ��¹��� ����̰� ��¹��� �־� �ָ� ��µ�
		mp.method1();
//		int result1 = mp.method2(); // ��ȯ���� �ְ� ���� �ֿܼ� ���� ������ ���� �����ϴ� ���� �ƴ� print���� ������־�� ��
//		// int�� ��ȯ�ϱ� ������ ������ ���� �־� �� �� ����
//		System.out.println(result1);
//		mp.method2();��� �ϸ� ���� ��ȯ�ޱ�� �ϳ� ������ ���� ���� �ʱ� ������ ���̳ʰ� ���ư���
		System.out.println(mp.method2()); // ��¸� �ϴ� ���� �����̸� ������ ���� �������� �ʰ� �ٷ� ����൵ ��
		
		mp.method3(10, 20);
		
		String result2 = mp.method4("�ڽſ�", 20);
		System.out.println(result2);
		
		char[] result3 = mp.method5(); // ���� ����, chArr�� �ּҰ��� ���� �ּҰ�
		System.out.println("Run result3 : " + result3);
		for(int i = 0; i < result3.length; i++) {
			System.out.print(result3[i]);
		}
		
		Trainee result4 = mp.method6(); // ���� ����
		System.out.println("Run result4 : " + result4);
		System.out.println(result4.inform());
		
		Trainee t1 = new Trainee("���ǰ�", 'H', "����", 98.5);
		System.out.println(t1.inform());
		Trainee t2 = new Trainee('G'); // �ʵ带 �ϳ����� ������ �ִ� ��ü�� ����� ���� ������?
		System.out.println(t2.inform()); // �� ��. ���� ��ü�� �ƴ϶� ���ο� ��ü�� ������ �������� ����
		// KH null �Ʒû��� Gnull���̰�, ������ 98.5���Դϴ�. -> �ٸ� ��ü�� classRoom�� �Ҵ�� ������ ��µ�
		
		result4.setName("�۹ΰ�");
		result4.setClassRoom('G');
		System.out.println(result4.inform());
		
		System.out.println(result4.getACADEMY());
		System.out.println(result4.getClassRoom());
		System.out.println(result4.getName());
		System.out.println(result4.getTime());
		System.out.println(Trainee.getScore());
	}
}
