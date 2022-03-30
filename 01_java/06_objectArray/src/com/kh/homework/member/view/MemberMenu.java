package com.kh.homework.member.view;

import java.util.Scanner;

import com.kh.homework.member.controller.MemberController;
import com.kh.homework.member.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {}
	
	public void mainMenu() {
		while(true) {
			System.out.println("�ִ� ��� ������ ȸ�� ���� 10���Դϴ�.");
			System.out.println("���� ��ϵ� ȸ�� ���� " + mc.existMemberNum() + "���Դϴ�.");
			
			if(mc.existMemberNum() < 10) {
				System.out.println("1. �� ȸ�� ���");
			} else {
				System.out.println("ȸ�� ���� ��� �� á�� ������ �Ϻ� �޴��� ���µ˴ϴ�.");
			}
			
			System.out.println("2. ȸ�� �˻�");
			System.out.println("3. ȸ�� ���� ����");
			System.out.println("4. ȸ�� ����");
			System.out.println("5. ��� ���");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				insertMember();
				break;
			case 2:
				searchMember();
				break;
			case 3:
				updateMember();
				break;
			case 4:
				deleteMember();
				break;
			case 5:
				printAll();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("��ȣ�� �߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void insertMember() {
		System.out.println("�� ȸ���� ����մϴ�.");
		String id = "";
		while(true) {
			System.out.print("���̵� : ");
			id = sc.next();
			if(mc.checkId(id)) {
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է��� �ּ���.");
			} else {
				break;
			}
		}
		
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("��й�ȣ : ");
		String password = sc.next();
		System.out.print("�̸��� : ");
		String email = sc.next();
		char gender = ' ';
		
		while(true) {
			System.out.print("����(m/f) : ");
			gender = sc.next().charAt(0);
			
			if(gender == 'M' || gender == 'm' || gender == 'F' || gender == 'f') {
				break;
			} else {
				System.out.println("������ �ٽ� �Է��ϼ���.");
			}
		}
		
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		mc.insertMember(id, name, password, email, gender, age);
	}
	
	public void searchMember() {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. ���̵�� �˻��ϱ�");
			System.out.println("2. �̸����� �˻��ϱ�");
			System.out.println("3. �̸��Ϸ� �˻��ϱ�");
			System.out.println("9. �������� ���ư���");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				searchId();
				flag = false;
				break;
			case 2:
				searchName();
				flag = false;
				break;
			case 3:
				searchEmail();
				flag = false;
				break;
			case 9:
				System.out.println("�������� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				return;
			}
		}
	}
	
	public void searchId() {
		System.out.print("�˻��� ���̵� : ");
		System.out.println(mc.searchId(sc.next()));
	}
	
	public void searchName() {
		System.out.print("�˻��� �̸� : ");
		Member[] nameRe = mc.searchName(sc.next());
		if(nameRe == null) {
			System.out.println("�˻� ����� �����ϴ�");
		} else {
			System.out.println("ã���� ȸ�� �˻� ����Դϴ�.");
			System.out.println(nameRe[0].inform());
		}
	}

	public void searchEmail() {
		System.out.print("�˻��� �̸��� : ");
		Member[] emailRe = mc.searchEmail(sc.next());
		if(emailRe == null) {
			System.out.println("�˻� ����� �����ϴ�");
		} else {
			System.out.println("ã���� ȸ�� �˻� ����Դϴ�.");
			System.out.println(emailRe[0].inform());
		}
	}
	
	public void updateMember() {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. ��й�ȣ �����ϱ�");
			System.out.println("2. �̸� �����ϱ�");
			System.out.println("3. �̸��� �����ϱ�");
			System.out.println("9. �������� ���ư���");
			System.out.print("�޴� ��ȣ : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				updatePassword();
				flag = false;
				break;
			case 2:
				updateName();
				flag = false;
				break;
			case 3:
				updateEmail();
				flag = false;
				break;
			case 9:
				System.out.println("�������� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				return;
			}
		}
	}
	
	public void updatePassword() {
		System.out.print("������ ȸ�� ���̵� : ");
		String id = sc.next();
		System.out.print("������ ��й�ȣ : ");
		String password = sc.next();
		
		if(mc.updatePassword(id, password)) {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
	}
	
	public void updateName() {
		System.out.print("������ ȸ�� ���̵� : ");
		String id = sc.next();
		System.out.print("������ �̸� : ");
		String name = sc.next();
		
		if(mc.updateName(id, name)) {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
	}
	
	public void updateEmail() {
		System.out.print("������ ȸ�� ���̵� : ");
		String id = sc.next();
		System.out.print("������ �̸��� : ");
		String email = sc.next();
		
		if(mc.updateEmail(id, email)) {
			System.out.println("������ ���������� �Ǿ����ϴ�.");
		} else {
			System.out.println("�������� �ʴ� ���̵��Դϴ�.");
		}
	}
	
	public void deleteMember() {
		boolean flag = true;
		while(flag) {
			System.out.println("1. Ư�� ȸ�� �����ϱ�");
			System.out.println("2. ��� ȸ�� �����ϱ�");
			System.out.println("9. �������� ���ư���");
			System.out.print("�޴� ��ȣ : ");

			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				deleteOne();
				flag = false;
				break;
			case 2:
				deleteAll();
				flag = false;
				break;
			case 9:
				System.out.println("�������� ���ư��ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				return;
			}
		}
	}

	public void deleteOne() {
		System.out.print("������ ȸ�� ���̵� : ");
		String id = sc.next();

		while(true) {
			System.out.print("���� �����Ͻðڽ��ϱ�? (y/n) : ");
			char answer = sc.next().charAt(0);
			if(answer == 'y' || answer == 'Y') {
				if(mc.delete(id)) {
					System.out.println("���������� �����Ͽ����ϴ�.");
				} else {
					System.out.println("�������� �ʴ� ���̵��Դϴ�.");
				}
				break;
			} else if(answer == 'n' || answer == 'N') {
				break;
			} else {
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void deleteAll() {
		while(true) {
			System.out.print("���� �����Ͻðڽ��ϱ�? (y/n) : ");
			char answer = sc.next().charAt(0);
			if(answer == 'y' || answer == 'Y') {
				mc.delete();
				System.out.println("���������� �����Ͽ����ϴ�.");
				break;
			} else if(answer == 'n' || answer == 'N') {
				break;
			} else {
				System.out.println("�߸� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		}
	}
	
	public void printAll() {
		if(mc.existMemberNum() == 0) {
			System.out.println("����� ȸ���� �����ϴ�.");
		} else {
			mc.printAll();
		}
	}
	
	
}
