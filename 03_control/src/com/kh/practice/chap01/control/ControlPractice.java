package com.kh.practice.chap01.control;

import java.util.Scanner;

public class ControlPractice {
	public void practice1() {
		// 메뉴를 출력하고 메뉴 번호를 누르면 "oo메뉴입니다"를,
		// 종료 번호를 누르면 "프로그램이 종료됩니다."를 출력하세요
		
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 조회");
		System.out.println("4. 삭제");
		System.out.println("7. 종료");
		
		Scanner sc = new Scanner(System.in);	
		System.out.print("메뉴 번호를 입력하세요 : ");
		int num = sc.nextInt();
		
		switch(num) {
		case 1:
			System.out.println("입력 메뉴입니다.");
			break;
		case 2:
			System.out.println("수정 메뉴입니다.");
			break;
		case 3:
			System.out.println("조회 메뉴입니다.");
			break;
		case 4:
			System.out.println("삭제 메뉴입니다.");
			break;
		case 7:
			System.out.println("프로그램이 종료됩니다.");
			break;
		default :
			System.out.println("번호를 잘못 입력하셨습니다.");
			break;
		}
		
	}
	
	public void practice2() {
		// 키보드로 정수를 입력받고 입력한 정수가 양수이면서 짝수일 때만 "짝수다"를 출력하고
		// 짝수가 아니면 "홀수다"를 출력하세요
		// 양수가 아니면 "양수만 입력해 주세요"를 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			if(num % 2 == 0) {
				System.out.println("짝수다");
			} else {
				System.out.println("홀수다");
			}
		} else {
			System.out.println("양수만 입력해 주세요.");
		}

	}
	public void practice3() {
		// 국어, 영어, 수학 세 과목의 점수를 키보드로 입력받고 합계와 평균 계산
		// 합계와 평균을 이용하여 합격/불합격을 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수 : ");
		int korean = sc.nextInt();
		
		System.out.print("영어 점수 : ");
		int english = sc.nextInt();
		
		System.out.print("수학 점수 : ");
		int math = sc.nextInt();
		
		int sum = korean + english + math;
		double avg = sum / 3;
		
		if(korean >= 40 && english >= 40 && math >= 40 && avg >= 60) {
			System.out.println("국어 : " + korean);
			System.out.println("영어 : " + english);
			System.out.println("수학 : " + math);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}

	}
	
	public void practice4() {
		// 봄, 여름, 가을, 겨울을 switch문으로 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1 :
		case 2 :
		case 12 :
			System.out.println(month + "월은 겨울입니다");
			break;
		case 3 :
		case 4 :
		case 5 :
			System.out.println(month + "월은 봄입니다");
			break;
		case 6 :
		case 7 :
		case 8 :
			System.out.println(month + "월은 여름입니다");
			break;
		case 9 :
		case 10 :
		case 11 :
			System.out.println(month + "월은 가을입니다");
			break;
		default : 
			System.out.println(month + "월은 잘못 입력된 달입니다.");
		}

	}
	
	public void practice5() {
		// 아이디, 비밀번호를 정해두고 로그인 기능을 작성하세요
		// 로그인 성공 시 "로그인 성공", 아이디가 틀렸을 시 "아이디가 틀렸습니디",
		// 비밀번호가 틀렸을 시 "비밀번호가 틀렸습니다"를 출력하세요
		String id = "myId";
		String pwd = "myPassword12";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
//		if(id.equals(userId) && pwd.equals(userPwd)) {
//			// 아이디와 패스워드가 모두 같은 경우에만 if문 수행
//			System.out.println("로그인 성공");
//		} else if (id.equals(userId)) {
//			// 아이디가 같고 패스워드가 다른 경우, 아이디가 다르고 패스워드가 같은 경우, 둘 다 다른 경우 중
//			// else if로 아이디가 같고 패스뤄드가 다른 경우를 수행
//			System.out.println("비밀번호가 틀렸습니다.");
//		} else if (pwd.equals(userPwd)) {
//			// 아이디가 다르고 패스워드가 같은 경우, 둘 다 다른 경우 중
//			// else if로 아이디가 다르고 패스워드가 같은 경우를 수행
//			System.out.println("아이디가 틀렸습니다.");
//		}
		
		// equals 확인
//		if("myId".equals(userId) && "myPassword12".equals(userPwd)) {
//			System.out.println("로그인 성공");
//		} else if ("myId".equals(userId)) {
//			System.out.println("비밀번호가 틀렸습니다.");
//		} else if ("myPassword12".equals(userPwd)) {
//			System.out.println("아이디가 틀렸습니다.");
//		} else {
//			System.out.println("아이디와 비밀번호가 모두 틀렸습니다.");
//		}
		
		// 중첩 if문 사용
		if(id.equals(userId)) {
			if(pwd.equals(userPwd)) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		} else {
			if(pwd.equals(userPwd)) {
				System.out.println("아이디가 틀렸습니다.");
			} else {
				System.out.println("아이디와 비밀번호가 모두 틀렸습니다.");
			}
			
		}

	}
	
	public void practice6() {
		// 사용자에게 등급을 입력 받아 권한을 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("권한을 확인하고자 하는 회원 등급 : ");
		String level = sc.nextLine();
		
//		switch(level) {
//		case "관리자" :
//			System.out.println("회원관리, 게시글 관리, 게시글 작성, 게시글 조회, 댓글 작성");
//			break;
//		case "회원" :
//			System.out.println("게시글 작성, 게시글 조회, 댓글 작성");
//			break;
//		case "비회원" :
//			System.out.println("게시글 조회");
//			break;
//		default :
//			System.out.println("등급을 잘못 입력하였습니다.");
//		}

		// 다른 방법
		switch(level) {
		case "관리자" :
			System.out.print("회원관리, 게시글 관리 ");
		case "회원" :
			System.out.print("게시글 작성, 댓글 작성 ");
		case "비회원" :
			System.out.print("게시글 조회");
			break;
		default :
			System.out.println("등급을 잘못 입력하였습니다.");
		}
	}
	
	public void practice7() {
		// 키, 몸무게를 입력받아 BMI 지수를 계산하여 계산 결과에 따라 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();

		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();

		if (height < 0 || weight < 0) {
			System.out.println("음수는 입력할 수 없습니다.");
		} else {
			double bmi = weight / (height * height);
			System.out.println("BMI 지수 : " + bmi);

			if (bmi >= 0 && bmi < 18.5) {
				System.out.println("저체중");
			} else if (bmi >= 18.5 && bmi < 23) {
				System.out.println("정상체중");
			} else if (bmi >= 23 && bmi < 25) {
				System.out.println("과체중");
			} else if (bmi >= 25 && bmi < 30) {
				System.out.println("비만");
			} else {
				System.out.println("고도비만");
			}
		}
		
	}
	
	public void practice8() {
		// 키보드로 두 개의 정수와 연산 기호를 입력받아 연산 기호에 맞춰 연산 결과를 입력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("피연산자1 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("피연산자2 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.print("연산자를 입력(+,-,*,/,%) : ");
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
//					System.out.println("0으로 나눌 수 없습니다.");
//				}
				result = num1 / num2; // 양수만 입력하라는 조건을 세워줬기 때문에 0으로 나눌 수 없다는 코드 추가해주지 않아도 됨
				break;
			case '%' :
//				if(num2 != 0) {
//					result = num1 % num2;
//				} else {
//					System.out.println("0으로 나눌 수 없습니다.");
//				}
				result = num1 % num2; // 양수만 입력하라는 조건을 세워줬기 때문에 0으로 나눌 수 없다는 코드 추가해주지 않아도 됨
				break;
			default : 
				System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
			}
			System.out.printf("%d %c %d = %f", num1, op, num2, result);
		} else {
			System.out.println("양수만 입력하세요.");
		}	
	}
	
	public void practice9() {
		// 중간고사, 기말고사, 과제점수, 출석회수를 입력하고 Pass 또는 Fail을 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("중간고사 점수 : ");
		double mid = sc.nextInt();
		
		System.out.print("기말고사 점수 : ");
		double fin = sc.nextInt();
		
		System.out.print("과제 점수 : ");
		double hw = sc.nextInt();
		
		System.out.print("출석 회수 : ");
		double attend = sc.nextInt();
		
		System.out.println("=============== 결과 =============");
		
		mid *= 0.2;
		fin *= 0.3;
		hw *= 0.3;
		
		double sum = mid + fin + hw + attend;
		
		if(attend <= 14) {
			System.out.println("Fail [출석 회수 부족 (" + (int)attend + "/20)]");
		} else {
			System.out.println("중간 고사 점수(20) : " + mid);
			System.out.println("기말 고사 점수(30) : " + fin);
			System.out.println("과제 점수(30) : " + hw);
			System.out.println("출석 점수(20) : " + attend);
			System.out.println("총점 : " + sum);
			
			if(sum >= 70) {
				System.out.println("PASS");
			} else {
				System.out.println("Fail [점수 미달]");
			}
		}
		
	}
	
	public void practice10() {
		// 앞에 구현한 실습 문제를 선택하여 실행
		Scanner sc = new Scanner(System.in);
		System.out.println("실행할 기능을 선택하세요.");
		System.out.println("1. 메뉴 출력");
		System.out.println("2. 짝수/홀수");
		System.out.println("3. 합격/불합격");
		System.out.println("4. 계절");
		System.out.println("5. 로그인");
		System.out.println("6. 권한 확인");
		System.out.println("7. BMI");
		System.out.println("8. 계산기");
		System.out.println("9. P/F");
		
		System.out.print("선택 : ");
		int num = sc.nextInt();
		System.out.println("(실습 문제" + num +" 실행)");
		
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
			System.out.println("없는 번호를 입력하였습니다.");
		}
	}
	
	public void practice11() {
		// 4자리 정수를 입력받아 중복값이 없는 비밀번호 만들기
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 입력(1000~9999) : ");
		// 풀이 방법 1.
		// 패스워드를 정수로 받아와 연산을 통해 각 자리 숫자를 저장한 후 if문을 이용해 같은 숫자인지 판별
		int pwd = sc.nextInt();
		
		if((pwd - 10000) >= 0){
			System.out.println("자리수 안 맞음");
		} else {
			int pw1 = pwd / 1000;
			int pw2 = (pwd - (pw1 * 1000)) / 100;
			int pw3 = (pwd - (pw1 * 1000) - (pw2 * 100)) / 10;
			int pw4 = (pwd - (pw1 * 1000) - (pw2 * 100) - (pw3 * 10));
			
			if(pw1 == pw2 || pw1 == pw3 || pw1 == pw4 || pw2 == pw3 || pw2 == pw4 || pw3 == pw4) {
				System.out.println("실패");
			} else {
				System.out.println("성공");
			}
		}
		
		
		// 풀이 방법 2. 
		// 패스워드를 문자열로 받아와 char로 바꾼 후 if문을 사용해 같은 숫자인지 판별
//		String strpwd = sc.nextLine();
//		char pw1 = strpwd.charAt(0);
//		char pw2 = strpwd.charAt(1);
//		char pw3 = strpwd.charAt(2);
//		char pw4 = strpwd.charAt(3);
//		
//		int pwd = Integer.parseInt(strpwd);
//		
//		if((pwd - 10000) >= 0 ) {
//			System.out.println("자리수 안 맞음");
//		} else if (pw1 == pw2 || pw1 == pw3 || pw1 == pw4 || pw2 == pw3 || pw2 == pw4 || pw3 == pw4) {
//			System.out.println("실패");
//		} else {
//			System.out.println("성공");
//		}
		
		// 풀이 방법 3.
		// 패스워드를 문자열로 받아와 char로 바꾼 후 if문을 이용해 같은 숫자인지 판별
		// if문의 조건식이 너무 길어져서 for문을 사용해 반복
//		String strpwd = sc.nextLine();
//		
//		int pwd = Integer.parseInt(strpwd);
//		
//		if ((pwd - 10000) >= 0) {
//			System.out.println("자리수 안 맞음");
//		} else {
//			boolean result = false;
//			for (int i = 0; i < 4; i++) {
//				for (int j = i + 1; j < 4; j++) {
//					if (strpwd.charAt(i) == strpwd.charAt(j)) {
//						i = 4;
//						result = true;
//						break;
//					}
//				}
//				
//			}
//			
//			if(result) {
//				System.out.println("실패");
//			} else {
//				System.out.println("성공");
//			}
//		}

	}
}
