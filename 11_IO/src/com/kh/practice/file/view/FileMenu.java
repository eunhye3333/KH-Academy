package com.kh.practice.file.view;

import java.util.Scanner;

import com.kh.practice.file.controller.FileController;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("***** My Note *****");
			System.out.println("1. ��Ʈ ���� �����");
			System.out.println("2. ��Ʈ ����");
			System.out.println("3. ��Ʈ ��� �����ϱ�");
			System.out.println("9. ������");
			System.out.print("�޴� ��ȣ : ");
			int num = Integer.parseInt(sc.nextLine());
			
			switch(num) {
			case 1:
				fileSave();
				break;
			case 2:
				fileOpen();
				break;
			case 3:
				fileEdit();
				break;
			case 9:
				System.out.println("���α׷��� �����մϴ�.");
				return;
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
			
		}
	}

	private void fileSave() {
		StringBuilder sb = new StringBuilder();
		while(true) {
			System.out.println("���Ͽ� ������ ������ �Է��ϼ���.");
			System.out.println("ex��it �̶�� �Է��ϸ� ����˴ϴ�.");
			System.out.print("���� : ");
			String str = sc.nextLine();
			
			if(str.equals("ex��it")) {
				break;
			} else {
				sb.append(str + "\n");
			}
		}
		
		String file = null;
		
		while(true) {
			System.out.print("������ ���� ���� �Է����ּ���(ex. myFile.txt) : ");
			file = sc.nextLine();
			if(fc.checkName(file)) {
				System.out.println("�̹� �����ϴ� �����Դϴ�. ����ðڽ��ϱ�?(y/n) : ");
				char cover = sc.nextLine().toUpperCase().charAt(0);
				if(cover == 'Y') {
					break;
				}
			} else {
				break;
			}
		}
		fc.fileSave(file, sb);
	}
	
	public void fileOpen() {
		System.out.print("�� ���� �� : ");
		String file = sc.nextLine();
		if(fc.checkName(file)) {
			System.out.println(fc.fileOpen(file));
		} else {
			System.out.println("���� �����Դϴ�.");
		}
	}
	

	public void fileEdit() {
		System.out.print("������ ���� �� : ");
		String file = sc.nextLine();
		if(fc.checkName(file)) {
			StringBuilder sb = new StringBuilder();
			while(true) {
				System.out.println("���Ͽ� ������ ������ �Է��ϼ���.");
				System.out.println("ex��it �̶�� �Է��ϸ� ����˴ϴ�.");
				System.out.print("���� : ");
				String str = sc.nextLine();
				
				if(str.equals("ex��it")) {
					break;
				} else {
					sb.append(str + "\n");
				}
			}
			
			fc.fileEdit(file, sb);
		} else {
			System.out.println("���� �����Դϴ�.");
		}
	}
	
}
