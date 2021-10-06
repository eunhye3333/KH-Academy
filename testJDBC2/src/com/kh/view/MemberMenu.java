package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		MemberController mc = new MemberController();
		
		int select = 0;
		do {
			System.out.println("\n *** ȸ�� ���� ���α׷� *** \n");
			System.out.println("1. �� ȸ�� ���");
			System.out.println("2. ��� ȸ�� ��ȸ");
			System.out.println("3. Ư�� ���� ȸ�� ��ȸ");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� Ż��");
			System.out.println("0. ���α׷� ����");
			System.out.print("��ȣ ���� : ");
			select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1: mc.insertMember(); break;
			case 2: mc.selectAll(); break;
			case 3: mc.selectMember(); break;
			case 4: break;
			case 5: break;
			case 0: System.out.println("���α׷��� �����մϴ�."); break;
			default : System.out.println("�߸��� ��ȣ�Դϴ�. �ٽ� �Է����ּ���.");
			}
		} while(select != 0);
	}

	public Member insertMember() {
		System.out.print("ȸ�� ���̵� : ");
		String memberId = sc.nextLine();
		
		System.out.print("��й�ȣ : ");
		String memberPwd = sc.nextLine();
		
		System.out.print("�̸� : ");
		String memberName = sc.nextLine();
		
		System.out.print("����(��:M/��:F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);
		
		System.out.print("�̸��� : ");
		String email = sc.nextLine();
		
		System.out.print("��ȭ��ȣ(- ����) : ");
		String phone = sc.nextLine();
		
		System.out.print("���� : ");
		int age = Integer.parseInt(sc.nextLine());
		
		System.out.print("�ּ� : ");
		String address = sc.nextLine();
		
		Member member = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address);
		
		return member;
	}

	public void displaySuccess(String string) {
		System.out.println("���� ��û ���� : " + string);
	}

	public void displayError(String string) {
		System.out.println("���� ��û ���� : " + string);
	}

	public void displayMember(ArrayList<Member> list) {
		System.out.println("���̵�, ��й�ȣ, �̸�, ����, �̸���, ��ȭ��ȣ, �ּ�, ����, ������");
		
		for(Member mem:list) {
			System.out.println(mem);
		}
	}

	public int selectMember() {
		while(true) {
			System.out.println("1. ���̵�� ȸ�� ��ȸ");
			System.out.println("2. ������ ȸ�� ��ȸ");
			System.out.println("0. ���� �޴��� ���ư���");
			int select = Integer.parseInt(sc.nextLine());
			
			switch(select) {
			case 1: case 2: case 0: return select;
			default: System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}
	}

	public String inputMemberId() {
		System.out.print("ȸ�� ���̵� : ");
		String id = sc.nextLine();
		return id;
	}

	public char inputGender() {
		System.out.print("��ȸ�� ���� �Է�(��:M/��:F) : ");
		char gender = sc.nextLine().toUpperCase().charAt(0);
		return gender;
	}
	
}
