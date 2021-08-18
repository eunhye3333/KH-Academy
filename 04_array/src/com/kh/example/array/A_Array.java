package com.kh.example.array;

import java.util.Scanner;

public class A_Array {
	// �迭�� ���� �ڷ����� ������ �ϳ��� �������� �ٷ�� ��
	// �迭�� ����
	//     �ڷ���[] �迭��;
	//     �ڷ��� �迭��[];
	// �迭�� �Ҵ�
	//     �ڷ���[] �迭�� = new �ڷ���[�迭ũ��];
	//     �ڷ��� �迭��[] = new �ڷ���[�迭ũ��];
	//     new �����ڸ� ���� Heap �޸� ������ ������ �迭 ũ�⸸ŭ ����
	//     ������ �Ǵ� ���� �� ������ ���� �ּҰ� �߻�
	//     �߻��� �ּҰ��� ���� �����ڿ� ���� �迭�� ������ ������ ��(�����ϰ� ����)
	// �迭�� �ʱ�ȭ
	//     1) �ε��� �̿� : Zero-based
	//     2) for�� �̿�: ��Ģ�� ���� ���� ��� ����
	//     3) ����� ���ÿ� �ʱ�ȭ
	//         �ڷ���[] �迭�� = {��};
	//         �ڷ���[] �迭�� = new �ڷ���[]{��};
	
	public void method1() {
		int num1 = 10;
		int num2 = 20;
		int num3 = 30;
		int num4 = 40;
		int num5 = 50;
		int num6 = 60;
		int num7 = 70;
		int num8 = 80;
		int num9 = 90;
		// ���� �ڷ����̴ϱ� �迭�� ����� �ǰڴ�
		
//		int[] arr; // Stack�� arr�̶�� ������ ����. �� �������� ������ �����͸� ������� ���� ����.
		int[] arr = new int[9]; // Heap ������ 9���� ������ �����, �ּҰ��� ������. �̰��� ���� �����ڸ� �̿��� Stack�� �ִ� arr�� �������
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
//		System.out.println(arr[3]);
//		System.out.println(arr[4]);
//		System.out.println(arr[5]);
//		System.out.println(arr[6]);
//		System.out.println(arr[7]);
//		System.out.println(arr[8]);
		// �ƹ��͵� �������� �ʾҴµ� �� 0�� ��µ�
		//  -> int�� �⺻���� 0�̶�
		// �ʱ�ȭ�� ���� ������ �����Ⱚ�� ���� ���� ���������̸鼭 Stack�� ����� �������� �ش��
		// Heap ������ ������ ��������� �����͸� ������� �ʾƵ� �ش� �ڷ����� �⺻������ �ʱ�ȭ��
		// Heap ���������� ���� ������ �� �Ǳ� ����
		
		// for������ ����ϴ� ���� �� ������
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		// �ε����� �̿��� �ʱ�ȭ
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
//		arr[5] = 60;
//		arr[6] = 70;
//		arr[7] = 80;
//		arr[8] = 90;
		
		// ������ ��Ģ�� �ֱ� ������ for���� �̿��� �ʱ�ȭ
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] = (i+1) * 10;
//		}
//		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + " ");
//		}
		// �� ���� ���� ���·� ���
		
		// ���� ���� �ʰ� �ٷ� ���ĵ� ��
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i+1) * 10;
			System.out.print(arr[i] + " ");
		}
		// �� �ϳ� �ְ� ����ϰ�, �ϳ� �ְ� ����ϰ� (�ϳ���)
		
		System.out.println();
		
		System.out.println(arr); // Heap ������ ������� ������ ���� �ּҰ��� ���� -> [I@6d06d69c
		// ��Ȯ�� �ּҴ� �ƴ� ��Ȯ�� �ּҁ��� �ڹٰ� �������� �ʱ� ������ �� �� ����
	}

	public void method2() {
		// ����� ���ÿ� �ʱ�ȭ
		int[] iArr1 = {1, 2, 3, 4, 5};
		int[] iArr2 = new int[] {11, 22, 33, 44, 55};
		String[] strArr = {"red", "orange", "yellow"};
		
		for(int i = 0; i < iArr1.length; i++) {
			System.out.print(iArr1[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < iArr2.length; i++) {
			System.out.print(iArr2[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < strArr.length; i++) {
			System.out.print(strArr[i] + " ");
		}
	}
	
	public void method3() {
		// �迭�� ����
		
		// 5���� ������ ���� int�� �迭 iArr
		int[] iArr = new int[5];
		// 10���� ������ ���� char�� �迭 cArr
		char[] cArr = new char[10];
		
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < cArr.length; i++) {
			System.out.print(cArr[i] + "|");
			// char�� ���� �⺻���� �� ������ ���� ������ ���� | ���
		}
		
		System.out.println();
		
		// �ּҰ� ���
		System.out.println("iArr : " + iArr);
		System.out.println("cArr : " + cArr);
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Ҵ��� �迭�� ũ�� �Է� : ");
		int size = sc.nextInt();
		
		iArr = new int[size];
		for(int i = 0; i < iArr.length; i++) {
			System.out.print(iArr[i] + " ");
		}
		
		System.out.println();
		System.out.println("iArr : " + iArr); // �ּҰ� �ٲ������ Ȯ��
		// �ּҰ� �ٲ� -> ������ �ִ� �ְ� �ƴ϶� ���ο� �ְ� �Ҵ�Ǿ��ٴ� ��
		
		iArr = null; // �迭�� ������ ���� ���� ���
		
	}
}
