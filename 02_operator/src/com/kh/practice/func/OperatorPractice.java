package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	public void practice1() {
		// Ű����� �Է� ���� �ϳ��� ������ ����̸� "�����", ����� �ƴϸ� "����� �ƴϴ�"�� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		String result = num > 0 ? "�����" : "����� �ƴϴ�";
		
		System.out.println(result);
	}
	
	public void practice2() {
		// Ű����� �Է� ���� �ϳ��� ������ ����̸� "�����",
		// ����� �ƴ� ��� �߿��� 0�̸� "0�̴�", 0�� �ƴϸ� "������"�� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		String result = num > 0 ? "�����" : (num == 0 ? "0�̴�" : "������");
		
		System.out.println(result);
	}
	
	public void practice3() {
		// Ű����� �Է� ���� �ϳ��� ������ ¦���̸� "¦����", ¦���� �ƴϸ� "Ȧ����"�� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		
		String result = (num % 2) == 0 ? "¦����" : "Ȧ����";
		
		System.out.println(result);
	}
	
	public void practice4() {
		// �ο����� ���� ���� �Է� �ް� 1�δ� �����ϰ� �������� ���� ������ ���� ���� ���� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ο� �� : ");
		int people = sc.nextInt();
		
		System.out.print("���� ���� : ");
		int candy = sc.nextInt();
		
		System.out.println("1�δ� ���� ���� : " + candy / people);
		System.out.println("���� ���� ���� : " + candy % people);
	}
	
	public void practice5() {
		// Ű����� �Է¹��� ������ ������ ����ϰ� ����� ���� ���� ȭ�鿡 ����ϼ���
		// �̶� ������ 'M'�Ƹ� ���л�, 'M'�� �ƴϸ� ���л����� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		System.out.print("�г�(���ڸ�) : ");
		int grade = sc.nextInt();
		
		System.out.print("��(���ڸ�) : ");
		int class1 = sc.nextInt();

		System.out.print("��ȣ(���ڸ�) : ");
		int num = sc.nextInt();
		
		System.out.print("����(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("����(�Ҽ��� �Ʒ� ��°�ڸ�����) : ");
		double score = sc.nextDouble();
		
		String strGender = gender == 'M' ? "���л�" : "���л�";
		
		System.out.println(grade + "�г� " + class1 + "�� " + num + "�� " + name + " " + strGender + "�� ������ " + score + "�̴�.");
	}
	
	public void practice6() {
		// ���̸� Ű����� �Է¹޾� ���(13�� ����)����, û�ҳ�(13�� �ʰ� ~ 19�� ����)����, ����(19�� �ʰ�)���� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		String str = age <= 13 ? "���" : (age > 19 ? "����" : "û�ҳ�");
		
		System.out.println(str);
	}
	
	public void practice7() {
		// ����, ����, ���п� ���� ������ Ű���带 �̿��� ������ �Է¹ް�,
		// �� ���� ���� �հ踦 ���ϼ���
		// �� ���� ������ ���� 40�� �̻��̸鼭 ����� 60�� �̻��� �� �հ�, �ƴ϶�� ���հ��� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� : ");
		int korean = sc.nextInt();
		
		System.out.print("���� : ");
		int english = sc.nextInt();
		
		System.out.print("���� : ");
		int math = sc.nextInt();
		
		int sum = korean + english + math;
		double avg = sum / 3.0;
		boolean bResult = math >= 40 && korean >= 40 && english >= 40 && avg >= 60;
		String result = bResult ? "�հ�" : "���հ�";
		
		System.out.println("�հ� : " + sum);
		System.out.println("��� : " + avg);
		System.out.println(result);
	}
	
	public void practice8() {
		// �ֹι�ȣ�� �̿��Ͽ� �������� �������� �����Ͽ� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է��ϼ���(- ����) : ");

		char pId = sc.nextLine().charAt(7);
		
		String gender = (pId == '2') || (pId == '4') ? "����" : ((pId == '1') || (pId == '3') ? "����" : "�߸� �Է��ϼ̽��ϴ�");
		
		System.out.println(gender);
	}
	
	public void practice9() {
		// Ű����� ���� �� ���� �Է¹޾� ������ ������ �� �� �ٸ� ������ �Է¹޾� �� ���� ù ��° ���� ���ϰų� �� ��° ���� �ʰ��̸� true�� ����ϰ� �ƴϸ� false�� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("���� 2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("�Է� : ");
		int num3 = sc.nextInt();
		
		System.out.println(num3 <= num1 || num3 > num2);
	}
	
	public void practice10() {
		// 3���� ���� Ű����� �Է� �޾� �Է� ���� ���� ��� ������ true, �ƴϸ� false�� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�Է�1 : ");
		int a = sc.nextInt();
		
		System.out.print("�Է�2 : ");
		int b = sc.nextInt();

		System.out.print("�Է�3 : ");
		int c = sc.nextInt();
		
		System.out.println(a == b && a == c && b == c);
	}
	
	public void practice11() {
		// A, B, C ����� ������ �Է¹ް�, �� ����� ������ �μ�Ƽ�긦 ������ ������ ����Ͽ� ����ϰ� �μ�Ƽ�� ���� �޿��� 3000���� �̻��̸� 3000 �̻�, �̸��̸� 3000 �̸��� ����ϼ���
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("A ����� ���� : ");
		int a = sc.nextInt();
		
		System.out.print("B ����� ���� : ");
		int b = sc.nextInt();
		
		System.out.print("C ����� ���� : ");
		int c = sc.nextInt();
		
		double sumA = a + a * 0.4;
		double sumB = b + b * 0;
		double sumC = c + c * 0.15;
		
		System.out.println("A��� ����/���� +a : " + a + "/" + sumA + "\n" + (sumA >= 3000 ? "3000 �̻�" : "3000 �̸�"));
		System.out.println("B��� ����/���� +a : " + b + "/" +  sumB + "\n" + (sumB >= 3000 ? "3000 �̻�" : "3000 �̸�"));
		System.out.println("C��� ����/���� +a : " + c + "/" +  sumC + "\n" + (sumC >= 3000 ? "3000 �̻�" : "3000 �̸�"));

	}
}
