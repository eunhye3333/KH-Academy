package com.kh.example.chap01.condition;

import java.util.Scanner;

public class B_Switch {
	// switch(조건식){
	// case 1 : 실행문1; break; // 조건식의 결과 값이 1일 경우 실핼
	// case 2 : 실행문2; break; // 조건식의 결과 값이 2일 경우 실핼
	// default : 실행문3;       // 조건식의 결과 값이 case에 해당하지 않을 때 실행
	// }
	// 조건식의 결과 값을 case에서 찾아 명령을 수행하는 조건문
	// 해당하는 깂이 case에 없을 경우 default의 명령문 수행
	// case의 수행문 사이에는 콜론(:)을 써주어야 함
	// break가 없으면 멈추지 않고 계속 실행
	
	public void method1() {
		// 정수 두 개와 연산 기호 문자 1개를 입력받아 연산 기호 문자에 해당하는 계산을 수행 후 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 숫자 : ");
		int first = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int second = sc.nextInt();
		
		System.out.print("연산자(+,-,*,/) : ");
//		char op = sc.nextLine().charAt(0); // 버퍼를 비워주지 않아 에러가 남
		// 1. int를 받아올 때 String으로 받아 파싱하기
		// 2. nextLine()으로 줄바꿈 없애기
		// 3. nextLine() 대신 next()로 변경
		char op = sc.next().charAt(0);
		
		int result = 0; // 변수 선언 및 초기화
		switch(op) { // op로 케이스를 나누겠다
		case '+': 
			result = first + second;
			break;
		case '-':
			result = first - second;
			break;
		case '*':
			result = first * second;
			break;
		case '/':
			if(second == 0) { // 0으로 나누는 경우 에러가 뜨는데 해당 에러 발생 방지
				System.out.println("0으로는 나눌 수 없습니다. 결과가 정확하지 않습니다.");
			} else {				
				result = first / second;
			}
			break; 
			// op에 위에 사칙연산이 아닌 기호를 넣는 경우에는 switch문에 들어가지 않기 때문에 result가 0으로 나옴
			// 잘못된 것이기 때문에 default 추가해 안내 문구 삽입
		default :
			System.out.println("예시에 없는 연산자입니다. 결과가 정확하지 않습니다.");
			break; // 없어도 됨
		}

		System.out.printf("%d %c %d = %d", first, op, second, result );
	}
	
	public void method2() {
		System.out.println("***** 신우네 과일 가게 *****");
		System.out.println("사과, 바나나, 복숭아, 키위 있습니다! 가격 편하게 물어보세요!");
		System.out.print("어떤 과일의 가격이 궁금하세요?");
		
		Scanner sc = new Scanner(System.in);
		String fruit = sc.nextLine();
		
		// 사과 1000 / 바나나 3000 / 복숭아 2000 / 키위 5000
		// 없는 과일일 경우, "그 과일은 신우네 과일 가게에 없습니다 ㅠㅠ 옆에 신우 마트로 가 보세요!" 문구 출력
		// 최종 출력 : (ex. 사과의 가격은 1000원입니다.)
		
		int price = 0; // 기본값이 0이라서 0으로 초기화하는데 바로 사용해야 하는 값이 있으면 그 값으로 초기화하면 됨
		boolean flag = false; // 과일이 없을 때 가격 출력하지 않기
		// boolean flag;로 두면 안 됨. 기본값이 false인 것은 맞지만 지역변수를 초기화하지 않으면 실행 불가능
		// 지역변수 (메소드 안에 있는 변수)는 무보건 초기화를 해줘야 사용 가능함. 안에 쓰레기 값이 들어갈 수 있기 때문에.
		// 하지만 메소드 바깥 부분에 만드는 변수(전역 변수)는 초기화하지 않아도 실행이 됨. 전역변수의 공간에는 무조건 기본값이 들어가게 됨.
		switch(fruit) {
		case "사과":
			price = 1000;
			// System.out.println(fruit + "의 가격은 " + price + "원입니다."); 
			// 여기에 마다마다 출력하는 게 없는 과일일 때 가격이 안 나오게 하는 경우에 가장 간단한 방법
			break;
		case "바나나":
			price = 3000;
			break;
		case "복숭아":
			price = 2000;
			break;
		case "키위":
			price = 5000;
			break;
		default :
			System.out.println("그 과일은 신우네 과일 가게에 없습니다 ㅠㅠ 옆에 신우 마트로 가 보세요!");
			flag = true;
			break;
		}
		
//		if(flag == false) { 
		if(!flag) { // flag : false -> if문 실행 (가격 표시 o)
			        // flag : true  -> if문 실행 x (가격 표시 x)
			System.out.println(fruit + "의 가격은 " + price + "원입니다.");
		}
		// flag를 처음부터 true로 값을 줬으면 if(flag)로 하면 됨. 하지만 false로 준 이유는 boolean의 기본값이 false이기 때문.
	}
	
	public void method3() {
		// 1부터 12까지 입력받아 해당하는 달의 마지막 날짜 출력하기
		Scanner sc = new Scanner(System.in);
		System.out.print("달을 입력하세요(1~12) : ");

		int num = sc.nextInt();
		
		int day = 0;
		
		switch(num) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			day = 28;
			break;
		default :
			System.out.println("해당하는 달이 없습니다.");
		}
		
		if(day != 0) {
			System.out.println(num + "월의 마지막 날짜는 " + day + "일입니다");
		}
	}
	
	public void method4() {
		// switch문이 많이 사용되는 사례
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 회원 등록");
		System.out.println("2. 회원 수정");
		System.out.println("3. 회원 삭제");
		System.out.print("메뉴 번호를 입력하세요 : ");
		
		int menu = sc.nextInt();
		switch(menu) {
		case 1:
			System.out.println("회원 등록 메뉴입니다.");
			break;
		case 2:
			System.out.println("회원 수정 메뉴입니다.");
			break;
		case 3:
			System.out.println("회원 삭제 메뉴입니다.");
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public void method5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. 언산하기");
		System.out.println("2. 신우네 과일가게");
		System.out.println("3. 마지막 날짜");
		System.out.println("4. 메뉴 출력");

		int menu = sc.nextInt();
		
		switch(menu) {
		case 1:
			method1(); // 호출하고 싶은 메소드가 같은 클래스에 묶여 있음. 따라서 알맹이를 만들어줄 필요가 없다
			// 메소드가 끝나면 나를 호출해준 쪽으로 돌아감
			break;
		case 2:
			method2();
			break;
		case 3:
			method3();
			break;
		case 4:
			method4();
			break;
		default :
			System.out.println("잘못 입력하셨습니다.");
		}

	}

	
}
