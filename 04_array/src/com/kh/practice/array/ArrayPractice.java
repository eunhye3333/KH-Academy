package com.kh.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {
	public void practice1() {
		// ���̰� 10�� �迭�� �����ϰ� 1���� 10������ ���� �ݺ����� �̿��Ͽ� ������� ���� �� �� ���
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i+1;
			System.out.print(array[i] + " ");
		}
	}
	
	public void practice2() {
		// ���̰� 10�� �迭�� �����ϰ� 1���� 10������ ���� �ݺ����� �̿��Ͽ� �������� ���� �� �� ���
		int[] array = new int[10];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = array.length - i;
			System.out.print(array[i] + " ");
		}
	}
	
	public void practice3() {
		// �Է¹��� ����ŭ �迭 ũ�⸦ �Ҵ��ϰ� 1���� �Է¹��� ������ �ʱ�ȭ
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� : ");
		int num = sc.nextInt();
		
		int[] array = new int[num];
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i+1;
			System.out.print(array[i] + " ");
		}
	}
	
	public void practice4() {
		// String �迭 �ʱ�ȭ
		String[] array = {"���", "��", "����", "������", "����"};
		
		System.out.println(array[1]);
	}
	
	public void practice5() {
		// ���ڿ��� �Է¹޾� ���� �ϳ��ϳ��� �迭�� �ְ� ���� �˻�
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		System.out.print("���� : ");
		char ch = sc.next().charAt(0);
		int count = 0;
		
		char[] chArr = new char[str.length()];
		System.out.print(str + "�� " + ch + "�� �����ϴ� ��ġ(�ε���) : ");
		for(int i = 0; i < chArr.length; i++) {
			chArr[i] = str.charAt(i);
			if(chArr[i] == ch) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println(ch + " ���� : " + count);
	}
	
	public void practice6() {
		// "��" ~ "��"���� �ʱ�ȭ�� ���ڿ� �迭�� ����� 0���� 6���� ���ڸ� �Է¹޾� ���
		Scanner sc = new Scanner(System.in);
		String[] day = {"��", "ȭ", "��", "��", "�� ", "��", "��"};
		
		System.out.print("0 ~ 6 ���� ���� �Է� : ");
		int num = sc.nextInt();
		
		if(num >= 0 && num <= 6) {
			System.out.println(day[num] + "����");
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	public void practice7() {
		// �迭�� ���̸� ���� �Է��Ͽ� �迭 ����
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int size = sc.nextInt();
		
		int[] array = new int[size];
		int sum = 0;
		
		for(int i = 0; i < array.length; i++) {
			System.out.print("�迭 " + i +"��° �ε����� ���� �� : ");
			array[i] = sc.nextInt();
			sum += array[i];
		}
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("���� : " + sum);
	}
	
	public void practice8() {
		// 3 �̻��� Ȧ�� �ڿ����� �Է¹޾� ���
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		while(true) {
			System.out.print("���� : ");
			num = sc.nextInt();
			
			if(num < 3 || num % 2 == 0) {
				System.out.println("�ٽ� �Է��ϼ���.");
			} else {
				break;
			}
		}
		
		int[] array = new int[num];
		int count = 0;
		for(int i = 0; i < array.length; i++) {
			if(i <= num / 2) {
				array[i] = i+1;
				count++;
				System.out.print(array[i] + " ");
			} else {
				count--;
				array[i] = count; 
				System.out.print(array[i] + " ");
			}
		}
	}
	
	public void practice9() {
		// ����ڰ� �Է��� ���� �迭�� �ִ��� Ȯ��
		Scanner sc = new Scanner(System.in);
		System.out.print("ġŲ �̸��� �Է��ϼ��� : ");
		String name = sc.nextLine();
		
		String[] chicken = {"���", "�Ķ��̵�", "����", "�Ĵ�", "����"};
		
		boolean flag = false;
		for(int i = 0; i < chicken.length; i++) {
			if(name.equals(chicken[i])) {
				flag = true;
			}
		}
		
		if(flag) {
			System.out.println(name + "ġŲ ��� ����");
		} else {
			System.out.println(name + "ġŲ�� ���� �޴��Դϴ�.");
		}
	}
	
	public void practice10() {
		// �ֹε�Ϲ�ȣ ���� �ڸ� ���ĺ��� *�� ������ ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹε�Ϲ�ȣ(-����) : ");
		String pId = sc.nextLine();
		char[] arrPId = new char[pId.length()];
		
		for(int i = 0; i < arrPId.length; i++) {
			arrPId[i] = pId.charAt(i);
		}
		
		char[] copyArr = new char[arrPId.length];
		System.arraycopy(arrPId, 0, copyArr, 0, arrPId.length);
		
		for(int i = 0; i < copyArr.length; i++) {
			if(i > 7) {
				copyArr[i] = '*';
			}
			System.out.print(copyArr[i]);
		}
	}
	
	public void practice11() {
		// ���� ����
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice12() {
		// ���� ���� �� �ִ밪, �ּҰ� ���
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			System.out.print(arr[i] + " ");
		}
		
		int min = arr[0];
		int max = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
			
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println();
		System.out.println("�ִ밪 : " + max);
		System.out.println("�ּҰ� : " + min);
	}
	
	public void practice13() {
		// ���� ���� �ߺ� ����
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 10 + 1);
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}

			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		
	}
	
	public void practice14() {
		// �ζ� ��ȣ �������� ����
		int[] arr = new int[6];
		
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random() * 45 + 1);
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}
			}
		}
		
		int s = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < arr[i-1]) {
				s = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = s;
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public void practice15() {
		// ���ڿ� �Է¹޾� ���� �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڿ� : ");
		String str = sc.nextLine();
		char[] ch = new char[str.length()];
		int[] index = new int[ch.length];
		
		
		for(int i = 0; i < ch.length; i++) {
			ch[i] = str.charAt(i);
			index[i] = 1;
			
		}
		
		for(int i = 0; i < ch.length; i++) {
			for(int j = 0; j < i; j++) {
				if(ch[i] == ch[j]) {
					index[i] = 0;
				}
			}
		}
		int count = 0;
		System.out.print("���ڿ��� �ִ� ���� : ");
		for(int i = 0; i < ch.length; i++) {
			if(index[i] == 1) {
				System.out.print(ch[i] + ", "); // �������� ��ǥ ���ִ� ��
				count++;
			}
		}
		System.out.println();
		System.out.println("���� ���� : " + count);
	}
	
	public void practice16() {
		// �Է��� �迭�� ���̸�ŭ ���ڿ� �Ҵ� �� ���ڿ� �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("�迭�� ũ�⸦ �Է��ϼ��� : ");
		int size = sc.nextInt();
		
		String[] strArr = new String[size];
		
		for(int i = 0; i < size; i++) {
			System.out.print(i+1 + "��° ���ڿ� : ");
			strArr[i] = sc.next();
		}

		int msize = 0;
		String[] arr =  new String[strArr.length];
		
		while(true) {
			System.out.print("�� ���� �Է��Ͻðڽ��ϱ�?(Y/N) : ");
			char re = sc.next().charAt(0);
			switch(re) {
			case 'y':
			case 'Y':
				System.out.print("�� �Է��ϰ� ���� ���� : ");
				msize = sc.nextInt();
				arr = Arrays.copyOf(strArr, size);
				
				for(int i = size; i < msize; i++) {
					System.out.print(i + "��° ���ڿ� : ");
					arr[i] = sc.next();
				}
				break;
			case 'n':
			case 'N':
				System.out.print("[");
				for(int i = 0; i < msize; i++) {
					System.out.print(arr[i]);
					if (i == msize -1) {
						System.out.print("]");
					} else {
						System.out.print(", ");
					}
				}
				return;
				
			default:
				System.out.print("�ٽ� �Է��ϼ��� : ");
			}
		}
	}
}
