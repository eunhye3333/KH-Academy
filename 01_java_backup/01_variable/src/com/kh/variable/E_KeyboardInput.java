package com.kh.variable;

import java.util.Scanner;

public class E_KeyboardInput {
	public void inputScanner1() {
		Scanner sc = new Scanner(System.in);
//		sc.nextLine(); // nextLine() : ����ڿ��� ���ڿ��� �޾��ִ� �޼ҵ�
		// �����ϸ� �ƹ� �ϵ� �Ͼ�� ������ console�� ������ ���� ��������. ������ �Ϸ��Ǹ� ����̾�� ��.
		// ������ ���� ���� �ִٴ� ���� ��� �������̶�� ��. �� ���� ���Ҵ�. -> ����ڿ��� �����͸� ���� �ʾҴ�
		// �����͸� �Է��ϰ� ���͸� ������ �����. sc.nextLine()�� �Է��� ������ ��ü�� ��.
		// ���� �����͸� �ް� ������ �ٸ� ���� ����Ǵ� ���� �ƴϱ� ������ �����Ͱ� �����. ���� �����Ͱ� ������� �ʰ� �Ϸ��� ������ �����ؾ� ��.
		System.out.print("�̸��� �Է��ϼ��� : "); // �̸��� �Է��ϰ� �ϱ� ���� �ȳ��� �ۼ� �ʿ�. ���� ���ϰ� �ϱ� ���ؼ� �ٹٲ����� ����.
//		String name = sc.nextLine();
		String name = sc.next(); // next() : ��������� ���ڿ��� �޾ƿ��� �޼ҵ� 
		// next, nextLine �������� ���� �� �� ����
		
		System.out.print("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt(); // nextInt() : ����ڿ��� ������ �޾ƿ��� �޼ҵ�
		
		System.out.print("Ű�� �Է��ϼ���(�Ҽ��� ù°�ڸ����� �Է�) : ");
		double height = sc.nextDouble(); // nextDouble() : ����ڿ��� �Ǽ��� �޾ƿ��� �޼ҵ�
		
		
		System.out.println(name + "���� " + age + "���̸�, Ű�� " + height + "cm�Դϴ�.");
	}
	
	public void inputScanner2() {
		// next()�� nextLine() ��
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = sc.nextLine(); // �ڽſ�\n ������
		
//		System.out.print("���̸� �Է��ϼ��� : ");
//		int age = sc.nextInt(); // 20 ������
		
//		System.out.print("�ּҸ� �Է��ϼ��� : ");
//		String address = sc.nextLine(); // �ּ� �Է��� ����� ���� �ʴ� ������ ���� (\n ������)
		
		// �ذ� ��� 1. ���͸� �������� ���ϰ� ������� : next()
//		//		System.out.print("�ּҸ� �Է��ϼ��� : ");
//		String address = sc.next(); // ���Ⱑ ������ �� ��. next�� ���⸦ �����ڷ� �ν��ϱ� ������ ���Ⱑ ���� ��� ���� �Ϻθ� �о���� ��
		// ���� �޺κ��� ����ϰ� ������ sc.next()�� ���� ����ŭ ����������
		
		// �ذ� ��� 2. �ٹٲ��� ���ֱ� ���� nextLine �߰�
		// nextLine�� �ٹٲ��� �ν��ϴϱ� �ϳ��� �Ἥ ���ָ� �ٽ� ���۸� �����ϰ� ���� �� ����
//		System.out.print("�ּҸ� �Է��ϼ��� : ");
//		sc.nextLine();
//		String address = sc.nextLine();
		
		// �ذ� ��� 3. �Ľ�(parsing)�ϱ� : ���ڿ��� �ٸ� �ڷ������� �ٲٴ� ��. ���̿� ���ؼ� �Ľ�
		System.out.print("���̸� �Է��ϼ��� : ");
		String strAge = sc.nextLine(); // ���̸� ���ڰ� �ƴ϶� ��Ʈ������ �޾ƿ���. ������  int�� �޾ƾ� �Ǵµ� String���� ����. but ���ۿ� �ٹٲ��� �� ����.
		// ���ڿ� ���̸� int�� �ٲ� ��� �� -> �Ľ�
		int age = Integer.parseInt(strAge); // strAge�� int�� �ٲٰڴ�	
		
		
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		String address = sc.nextLine(); // �ٹٲ��� �����Ƿ� �׳� �ٷ� nextLine�� �̿��� �ּҸ� �Է¹��� �� ����
		
		// + char �ޱ�
		System.out.print("������ �Է��ϼ���(M/F) : ");
		String strGender = sc.nextLine();
		char gender = strGender.charAt(0); // charAt(int index) : char -> String Ŭ���� �ȿ� �ִ� �޼ҵ�
		
		System.out.println(name + "��(" + gender + ")�� " + age + "���̸�, ��� ���� " + address + "�Դϴ�.");
		
	}
}
