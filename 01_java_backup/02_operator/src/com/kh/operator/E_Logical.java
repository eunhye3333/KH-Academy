package com.kh.operator;

import java.util.Scanner;

public class E_Logical {
	public void method1() {
		// �Է��� �������� 1���� 100 ������ �������� Ȯ���ϱ�
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �ϳ� �Է� : ");
		int num = sc.nextInt();
		
		// �Է��� ���ڰ� 1~100 ���̴�
		// = �Է��� ���ڰ� 1���� ũ�ų� ���� 100���� �۰ų� ����
		// =                   &&
		// = num >= 1 && num <= 100
		System.out.println("1���� 100 ������ �������� Ȯ�� : " + (num >= 1 && num <= 100));
	}
	
	public void method2() {
		// �Է��� ���� ���� �빮������ Ȯ��
		Scanner sc = new Scanner(System.in);
		
		System.out.print("���� �ϳ� �Է� : ");
//		String strCh = sc.nextLine(); 
//		char ch = strCh.charAt(0);
		char ch = sc.nextLine().charAt(0); // �� �� �ٰ� ���� ������. strCh�� sc.nextLine()�� ������ ������ �ֱ� ������ -> ġȯ
		// �̷��� �ᵵ �ٹٲ� ���ڱ��� ����Ǵ� ���� �ƴϰ� ���� �����͸� �����
		
		System.out.println("���� �빮�ڰ� �½��ϱ�? : " + (ch >= 'A' && ch <= 'Z')); // ���ڴ� ���ڶ� ȣȯ�Ǳ� ������ ���� ����
		
		System.out.print("����Ͻ÷��� Y �Ǵ� y�� �Է��ϼ��� : ");
		char ch2 = sc.nextLine().charAt(0);
		
		System.out.println("����ϰڴٰ� �߽��ϱ�? : " + (ch2 == 'Y' || ch2 == 'y'));
	}
	
	public void method3() {
		int a = 2;
		int b = 3;
		
		boolean c = a > b;
		boolean d = ++a <= b++;
		
		System.out.println("a : " + a); // 3
		System.out.println("b : " + b); // 4
		System.out.println("c : " + c); // false
		System.out.println("d : " + d); // true
		
		System.out.println();
		
		System.out.println("!c : " + !c); // true
		System.out.println("c != d : " + (c != d)); // true
		
		System.out.println();
		
		System.out.println("(a % b ) == 1 : " + ((a % b ) == 1)); // false (3 % 4 == 3)
		System.out.println("(a == 3) && (b == 4) : " + ((a == 3) && (b == 4))); // true
		System.out.println("!d || (a - b) > 0 : " + (!d || (a - b) > 0)); // false
		
		System.out.println(!(c == d) && ((a * b == 10) || (b % 2 ==0)));
		//                  !(false)         (false)   ||    (true)
		//                    true    &&              true
		//                           true
	}
}
