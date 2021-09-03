package com.kh.practice.map.view;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import com.kh.example.map.model.vo.Snack;
import com.kh.practice.map.controller.MemberController;
import com.kh.practice.map.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		System.out.println("========= KH ����Ʈ =========");
		
		while(true) {
			System.out.println("******* ���� �޴� *******");
			System.out.println("1. ȸ�� ����");
			System.out.println("2. �α���");
			System.out.println("3. ���� �̸� ȸ�� ã��");
			System.out.println("9. ����");
			System.out.print("�޴� ��ȣ ���� : ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(num) {
			case 1:
				joinMembership();
				break;
			case 2:
				login();
				memberMenu();
				break;
			case 3:
				sameName();
				break;
			case 9:
				System.out.println("���α׷� ����.");
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
			System.out.println();
		}
	}

	public void memberMenu() {
		while(true) {
			System.out.println("******* ȸ�� �޴� *******");
			System.out.println("1. ��й�ȣ �ٲٱ�");
			System.out.println("2. �̸� �ٲٱ�");
			System.out.println("3. �α׾ƿ�");
			
			System.out.print("�޴� ��ȣ ���� : ");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			switch(num) {
			case 1:
				changePassword();
				break;
			case 2:
				changeName();
				break;
			case 3:
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
			System.out.println();
		}
	}


	public void joinMembership() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			System.out.print("�̸� : ");
			String name = sc.nextLine();
			
			if(mc.joinMembership(id, new Member(password, name))) {
				System.out.println("���������� ȸ������ �Ϸ��Ͽ����ϴ�.");
				break;
			} else {
				System.out.println("�ߺ��� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		
	}

	public void login() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			String name = mc.login(id, password);
			
			if(name == null) {
				System.out.println("Ʋ�� ���̵� �Ǵ� ��й�ȣ�Դϴ�. �ٽ� �Է����ּ���");
			} else {
				System.out.println(name + "��, ȯ���մϴ�!");
				break;
			}
		}
	}

	public void changePassword() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String oldPw = sc.nextLine();		
			System.out.print("������ ��й�ȣ : ");
			String newPw = sc.nextLine();	
			
			if(mc.changePassword(id, oldPw, newPw)) {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�.");
				break;
			} else {
				System.out.println("��й�ȣ ���濡 �����߽��ϴ�. �ٽ� �Է��� �ּ���.");
			}
		}
	}
	
	public void changeName() {
		while(true) {
			System.out.print("���̵� : ");
			String id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String password = sc.nextLine();
			
			String name = mc.login(id, password);
			if(name == null) {
				System.out.println("�̸� ���濡 �����߽��ϴ�. �ٽ� �Է��� �ּ���.");
			} else {
				System.out.println("���� ������ �̸� : " + name);
				System.out.print("������ �̸� : ");
				String newName = sc.nextLine();
				mc.changeName(id, newName);
				System.out.println("�̸��� ����Ǿ����ϴ�.");
				break;
			}
		}
	}

	public void sameName() {
		System.out.print("�˻��� �̸� : ");
		String name = sc.nextLine();
		TreeMap<String, String> search = mc.sameName(name);
		
		Iterator<Entry<String, String>> it = search.entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<String, String> e = it.next();
			System.out.println(e.getValue() + "-" + e.getKey());
		
		}
	}

}
