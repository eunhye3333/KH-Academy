package com.kh.practice.chap02.loop;

import java.util.Scanner;

public class LoopPractice {
	public void practice1() {
		// �� ���� ���� �Է¹޾� 1���� �� ���ڱ����� ���ڵ��� ��� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();

		if (num < 1) {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		} else {
			for (int i = 1; i <= num; i++) {
				System.out.println(i);
			}
		}

	}

	public void practice2() {
		// 1 �̸��� ���ڰ� �Էµƴٸ� �ٽ� ���� �Է��ϵ���
		Scanner sc = new Scanner(System.in);
		int num = 0;

//		while(num < 1) {
//			System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
//			num = sc.nextInt();
//			if(num < 1) {
//				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
//			}
//		}

		// flag ���
		boolean flag = false;
		while (!flag) {
			System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
			num = sc.nextInt();
			if (num < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
			} else {
				flag = true;
			}
		}

		for (int i = 1; i <= num; i++) {
			System.out.println(i);
		}
	}

	public void practice3() {
		// �� ���� ���� �Է¹޾� 1���� �� ���ڱ����� ��� ���ڸ� �Ųٷ� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();

		if (num < 1) {
			System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
		} else {
//			for(int i = num; i >= 1; i--) {
//				System.out.println(i);
//			}

//			for(int i = 0; i < num; i++) { // i++ ���
//				System.out.println(num - i);
//			}

			for (; num >= 1; num--) { // ���ο� ���� �������� �ʱ�
				System.out.println(num);
			}
		}
	}

	public void practice4() {
		// 1 �̸��� ���� �Է� �� �����
		Scanner sc = new Scanner(System.in);
		int num = 0;

		while (num < 1) {
			System.out.print("1 �̻��� ���ڸ� �Է��ϼ��� : ");
			num = sc.nextInt();
			if (num < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���");
			}
		}

		for (; num >= 1; num--) {
			System.out.println(num);
		}
	}

	public void practice5() {
		// 1���� �Է¹��� �������� ���� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ϳ� �Է��ϼ���(2 �̻�) : ");
		int num = sc.nextInt();
		int sum = 0;

//		if(num >= 2) {
//			for(int i = 1; i <= num; i++) {
//				if(i < num) {
//					System.out.print(i + " + ");
//				} else {
//					System.out.print(i + " = ");
//				}
//				sum += i;
//			}
//			System.out.print(sum);
//		} else {
//			System.out.println("�߸� �Է��Ͽ����ϴ�");
//		}

		// ���ڸ� ����
		if (num >= 2) {
			for (int i = 1; i <= num; i++) {
				System.out.print(i);
				if (i < num) {
					System.out.print(" + ");
				} else {
					System.out.print(" = ");
				}
				sum += i;
			}
			System.out.print(sum);
		} else {
			System.out.println("�߸� �Է��Ͽ����ϴ�");
		}
	}

	public void practice6() {
		// �� ���� ���� �Է¹޾� �� ������ ���� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("ù ��° ���� : ");
		int num1 = sc.nextInt();
		System.out.print("�� ��° ���� : ");
		int num2 = sc.nextInt();

		int start = 0;
		int end = 0;

		if (num1 == 0 || num2 == 0) {
			System.out.println("1 �̻��� ���ڸ� �Է��ϼ���");
		} else {
			if (num1 <= num2) {
				start = num1;
				end = num2;
			} else {
				start = num2;
				end = num1;
			}

			for (; start <= end; start++) {
				System.out.println(start);
			}
		}
	}

	public void practice7() {
		// �� ���� ���� �Է¹޾� �� ������ ���� ���
		// 1 �̸��� ���ڰ� �ԷµǸ� �ٽ� �Է��ϵ���
		Scanner sc = new Scanner(System.in);
		int num1 = 0;
		int num2 = 0;

		while (num1 < 1 || num2 < 1) {
			System.out.print("ù ��° ���� : ");
			num1 = sc.nextInt();
			System.out.print("�� ��° ���� : ");
			num2 = sc.nextInt();

			if (num1 < 1 || num2 < 1) {
				System.out.println("1 �̻��� ���ڸ� �Է����ּ���.");
			}
		}

		int start = 0;
		int end = 0;
		if (num1 <= num2) {
			start = num1;
			end = num2;
		} else {
			start = num2;
			end = num1;
		}

		for (; start <= end; start++) {
			System.out.println(start);
		}
	}

	public void practice8() {
		// �Է¹��� ������ �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int dan = sc.nextInt();

		System.out.println("============ " + dan + "�� ============");
//		for(int i = 1; i < 10; i++) {
//			System.out.printf("%d * %d = %d%n", dan, i, dan*i);
//		}

		for (int i = 1; i < 10; i++) {
			System.out.printf("%d * %d = %2d%n", dan, i, dan * i);
			// ������ ����
		}

	}

	public void practice9() {
		// �Է¹��� ������ �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int dan = sc.nextInt();

		if (dan > 9) {
			System.out.println("9 ������ ���ڸ� �Է��� �ּ���");
		} else {
			for (; dan < 10; dan++) {
				System.out.println("======== " + dan + "�� ========");
				for (int i = 1; i < 10; i++) {
					System.out.printf("%d * %d = %d%n", dan, i, dan * i);
				}
			}

		}
	}

	public void practice10() {
		// �߸� �Է����� ��� �ٽ� �Է�
		Scanner sc = new Scanner(System.in);
		int dan = 0;
		while (dan < 2 || dan > 9) {
			System.out.print("���� : ");
			dan = sc.nextInt();
			if (dan < 2 || dan > 9) {
				System.out.println("2 �̻�, 9 ������ ���ڸ� �Է��� �ּ���.");
			}
		}

		for (; dan < 10; dan++) {
			System.out.println("======== " + dan + "�� ========");
			for (int i = 1; i < 10; i++) {
				System.out.printf("%d * %d = %d%n", dan, i, dan * i);
			}
		}
	}

	public void practice11() {
		// ���� ���ڿ� ������ �Է¹޾� ������ ������ ���ڰ� Ŀ���ų� �۾����� �ϼ���
		// ��µǴ� ���� -> 10��
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� : ");
		int start = sc.nextInt();
		System.out.print("���� : ");
		int gap = sc.nextInt();

//		for(int i = 0; i < 10; i++) {
//			System.out.print(start + gap * i + " ");
//		}

		// ���� ���� ����
		int end = start + 10 * gap;
		for (; start < end; start += gap) {
//		for(; start < start + 10 * gap; start += gap) { // �ϸ� �� ��
			System.out.print(start + " ");
		}
	}

	public void practice12() {
		// ���� �� ���� �����ڸ� �Է¹޾� �˸��� ��� ���
		Scanner sc = new Scanner(System.in);

		// ��� 1
//		while(true) {
//			System.out.print("������(+, -, *, /, %) : ");
//			String op= sc.next();
//			
//			System.out.print("����  1 : ");
//			int num1 = sc.nextInt();
//			System.out.print("���� 2 : ");
//			int num2 = sc.nextInt();
//			
//			switch(op) {
//			case "+" :
//				System.out.printf("%d %s %d = %d", num1, op, num2, num1 + num2);
//				return;
//			case "-" :
//				System.out.printf("%d %s %d = %d", num1, op, num2, num1 - num2);
//				return;
//			case "*" :
//				System.out.printf("%d %s %d = %d", num1, op, num2, num1 * num2);
//				return;
//			case "/" :
//				if (num2 == 0) {
//					System.out.println("0���δ� ���� �� �����ϴ�. �ٽ� �Է����ּ���.");
//				} else {
//					System.out.printf("%d %s %d = %d", num1, op, num2, num1 / num2);
//					return;
//				}
//				break;
//			case "%" :
//				if (num2 == 0) {
//					System.out.println("0���δ� ���� �� �����ϴ�. �ٽ� �Է����ּ���.");
//				} else {
//					System.out.printf("%d %s %d = %d", num1, op, num2, num1 % num2);
//					return;
//				}
//				break;
//			case "exit":
//				System.out.println("���α׷��� �����մϴ�.");
//				return;
//			default :
//				System.out.println("���� �������Դϴ�. �ٽ� �Է����ּ���.");
//			}
//		}

		// ��� 2
		String op = "";
		while (!op.equals("exit")) {
			System.out.print("������(+, -, *, /, %) : ");
			op = sc.next();

			System.out.print("����  1 : ");
			int num1 = sc.nextInt();
			System.out.print("���� 2 : ");
			int num2 = sc.nextInt();

			switch (op) {
			case "+":
				System.out.printf("%d %s %d = %d", num1, op, num2, num1 + num2);
				break;
			case "-":
				System.out.printf("%d %s %d = %d", num1, op, num2, num1 - num2);
				break;
			case "*":
				System.out.printf("%d %s %d = %d", num1, op, num2, num1 * num2);
				break;
			case "/":
				if (num2 == 0) {
					System.out.println("0���δ� ���� �� �����ϴ�. �ٽ� �Է����ּ���.");
				} else {
					System.out.printf("%d %s %d = %d", num1, op, num2, num1 / num2);
					break;
				}
				break;
			case "%":
				if (num2 == 0) {
					System.out.println("0���δ� ���� �� �����ϴ�. �ٽ� �Է����ּ���.");
				} else {
					System.out.printf("%d %s %d = %d", num1, op, num2, num1 % num2);
					break;
				}
				break;
			default:
				System.out.println("���� �������Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	public void practice13() {
		// �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int line = sc.nextInt();

		for (int i = 1; i <= line; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice14() {
		// �� ��� (������)
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int line = sc.nextInt();

//		for(int i = line; i > 0; i--) {
//			for(int j = i; j > 0; j--) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}

		// ���� ���� ����
		for (; line > 0; line--) {
			for (int j = line; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice15() {
		// �Է¹��� ���� �Ҽ����� �Ǵ��ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		int count = 0;

		if (num >= 2) {
			for (int i = 1; i <= num; i++) {
				if (num % i == 0) {
					count++;
				}
			}

			if (count == 2) {
				System.out.println("�Ҽ��Դϴ�.");
			} else {
				System.out.println("�Ҽ��� �ƴմϴ�.");
			}
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

	public void practice16() {
		// �Ҽ� �Ǻ� �� �߸� �Է��� ��� �ٽ� �Է�
		Scanner sc = new Scanner(System.in);
		int num = 0;
		while (true) {
			System.out.print("���� : ");
			num = sc.nextInt();

			if (num >= 2) {
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}

		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
			}
		}

		if (count == 2) {
			System.out.println("�Ҽ��Դϴ�.");
		} else {
			System.out.println("�Ҽ��� �ƴմϴ�.");
		}

	}

	public void practice17() {
		// 2���� ����ڰ� �Է��� �������� �Ҽ��� ��� ����ϰ� �Ҽ��� ������ ����ϻ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� : ");
		int num = sc.nextInt();
		int pnum = 0;
		int count = 0;

		if (num >= 2) {
			for (int i = 2; i <= num; i++) {
				for (int j = 1; j <= i; j++) {
					if (i % j == 0) {
						pnum++;
					}
				}
				if (pnum == 2) {
					System.out.print(i + " ");
					count++;
				}
				pnum = 0;
			}
			System.out.println();
			System.out.printf("2���� %d���� �Ҽ��� ������ %d���Դϴ�.%n", num, count);
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	}

	public void practice18() {
		// 1���� ����ڿ��� �Է¹��� ������ �� 2�� 3�� ����� ��� ����ϰ� 2�� 3�� ������� ������ ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�ڿ��� �ϳ��� �Է��ϼ��� : ");
		int num = sc.nextInt();
		int count = 0;

		if (num >= 1) {
			for (int i = 1; i <= num; i++) {
				if (i % 2 == 0 || i % 3 == 0) {
					if (i % 2 == 0 && i % 3 == 0) {
						count++;
					}
					System.out.print(i + " ");
				}
			}
			System.out.println();
			System.out.println("count : " + count);
		} else {
			System.out.println("�ڿ����� �ƴմϴ�.");
		}
	}

	public void practice19() {
		// �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int row = sc.nextInt();

		for (int i = 1; i <= row; i++) {
			for (int j = row; j >= 1; j--) {
				if (i >= j) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public void practice20() {
		// �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = num - 1; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice21() {
		// �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			for (int j = num; j > 0; j--) {
				if (j <= i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			for (int j = 1; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public void practice22() {
		// �� ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= num; j++) {
				if(i == 1 || i == num) {
					System.out.print("*");
				} else {
					if(j == 1 || j == num) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
}
