package com.kh.homework.employee.view;

import java.util.Scanner;

import com.kh.homework.employee.controller.EmployeeController;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();
	
	public EmployeeMenu() {
		while(true) {
			System.out.println("1. ��� �߰�");
			System.out.println("2. ��� ����");
			System.out.println("3. ��� ����");
			System.out.println("4. ��� ���");
			System.out.println("9. ���α׷� ����");
			System.out.print("�޴� ��ȣ�� �������� : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				insertEmp();
				break;
			case 2:
				updateEmp();
				break;
			case 3:
				deleteEmp();
				break;
			case 4:
				printEmp();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default :
				System.out.println("�߸��� �޴� �����Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		
	}
	
	public void insertEmp() {
		// ������ �����͸� ����ڿ��� �޴� �޼ҵ�
		System.out.print("��� ��ȣ : ");
		int empNo = sc.nextInt();
		System.out.print("��� �̸� : ");
		String name = sc.next();
		System.out.print("��� ���� : ");
		char gender = sc.next().charAt(0);
		System.out.print("��ȭ ��ȣ : ");
		String phone = sc.next();
		
		while(true) {
			System.out.print("�߰� ������ �� �Է��Ͻðڽ��ϱ�?(y/n) : ");
			char more = sc.next().charAt(0);
			if(more == 'y' || more == 'Y') {
				System.out.print("��� �μ� : ");
				String dept = sc.next();
				System.out.print("��� ���� : ");
				int salary = sc.nextInt();
				System.out.print("���ʽ� �� : ");
				double bonus = sc.nextDouble();
				
				ec.add(empNo, name, gender, phone, dept, salary, bonus);
				break;
			} else if(more == 'n' || more == 'N') {
				ec.add(empNo, name, gender, phone);
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void updateEmp() {
		// ������ �����͸� ����ڿ��� �޴� �޼ҵ�
		boolean flag = false; 
		
		while(!flag) {
			System.out.println("���� �ֽ��� ��� ������ �����ϰ� �˴ϴ�.");
			System.out.println("����� � ������ �����Ͻðڽ��ϱ�?");
			System.out.println("1. ��ȭ ��ȣ");
			System.out.println("2. ��� ����");
			System.out.println("3. ���ʽ�  ��");
			System.out.println("9. ���ư���");
			
			System.out.print("�޴� ��ȣ�� �������� : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.print("������ ��ȭ ��ȣ : ");
				ec.modify(sc.next());
				flag = true;
				break;
			case 2:
				System.out.print("������ ��� ���� : ");
				ec.modify(sc.nextInt());
				flag = true;
				break;
			case 3:
				System.out.print("������ ���ʽ� �� : ");
				ec.modify(sc.nextDouble());
				flag = true;
				break;
			case 9:
				System.out.println("���θ޴��� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
		
	}
	
	public void deleteEmp() {
		// �����͸� �����ϴ� �޼ҵ�
		while(true) {
			System.out.println("���� �����Ͻðڽ��ϱ�? (y/n) : ");
			char delete = sc.next().charAt(0);
			if(delete == 'y' || delete == 'Y') {
				if(ec.remove() == null) {
					System.out.println("������ ������ �����Ͽ����ϴ�.");
				} else {
					System.out.println("������ ������ �����Ͽ����ϴ�.");
				}
				break;
			} else if (delete == 'N' || delete == 'n') {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void printEmp() {
		// �����͸� ����ϴ� �޼ҵ�
		if(ec.inform() == null) {
			System.out.println("��� �����Ͱ� �����ϴ�.");
		} else {
			System.out.println(ec.inform());
		}
	}
	
}
