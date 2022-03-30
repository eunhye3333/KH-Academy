package com.kh.example.chap02.loop;

import java.util.Scanner;

public class A_For {
	// for(�����; ���ǽ�; ������){
	//	���๮��;
	// }
	// �ʱ�� -> ���ǽ� Ȯ�� -> (���ǽ��� true�� ��) ���� ���� ���� -> ������ -> ���ǽ� Ȯ�� -> (�ݺ�)
	
	// for�� �ȿ� �ִ� �ʱ��, ���ǽ�, ������ ���� ����
	// �Ұ�ȣ �ȿ����� �����Ǵ� ���� �ۿ����� �ȿ����� ��𿡼��� ǥ��� �ؾ� ��. �� �׷��� for�� ������ ���� �� ���� ������.
	// �ʱ���� ��������, ������ ��������, ������ �󸶳� �Ǵ��� �� ǥ���ؾ���
	// �ᱹ for���� �Ұ�ȣ() �ȿ����� �����ɻ� ��� �ʿ��� ��ҵ��̴�
	public void method1() {
		// 1���� 5���� ���
		// System.out.println();���� ��� �� �� ������ 5�� �̻��� �Ǹ� �ϳ��ϳ� ��� ����
		for(int i = 1; i <= 5; i++) {
			// �������� �� ������ i ���� �ٲ��� �ʱ� ������ ��� ���Ѵ�� 1�� ����
			System.out.println(i);
			// �������� �����ϰ� ������ ����� i++�� �־ ��
			// �������� ���� �����ϳ� �������� ������ �ֱ� �־�� ��
		}
	}
	
	public void method1_1() {
		// �ڱ�Ұ� �ټ� �� �ϱ� : �� �̸��� �ڽſ��
		for(int i = 0; i < 5; i++) { 
//		for(int i = 1; i <= 5; i++) {
//		for(int i = 2; i <= 6; i++) { // �̰͵� 5�� �ݺ���
			System.out.println("�� �̸��� �ڽſ��");
		}
		// ���� method1�� 1��ó 5���� ����̱� ������ 1���� �����ؾ� ����
		// ������ �ڱ�Ұ��� ���� ������� 5�� ��¸� �ϸ� �Ǳ� ������ 5�� �ݺ��� �ϸ� �ǹǷ� i�� � ���� ���� �������
	}
	
	public void method2() {
		// 5���� 1���� ��� (�Ųٷ�)
		for(int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}
	
	public void method2_1() {
		// 8���� 3���� ���
		for(int i = 8; i >= 3; i--) {
			System.out.println(i);
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.println(8 - i);
		} // �̷��Ե� ����
	}
	
	public void method3() {
		// 1���� 10 ������ ���� �� Ȧ���� ��� : 1 3 5 7 9
		// for���� �̿�
		for(int i = 1; i <= 10;) { 
//		for(int i = 1; i <= 10; i+=2) {
			System.out.println(i);
			i += 2;
		}
		
		// for�� + if��
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 1) {
				System.out.println(i);
			}
		}
	}
	
	public void method4() {
		// ���� �� ���� �Է¹޾� �� ���� ���� ���
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù ��° ���� : ");
		int start = sc.nextInt();

		System.out.print("�� ��° ���� : ");
		int end = sc.nextInt();
		
		for(int i = start; i <= end; i++) {
			System.out.println(i);
			// ������ : �� ��° ���ڰ� ���� ��쿡�� �ƿ� �� ����. ���ǽ��� ó������ false�̱� ������
		}
		
		// �ذ� ���
		int max = 0; // �� ���� �� ū ���� ����
		int min = 0; // �� ���� �� ���� ���� ����
		
		if(start > end) {
			max = start;
			min = end;
		} else { // start <= end
			max = end;
			min = start;
		} // if���� ������ ������ max���� ū ����, min���� ���� ���ڰ� �� �ְ� ��
		
//		for(int i = min; i <= max; i++) {
//			System.out.println(i);
//		}
		for(; min <= max; min++) { // ���� ������ ������ ����ϹǷ� �ʱ�� ���� ����
			System.out.println(min);
		}
		
		// for������ ���� ������ �ַ� ���� ���� : �׳� ���� �׷��� ��
	}
	
	public void method4_1() {
		// ������ �ϳ� �Է¹޾� �� ���� 1~9 ������ ���� ���� �� ���� ������ ���
		// ������ ���� ������ "1~9 ������ ����� �Է��Ͽ��� �մϴ�" ���
		Scanner sc = new Scanner(System.in);
		System.out.print("1~9 ������ ����� �ϳ� �Է��ϼ��� : ");
		int dan = sc.nextInt();
		
		// �Էµ� ���ڰ� 1~9 ������ �������� Ȯ��
		if(dan >= 1 && dan <= 9) {
			System.out.println("============ " + dan + "�� ��� ============");
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d X %d = %d%n", dan, i, (dan * i));
//				System.out.printf("%d X %d = %2d%n", dan, i, (dan * i)); // 2���� ĭ�� ����� ������ ����, -2d�� ���� ����
			}
		} else {
			System.out.println("1~9 ������ ����� �Է��Ͽ��� �մϴ�");
		}
		
	}
	
	public void method5() {
		// 1��ó 10 ������ ������ ������ ���� 1���� ���������� ���� �հ�
		// ���� : ������ ����
		// ����� �� : Math.random() ��� -> ����غ��� double�� ������ ���ڰ� ����
		// double java.lang.Math.random()
		//        ----------------------- -> Ŭ������ Ǯ����
		// ------ -> ��ȯ��
		// �� �޼ҵ尡 � ���� ��ȯ�ϴ��� �ñ��ϸ� ���콺�� �÷��� Ȯ�� ����
//		double random = Math.random();
		// ������� �ϴ� ������ 1~10������ ������
		// ������ �ٲٱ�
		// (0�ܰ�) 0 <= Math.random() < 1 : double
		// (1�ܰ�) 0 <= Math.random() * 10 < 1 * 10 : ��ȯ�� -> 0.0 ~ 9.99999999999... => ���ϱ� 10
		// (2�ܰ�) 0 + 1 <= Math.random() * 10 + 1 < 10 + 1 : ��ȯ�� -> 1.0 ~ 10.99999999999... => ���ϱ� 1
		// (3�ܰ�) 1 <= (int)Math.random() * 10 < 11 : ��ȯ�� -> 1 ~ 10 => int�� ���� ����ȯ
		// 2�ܰ�� 3�ܰ��� ������ �ٲ� �������
		
		int random = (int)(Math.random() * 10 + 1);
		int sum = 0;
		
		for(int i = 1; i <= random; i++) {
			sum +=i;
		}
		
		System.out.println("1���� " + random + "������ ���� �հ� : " + sum);
	}
	
	public void method6() {
		// 2�ܺ��� 9�ܱ��� ���
		// 2*1=2 2*2=4 2*3=6 .... 2*9=18
		// 3*1=3 3*2=6 3*3=9 .... 3*9=27
		// ũ�� ���� �� : �� -> ū for��
		// �۰� ���� �� : �� -> ���� for��
		
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) { // i�� �̹� ���ÿ� ����Ǿ� �����Ƿ� �� i�� ����ϸ� �� ��
				System.out.println(i + " * " + j + " = " + i*j);
			}
		}
	}
	
	public void method7() {
		// 0�� 0�� ~ 23�� 59��
		for(int i = 0; i < 24; i++) {
			for(int j = 0; j < 60; j++) {
				System.out.println(i + "�� " + j + "��");
				System.out.printf("%2d�� %2d��%n", i, j);
			}
		}
	}
	
	public void method8() {
		// �� �ٿ� ��ǥ(*)�� 5�� ��µǴµ� �� ���� ����ڰ� �Է��� ����ŭ ���
		/* 
		 	����� �� �� : 3      ����� �� �� : 5 
		 	*****         *****
		 	*****         *****
		 	*****         *****
		 	              *****
		 	              *****
		 */
		// �׷��� �� ���� ��ǥ�� �ϳ����� ��µǾ�� ��
		// Ʋ�� ���
//		for(int i = 1; i <= 3; i++) {
//			System.out.println("*****");
//		}
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �� ���� �Է��ϼ��� : ");
		int row = sc.nextInt();
		
		// ���� �ϳ��� �������� for�� �ϳ��δ� ���� -> ��ø for�� �ʿ�
		// ū for���� �� ���, ���� for������ �� ��
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
	
	public void method9() {
		// �� �ٿ� ��ǥ ���ڸ� �Էµ� �� ���� ĭ ����ŭ ���
		// ��, �� ���� ĭ ���� ��ġ�ϴ� ��ġ���� �� ��ȣ�� ���� ���� ���
		/* 
	 		�� �� : 6 		�� �� : 5		�� �� : 4
	 		ĭ �� : 6		ĭ �� : 4		ĭ �� : 5
	 		1*****		1***		1****
	 		*2****		*2**		*2***
	 		**3***		**3*		**3**
	 	    ***4**		***4		***4*
	 	    ****5*		****
	 	    *****6     
	 	    */
		Scanner sc = new Scanner(System.in);
		System.out.print("����� �� ���� �Է��ϼ��� : ");
		int row = sc.nextInt();
		System.out.print("����� ĭ ���� �Է��ϼ��� : ");
		int col = sc.nextInt();
		
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				if(i == j) {
					System.out.print(j);
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
		}


		
	}
}
