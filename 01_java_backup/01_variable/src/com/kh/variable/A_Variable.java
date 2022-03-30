package com.kh.variable;

public class A_Variable {
	public void declareVariable() {
		// ���� ���� �� �ʱ�ȭ
		// A. ���� ���� :Stack ������ ������ ����(�Ҵ�)�ϴ� �� -> �ڷ��� ������;
		// 1. ����
		boolean isTrue;
		
		// 2. ������
		// 2-1. ������
		byte bNum;
		short sNum;
		int iNum;
		long lNum;
		
		// 2-2. �����
		float fNum;
		double dNum;
		
		// 3. ������
		// 3-1. ����
		char ch;
		
		// 3-2. ���ڿ�
		String str;

		// B. �ʱ�ȭ (����)
		isTrue = false; // true, false�� ���� ���� �ٸ� �� ���� �� ���� �߻�

		bNum = 1;
		sNum = 2;
		iNum = 4;
		lNum = 8L; // long ���� ���� �˷��ֱ� ����

		fNum = 4.0f;
		dNum = 8.0d;

		ch = 'A'; 
		str = "A"; 

		System.out.println("isTrue�� �� : " + isTrue);

		System.out.println("bNum�� �� : " + bNum);
		System.out.println("sNum�� �� : " + sNum);
		System.out.println("iNum�� �� : " + iNum);
		System.out.println("lNum�� �� : " + lNum);

		System.out.println("fNum�� �� : " + fNum);
		System.out.println("dNum�� �� : " + dNum);

		System.out.println("ch�� �� : " + ch);
		System.out.println("str�� �� : " + str);
	}

	public void initVariable() {
		// ���� ����� ���ÿ� �ʱ�ȭ
		// 1. ����
		boolean isTrue = true; // ���� isTrue�� ��µ��� ������ �� ���� ����: �޼ҵ尡 �޶�. ������ �ٸ�.
		
		// 2. ������
		// 2-1. ������
		byte bNum = 1;
		short sNum = 2;
		int iNum = 4;
		long lNum = 8L;
		
		// 2-2. �����
		float fNum = 4.0f;
		double dNum = 8.0;
		
		// 3. ������
		// 3-1. ����
		char ch = '��';
		
		// 3-2. ���ڿ�
		String str = "�ſ�";
		
		System.out.println("isTrue�� �� : " + isTrue);

		System.out.println("bNum�� �� : " + bNum);
		System.out.println("sNum�� �� : " + sNum);
		System.out.println("iNum�� �� : " + iNum);
		System.out.println("lNum�� �� : " + lNum);

		System.out.println("fNum�� �� : " + fNum);
		System.out.println("dNum�� �� : " + dNum);

		System.out.println("ch�� �� : " + ch);
		System.out.println("str�� �� : " + str);
	}
}
