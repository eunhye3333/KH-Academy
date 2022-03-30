package com.kh.homework.employee.view;

import java.util.Scanner;

import com.kh.homework.employee.controller.EmployeeController;

public class EmployeeMenu {
	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec = new EmployeeController();
	
	public EmployeeMenu() {
		while(true) {
			System.out.println("1. 사원 추가");
			System.out.println("2. 사원 수정");
			System.out.println("3. 사원 삭제");
			System.out.println("4. 사원 출력");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호를 누르세요 : ");
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
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못된 메뉴 선택입니다. 다시 입력하세요.");
			}
		}
		
	}
	
	public void insertEmp() {
		// 저장할 데이터를 사용자에게 받는 메소드
		System.out.print("사원 번호 : ");
		int empNo = sc.nextInt();
		System.out.print("사원 이름 : ");
		String name = sc.next();
		System.out.print("사원 성별 : ");
		char gender = sc.next().charAt(0);
		System.out.print("전화 번호 : ");
		String phone = sc.next();
		
		while(true) {
			System.out.print("추가 정보를 더 입력하시겠습니까?(y/n) : ");
			char more = sc.next().charAt(0);
			if(more == 'y' || more == 'Y') {
				System.out.print("사원 부서 : ");
				String dept = sc.next();
				System.out.print("사원 연봉 : ");
				int salary = sc.nextInt();
				System.out.print("보너스 율 : ");
				double bonus = sc.nextDouble();
				
				ec.add(empNo, name, gender, phone, dept, salary, bonus);
				break;
			} else if(more == 'n' || more == 'N') {
				ec.add(empNo, name, gender, phone);
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}
		}
	}
	
	public void updateEmp() {
		// 수정할 데이터를 사용자에게 받는 메소드
		boolean flag = false; 
		
		while(!flag) {
			System.out.println("가장 최신의 사원 정보를 수정하게 됩니다.");
			System.out.println("사원의 어떤 정보를 수정하시겠습니까?");
			System.out.println("1. 전화 번호");
			System.out.println("2. 사원 연봉");
			System.out.println("3. 보너스  율");
			System.out.println("9. 돌아가기");
			
			System.out.print("메뉴 번호를 누르세요 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.print("수정할 전화 번호 : ");
				ec.modify(sc.next());
				flag = true;
				break;
			case 2:
				System.out.print("수정할 사원 연봉 : ");
				ec.modify(sc.nextInt());
				flag = true;
				break;
			case 3:
				System.out.print("수정할 보너스 율 : ");
				ec.modify(sc.nextDouble());
				flag = true;
				break;
			case 9:
				System.out.println("메인메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}
		}
		
	}
	
	public void deleteEmp() {
		// 데이터를 삭제하는 메소드
		while(true) {
			System.out.println("정말 삭제하시겠습니까? (y/n) : ");
			char delete = sc.next().charAt(0);
			if(delete == 'y' || delete == 'Y') {
				if(ec.remove() == null) {
					System.out.println("데이터 삭제에 성공하였습니다.");
				} else {
					System.out.println("데이터 삭제에 실패하였습니다.");
				}
				break;
			} else if (delete == 'N' || delete == 'n') {
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력하세요.");
			}
		}
	}
	
	public void printEmp() {
		// 데이터를 출력하는 메소드
		if(ec.inform() == null) {
			System.out.println("사원 데이터가 없습니다.");
		} else {
			System.out.println(ec.inform());
		}
	}
	
}
