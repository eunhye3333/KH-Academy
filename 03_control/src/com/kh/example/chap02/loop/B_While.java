package com.kh.example.chap02.loop;

import java.util.Scanner;

public class B_While {
	// while(조건식) {
	//	실행 문장;
	//	[증감식 or 분기문]; -> 생략 가능
	// }
	// 조건식 확인 -> (조건식의 결과가 true일 때) 실행 문장 수행 -> 조건식 확인 -> (반복)
	// 조건식의 결과가 false가 될 떄까지 반복
	
	// do {
	//	실행 문장
	//	[증감식 or 분기문];
	// } while(조건식); -> 세미콜론 꼭 붙여야 함
	// 실행 문장 -> 조건식 확인 -> (조건식이 true일 때) do의 실행 문장 수행 -> 조건식 확인 -> (반복)
	// 조건식의 결과가 false가 될 떄까지 반복
	
	// while과 do~while의 차이점 : do~while은 무조건 한 번 이상 수행한다
	
	public void method1() {
		// 1부터 5까지 출력
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			// 증감식이 없으면 1이 계속 반복
			i++;
		}
	}
	
	public void method1_1() {
		// 자기소개 다섯 번 하기 : 내 이름은 박신우야
		int i = 0;
		while(i < 5) {
			System.out.println("내 이름은 박신우야");
			i++;
		}
	}
	
	public void method2() {
		// 5부터 1까지 출력
		int i = 5;
		while(i > 0) {
			System.out.println(i);
			i--;
		}
	}
	
	public void method3() {
		// 문자열을 입력 받아 인덱스별로 문자 출력
		// java
		// 0 : j
		// 1 : a
		// 2 : v
		// 3 : a
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.nextLine();
		
//		int i = 0;
//		while(i < 5) { // 사용자가 몇 글자를 입력하리 모르기 때문에 이미 5로 정해버리면 오류가 나거나 결과를 제대로 출력하지 못할 수 있음
		// 문자열의 길이를 반환하는 메소드 : String 클래스의 length() -> int를 반환
//		int length = str.length(); // int java.lang.String.length()
//		while(i < length) {
//		while(i < str.length()) { // 변수에 값을 저장하지 않고 바로 사용도 가능함
//			char ch = str.charAt(i); // 계속 실행이 되는 것이 아니기 때문에 선언해도 계속 선언이 반복되는 것이 아님
//			System.out.println(i + " : " + ch);
//			i++;
//		}
		
		// for문으로 바꾸기
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			System.out.println(i + " : " + ch);
		}

	}
	
	public void method4() {
		// 구구단
		int i = 2;
		while(i <= 9) {
			int j = 1; // 얘를 밖에다가 두면 새로운 단에서 j가 재설정되지 않기 때문에 꼭 안에 둬야 함
			while(j < 10) {
				System.out.println(i + " X " + j + " = " + i*j );
				j++;
			}
			i++;
		}
	}
	
	public void method5() {
		// 메뉴 반복 출력
		Scanner sc = new Scanner(System.in);
		int menuNum = 0;
		// 9를 누르면 나가야 함. -> 9가 아니면 true
		while(menuNum != 9) {
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1 까지 출력");
			System.out.println("3. 문자열 인덱스");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void method5_1() {
		// 메뉴 반복 출력 do~while
		Scanner sc = new Scanner(System.in);
		int menuNum = 0;
		
		do {
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1 까지 출력");
			System.out.println("3. 문자열 인덱스");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
//			int menuNum = sc.nextInt(); // 이 부분에 쓰면  while(menuNum != 9);에서 오류 남
			                            // 이유 : menuNum이 do 영역에만 영향을 미침. while에는 영향을 미치지 않음.
			menuNum = sc.nextInt();
			
			switch(menuNum) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		} while(menuNum != 9);
	}
	
	public void method6() {
		Scanner sc = new Scanner(System.in);
	
		
		while(true) { // 무조건 실행되게 만들고 싶을 경우 -> 무한 반복문
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1 까지 출력");
			System.out.println("3. 문자열 인덱스");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");

			int menuNum = sc.nextInt();

			switch(menuNum) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("종료합니다.");
//				break; // break 대신 return을 넣으면 이 메소드의 실행을 종료하고 나를 호출한 쪽으로 돌아감 -> 아예 끝내기
				return; // 종료 조건을 넣지 않고 무한 반복인 경우에 종료 조건으로 return을 삽입함
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	public void method6_1() {
		// method6을 do~while로 바꾸기
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("1. 1~5까지 출력");
			System.out.println("2. 5~1 까지 출력");
			System.out.println("3. 문자열 인덱스");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");

			int menuNum = sc.nextInt();

			switch(menuNum) {
			case 1:
				method1();
				break;
			case 2:
				method2();
				break;
			case 3:
				method3();
				break;
			case 9:
				System.out.println("종료합니다.");
				return; 
			default:
				System.out.println("잘못 입력하셨습니다.");
			} 
		} while(true);
	}
	
	public void method7() {
		// 한 줄에 별표(*)가 5번 출력되는데 그 줄은 사용자가 입력한 수만큼 출력
		// 그러나 한 번에 별표가 하나씩만 출력되어야 함
		// for문 method8 while로 바꾸기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 줄 수를 입력하세요 : ");
		int row = sc.nextInt();
		
		int i = 0;
		while(i < row) {
			int j = 0;
			while(j < 5) {
				System.out.print('*');
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	public void method8() {
		// 한 줄에 별표 문자를 입력된 줄 수와 칸 수만큼 출력
		// 단, 줄 수와 칸 수가 일치하는 위치에는 줄 번호에 대한 정수 출력
		// for문 method9 while로 바꾸기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 줄 수를 입력하세요 : ");
		int row = sc.nextInt();
		System.out.print("출력할 칸 수를 입력하세요 : ");
		int col = sc.nextInt();
		
		int i = 1;
		while(i <= row) {
			int j = 1;
			while (j <= col) {
				if(i == j) {
					System.out.print(i);
				} else {
					System.out.print('*');
				}
				j++;
			}
			System.out.println();
			i++;
		}
	}
	
	public void method9() {
		// 키보드로 문자열 값을 입력받아 출력 반복 실행
		// exit가 들어가면 반복 종료 -> exit가 아니면 계속 진행
		Scanner sc = new Scanner(System.in);
		
//		String str = null; // 초기화 시 보통 기본값으로 초기화함
		// String 뿐 아니라 모든 클래스 자료형(참조 자료형)의 기본값은 null
		// null -> 아무것도없는 값 (진공 상태)
		// 잔공 상태로 바로 사용하면 null을 참조하여 에러가 생김
		String str = ""; // null과 완전 다름. 비어 있는 값을 주는 것.
		while(!str.equals("exit")) {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			System.out.println("str : " + str);
		}
	}
	
	public void method10() {
		// do~while
		Scanner sc = new Scanner(System.in);
		
		String str = null; // 여기에서는 null이어도 null pointer exception이 안 뜸
		// do 부분을 먼저 실행한 후 조건식을 확인하기 때문에 str에 있는 null이 날아가고 내가 입력한 문자열이 들어감
		// 따라서 str에 null이 남아있다
		// 만약 문자열 입력에 null을 입력하여도 제대로 실행됨
		// -> 이것은 진짜 null이 아니라 String인 "null"이기 때문에 의미 없음
		do {
			System.out.print("문자열 입력 : ");
			str = sc.nextLine();
			System.out.println("str : " + str);
		} while (!str.equals("exit"));
	}
}
