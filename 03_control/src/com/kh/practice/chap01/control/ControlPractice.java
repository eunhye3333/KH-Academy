package com.kh.practice.chap01.control;

import java.util.Scanner;

public class ControlPractice {
	public void practice1() {
		// �޴��� ����ϰ� �޴� ��ȣ�� ������ "oo�޴��Դϴ�"��,
		// ���� ��ȣ�� ������ "���α׷��� ����˴ϴ�."�� ����ϼ���
		
		System.out.println("1. �Է�");
		System.out.println("2. ����");
		System.out.println("3. ��ȸ");
		System.out.println("4. ����");
		System.out.println("7. ����");
		
		Scanner sc = new Scanner(System.in);	
		System.out.print("�޴� ��ȣ�� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("�Է� �޴��Դϴ�.");
			break;
		case 2:
			System.out.println("���� �޴��Դϴ�.");
			break;
		case 3:
			System.out.println("��ȸ �޴��Դϴ�.");
			break;
		case 4:
			System.out.println("���� �޴��Դϴ�.");
			break;
		case 7:
			System.out.println("���α׷��� ����˴ϴ�.");
			break;
		default :
			System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			break;
		}
		
	}
	
	public void practice2() {
		// Ű����� ������ �Է¹ް� �Է��� ������ ����̸鼭 ¦���� ���� "¦����"�� ����ϰ�
		// ¦���� �ƴϸ� "Ȧ����"�� ����ϼ���
		// ����� �ƴϸ� "����� �Է��� �ּ���"�� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���ڸ� �� �� �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			if(num % 2 == 0) {
				System.out.println("¦����");
			} else {
				System.out.println("Ȧ����");
			}
		} else {
			System.out.println("����� �Է��� �ּ���.");
		}

	}
	public void practice3() {
		// ����, ����, ���� �� ������ ������ Ű����� �Է¹ް� �հ�� ��� ���
		// �հ�� ����� �̿��Ͽ� �հ�/���հ��� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("���� ���� : ");
		int korean = sc.nextInt();
		
		System.out.print("���� ���� : ");
		int english = sc.nextInt();
		
		System.out.print("���� ���� : ");
		int math = sc.nextInt();
		
		int sum = korean + english + math;
		double avg = sum / 3;
		
		if(korean >= 40 && english >= 40 && math >= 40 && avg >= 60) {
			System.out.println("���� : " + korean);
			System.out.println("���� : " + english);
			System.out.println("���� : " + math);
			System.out.println("�հ� : " + sum);
			System.out.println("��� : " + avg);
			System.out.println("�����մϴ�, �հ��Դϴ�!");
		} else {
			System.out.println("���հ��Դϴ�.");
		}

	}
	
	public void practice4() {
		// ��, ����, ����, �ܿ��� switch������ ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 ������ ���� �Է� : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1 :
		case 2 :
		case 12 :
			System.out.println(month + "���� �ܿ��Դϴ�");
			break;
		case 3 :
		case 4 :
		case 5 :
			System.out.println(month + "���� ���Դϴ�");
			break;
		case 6 :
		case 7 :
		case 8 :
			System.out.println(month + "���� �����Դϴ�");
			break;
		case 9 :
		case 10 :
		case 11 :
			System.out.println(month + "���� �����Դϴ�");
			break;
		default : 
			System.out.println(month + "���� �߸� �Էµ� ���Դϴ�.");
		}

	}
	
	public void practice5() {
		// ���̵�, ��й�ȣ�� ���صΰ� �α��� ����� �ۼ��ϼ���
		// �α��� ���� �� "�α��� ����", ���̵� Ʋ���� �� "���̵� Ʋ�Ƚ��ϵ�",
		// ��й�ȣ�� Ʋ���� �� "��й�ȣ�� Ʋ�Ƚ��ϴ�"�� ����ϼ���
		String id = "myId";
		String pwd = "myPassword12";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� : ");
		String userId = sc.nextLine();
		System.out.print("��й�ȣ : ");
		String userPwd = sc.nextLine();
		
		if(id.equals(userId) && pwd.equals(userPwd)) {
			System.out.println("�α��� ����");
		} else if (id.equals(userId)) {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		} else {
			System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
		}

	}
	
	public void practice6() {
		// ����ڿ��� ����� �Է� �޾� ������ ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("������ Ȯ���ϰ��� �ϴ� ȸ�� ��� : ");
		String level = sc.nextLine();
		
		switch(level) {
		case "������" :
			System.out.println("ȸ������, �Խñ� ����, �Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ�");
			break;
		case "ȸ��" :
			System.out.println("�Խñ� �ۼ�, �Խñ� ��ȸ, ��� �ۼ�");
			break;
		case "��ȸ��" :
			System.out.println("�Խñ� ��ȸ");
			break;
		default :
			System.out.println("����� �߸� �Է��Ͽ����ϴ�.");
		}
	}
	
	public void practice7() {
		// Ű, �����Ը� �Է¹޾� BMI ������ ����Ͽ� ��� ����� ���� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("Ű(m)�� �Է��� �ּ��� : ");
		double height = sc.nextDouble();

		System.out.print("������(kg)�� �Է��� �ּ��� : ");
		double weight = sc.nextDouble();

		if (height < 0 || weight < 0) {
			System.out.println("������ �Է��� �� �����ϴ�.");
		} else {
			double bmi = weight / (height * height);
			System.out.println("BMI ���� : " + bmi);

			if (bmi >= 0 && bmi < 18.5) {
				System.out.println("��ü��");
			} else if (bmi >= 18.5 && bmi < 23) {
				System.out.println("����ü��");
			} else if (bmi >= 23 && bmi < 25) {
				System.out.println("��ü��");
			} else if (bmi >= 25 && bmi < 30) {
				System.out.println("��");
			} else {
				System.out.println("����");
			}
		}
		
	}
	
	public void practice8() {
		// Ű����� �� ���� ������ ���� ��ȣ�� �Է¹޾� ���� ��ȣ�� ���� �ǻ� ����� �Է��ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�ǿ�����1 �Է� : ");
		int num1 = sc.nextInt();
		
		System.out.print("�ǿ�����2 �Է� : ");
		int num2 = sc.nextInt();
		
		System.out.print("�����ڸ� �Է�(+,-,*,/,%) : ");
		char op = sc.next().charAt(0);
		
		double result = 0.0;
		
		if(num1 > 0 && num2 > 0) {
			switch(op) {
			case '+' :
				result = num1 + num2;
				break;
			case '-' :
				result = num1 - num2;
				break;
			case '*' :
				result = num1 * num2;
				break;
			case '/' :
//				if(num2 != 0) {
//					result = num1 / num2;
//				} else {
//					System.out.println("0���� ���� �� �����ϴ�.");
//				}
				result = num1 / num2; // ����� �Է��϶�� ������ ������� ������ 0���� ���� �� ���ٴ� �ڵ� �߰������� �ʾƵ� ��
				break;
			case '%' :
//				if(num2 != 0) {
//					result = num1 % num2;
//				} else {
//					System.out.println("0���� ���� �� �����ϴ�.");
//				}
				result = num1 % num2; // ����� �Է��϶�� ������ ������� ������ 0���� ���� �� ���ٴ� �ڵ� �߰������� �ʾƵ� ��
				break;
			default : 
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���α׷��� �����մϴ�.");
			}
			System.out.printf("%d %c %d = %f", num1, op, num2, result);
		} else {
			System.out.println("����� �Է��ϼ���.");
		}	
	}
	
	public void practice9() {
		// �߰����, �⸻���, ��������, �⼮ȸ���� �Է��ϰ� Pass �Ǵ� Fail�� ����ϼ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�߰���� ���� : ");
		double mid = sc.nextInt();
		
		System.out.print("�⸻��� ���� : ");
		double fin = sc.nextInt();
		
		System.out.print("���� ���� : ");
		double hw = sc.nextInt();
		
		System.out.print("�⼮ ȸ�� : ");
		double attend = sc.nextInt();
		
		System.out.println("=============== ��� =============");
		
		mid *= 0.2;
		fin *= 0.3;
		hw *= 0.3;
		
		double sum = mid + fin + hw + attend;
		
		if(attend <= 14) {
			System.out.println("Fail [�⼮ ȸ�� ���� (" + (int)attend + "/20)]");
		} else {
			System.out.println("�߰� ��� ����(20) : " + mid);
			System.out.println("�⸻ ��� ����(30) : " + fin);
			System.out.println("���� ����(30) : " + hw);
			System.out.println("�⼮ ����(20) : " + attend);
			System.out.println("���� : " + sum);
			
			if(sum >= 70) {
				System.out.println("PASS");
			} else {
				System.out.println("Fail [���� �̴�]");
			}
		}
		
	}
	
	public void practice10() {
		// �տ� ������ �ǽ� ������ �����Ͽ� ����
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ����� �����ϼ���.");
		System.out.println("1. �޴� ���");
		System.out.println("2. ¦��/Ȧ��");
		System.out.println("3. �հ�/���հ�");
		System.out.println("4. ����");
		System.out.println("5. �α���");
		System.out.println("6. ���� Ȯ��");
		System.out.println("7. BMI");
		System.out.println("8. ����");
		System.out.println("9. P/F");
		
		System.out.print("���� : ");
		int num = sc.nextInt();
		System.out.println("(�ǽ� ����" + num +" ����)");
		
		switch(num) {
		case 1 :
			practice1();
			break;
		case 2 :
			practice2();
			break;
		case 3 :
			practice3();
			break;
		case 4 :
			practice4();
			break;
		case 5 :
			practice5();
			break;
		case 6 :
			practice6();
			break;
		case 7 :
			practice7();
			break;
		case 8 :
			practice8();
			break;
		case 9 :
			practice9();
			break;
		default :
			System.out.println("���� ��ȣ�� �Է��Ͽ����ϴ�.");
		}
	}
}
