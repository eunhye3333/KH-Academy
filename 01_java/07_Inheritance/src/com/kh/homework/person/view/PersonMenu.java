package com.kh.homework.person.view;

import java.util.Scanner;

import com.kh.homework.person.controller.PersonController;

public class PersonMenu {
	private Scanner sc = new Scanner(System.in);
	private PersonController pc = new PersonController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("학생은 최대 3명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 학생은 " + pc.personCount()[0] + "명입니다.");
			System.out.println("사원은 최대 10명까지 저장할 수 있습니다.");
			System.out.println("현재 저장된 사원은 " + pc.personCount()[1] + "명입니다.");
			System.out.println();
			
			System.out.println("1. 햑생 메뉴");
			System.out.println("2. 사원 메뉴");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				studentMenu();
				break;
			case 2:
				employeeMenu();
				break;
			case 9:
				System.out.println("종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				System.out.println();
			}
		}
		
	}
	
	public void studentMenu() {
		while(true) {
			System.out.println();
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 보기");
			System.out.println("9. 메인으로");
			
			if(pc.personCount()[0] == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가 메뉴는 더 이상 활성화되지 않습니다.");
			}
			
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 2:
				printStudent();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;

			case 1:
				if(pc.personCount()[0] != 3) {
					insertStudent();
					break;
				}
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				break;
			}
		}
	}
	
	public void employeeMenu() {
		while(true) {
			System.out.println();
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 보기");
			System.out.println("9. 메인으로");
			
			if(pc.personCount()[1] == 10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가 메뉴는 더 이상 활성화되지 않습니다.");
			}
			
			System.out.print("메뉴 번호 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 2:
				printEmployee();
				break;
			case 9:
				System.out.println("메인으로 돌아갑니다.");
				return;

			case 1:
				if(pc.personCount()[1] != 10) {
					insertEmployee();
					break;
				}
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.");
				break;
			}
		}
	}
	
	public void insertStudent() {
		char stop = ' ';
		while(stop != 'n' && stop != 'N') {
			System.out.println();
			System.out.print("학생 이름 : ");
			String name = sc.next();
			System.out.print("학생 나이 : ");
			int age = sc.nextInt();
			System.out.print("학생 키 : ");
			double height = sc.nextDouble();
			System.out.print("학생 몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("학생 학년 : ");
			int grade = sc.nextInt();
			System.out.print("학생 전공 : ");
			String major = sc.next();
			
			pc.insertStudent(name, age, height, weight, grade, major);
			
			if(pc.personCount()[0] == 3) {
				System.out.println("학생을 담을 수 있는 공간이 꽉 찼기 때문에 학생 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				return;
			}
			
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			stop = sc.next().charAt(0);
		}
	}
	
	public void printStudent() {
		for(int i = 0; i < pc.printStudent().length; i++) {
			System.out.println(pc.printStudent()[i]);
		}
	}
	
	public void insertEmployee() {
		char stop = ' ';
		while(stop != 'n' && stop != 'N') {
			System.out.println();
			System.out.print("사원 이름 : ");
			String name = sc.next();
			System.out.print("사원 나이 : ");
			int age = sc.nextInt();
			System.out.print("사원 키 : ");
			double height = sc.nextDouble();
			System.out.print("사원 몸무게 : ");
			double weight = sc.nextDouble();
			System.out.print("사원 급여 : ");
			int salary = sc.nextInt();
			System.out.print("사원 부서 : ");
			String dept = sc.next();
			
			pc.insertEmployee(name, age, height, weight, salary, dept);
			
			if(pc.personCount()[1] == 10) {
				System.out.println("사원을 담을 수 있는 공간이 꽉 찼기 때문에 사원 추가를 종료하고 학생 메뉴로 돌아갑니다.");
				return;
			}
			
			System.out.print("그만하시려면 N(또는 n), 이어하시려면 아무 키나 누르세요 : ");
			stop = sc.next().charAt(0);
		}
	}
	
	public void printEmployee() {
		for(int i = 0; i < pc.printEmployee().length; i++) {
			System.out.println(pc.printEmployee()[i]);
		}
	}
}
