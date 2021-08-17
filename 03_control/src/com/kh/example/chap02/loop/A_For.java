package com.kh.example.chap02.loop;

import java.util.Scanner;

public class A_For {
	// for(조기식; 조건식; 증감식){
	//	실행문장;
	// }
	// 초기식 -> 조건식 확인 -> (조건식이 true일 때) 실행 문장 수행 -> 증감식 -> 조건식 확인 -> (반복)
	
	// for문 안에 있는 초기식, 조건식, 증감식 생략 가능
	// 소괄호 안에서만 생략되는 거지 밖에서든 안에서든 어디에서든 표기는 해야 함. 안 그러면 for문 밖으로 나갈 수 없기 때문에.
	// 초기식은 무엇인지, 조건은 무엇인지, 증감은 얼마나 되는지 다 표기해야함
	// 결국 for문의 소괄호() 안에서만 생략될뿐 모두 필요한 요소들이다
	public void method1() {
		// 1부터 5까지 출력
		// System.out.println();으로 찍어 줄 수 있지만 5개 이상이 되면 하나하나 찍기 힘듦
		for(int i = 1; i <= 5; i++) {
			// 증감식을 안 넣으면 i 값이 바뀌지 않기 때문에 계속 무한대로 1만 찍힘
			System.out.println(i);
			// 증감식을 생략하고 싶으면 여기애 i++을 넣어도 됨
			// 위에서는 생략 가능하나 증감식이 무조건 있긴 있어야 됨
		}
	}
	
	public void method1_1() {
		// 자기소개 다섯 번 하기 : 내 이름은 박신우야
		for(int i = 0; i < 5; i++) { 
//		for(int i = 1; i <= 5; i++) {
//		for(int i = 2; i <= 6; i++) { // 이것도 5번 반복임
			System.out.println("내 이름은 박신우야");
		}
		// 위에 method1은 1부처 5까지 출력이기 때문에 1부터 시작해야 편함
		// 하지만 자기소개는 숫자 상관없이 5번 출력만 하면 되기 때문에 5번 반복만 하면 되므로 i에 어떤 수가 들어가든 상관없다
	}
	
	public void method2() {
		// 5부터 1까지 출력 (거꾸로)
		for(int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}
	
	public void method2_1() {
		// 8부터 3까지 출력
		for(int i = 8; i >= 3; i--) {
			System.out.println(i);
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.println(8 - i);
		} // 이렇게도 가능
	}
	
	public void method3() {
		// 1부터 10 사이의 숫자 중 홀수만 출력 : 1 3 5 7 9
		// for문만 이용
		for(int i = 1; i <= 10;) { 
//		for(int i = 1; i <= 10; i+=2) {
			System.out.println(i);
			i += 2;
		}
		
		// for문 + if문
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 1) {
				System.out.println(i);
			}
		}
	}
	
	public void method4() {
		// 정수 두 개를 입력받아 그 사이 숫자 출력
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int start = sc.nextInt();

		System.out.print("두 번째 숫자 : ");
		int end = sc.nextInt();
		
		for(int i = start; i <= end; i++) {
			System.out.println(i);
			// 문제점 : 두 번째 숫자가 작은 경우에는 아예 안 나옴. 조건식이 처음부터 false이기 때문에
		}
		
		// 해결 방법
		int max = 0; // 두 숫자 중 큰 숫자 저장
		int min = 0; // 두 숫자 중 작은 숫자 저장
		
		if(start > end) {
			max = start;
			min = end;
		} else { // start <= end
			max = end;
			min = start;
		} // if문이 끝나면 무조건 max에는 큰 숫자, min에는 작은 숫자가 들어가 있게 됨
		
//		for(int i = min; i <= max; i++) {
//			System.out.println(i);
//		}
		for(; min <= max; min++) { // 위에 선언한 변수를 사용하므로 초기식 생략 가능
			System.out.println(min);
		}
		
		// for문에서 후휘 연산을 주로 쓰는 이유 : 그냥 보통 그렇게 씀
	}
	
	public void method4_1() {
		// 정수를 하나 입력받아 그 수가 1~9 사이의 수일 때만 그 수의 구구단 출력
		// 조건이 맞지 않으면 "1~9 사이의 양수를 입력하여야 합니다" 출력
		Scanner sc = new Scanner(System.in);
		System.out.print("1~9 사이의 양수를 하나 입력하세요 : ");
		int dan = sc.nextInt();
		
		// 입력된 숫자가 1~9 사이의 숫자인지 확인
		if(dan >= 1 && dan <= 9) {
			System.out.println("============ " + dan + "단 출력 ============");
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d X %d = %d%n", dan, i, (dan * i));
//				System.out.printf("%d X %d = %2d%n", dan, i, (dan * i)); // 2개의 칸을 만들어 오른쪽 정렬, -2d는 왼쪽 정렬
			}
		} else {
			System.out.println("1~9 사이의 양수를 입력하여야 합니다");
		}
		
	}
	
	public void method5() {
		// 1부처 10 사이의 임의의 난수를 정해 1부터 난수까지의 정수 합계
		// 난수 : 랜덤한 숫자
		// 만드는 법 : Math.random() 사용 -> 출력해보면 double로 랜덤한 숫자가 나옴
		// double java.lang.Math.random()
		//        ----------------------- -> 클래스의 풀네임
		// ------ -> 반환값
		// 이 메소드가 어떤 값을 반환하는지 궁금하면 마우스를 올려서 확인 가능
//		double random = Math.random();
		// 만들고자 하는 난수가 1~10까지의 정수임
		// 정수로 바꾸기
		// (0단계) 0 <= Math.random() < 1 : double
		// (1단계) 0 <= Math.random() * 10 < 1 * 10 : 반환값 -> 0.0 ~ 9.99999999999... => 곱하기 10
		// (2단계) 0 + 1 <= Math.random() * 10 + 1 < 10 + 1 : 반환값 -> 1.0 ~ 10.99999999999... => 더하기 1
		// (3단계) 1 <= (int)Math.random() * 10 < 11 : 반환값 -> 1 ~ 10 => int로 강제 형변환
		// 2단계와 3단계의 순서는 바뀌어도 상관없음
		
		int random = (int)(Math.random() * 10 + 1);
		int sum = 0;
		
		for(int i = 1; i <= random; i++) {
			sum +=i;
		}
		
		System.out.println("1부터 " + random + "까지의 정수 합계 : " + sum);
	}
	
	public void method6() {
		// 2단부터 9단까지 출력
		// 2*1=2 2*2=4 2*3=6 .... 2*9=18
		// 3*1=3 3*2=6 3*3=9 .... 3*9=27
		// 크게 도는 것 : 단 -> 큰 for문
		// 작게 도는 것 : 수 -> 작은 for문
		
		for(int i = 2; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) { // i는 이미 스택에 선언되어 있으므로 또 i를 사용하면 안 됨
				System.out.println(i + " * " + j + " = " + i*j);
			}
		}
	}
	
	public void method7() {
		// 0시 0분 ~ 23시 59분
		for(int i = 0; i < 24; i++) {
			for(int j = 0; j < 60; j++) {
				System.out.println(i + "시 " + j + "분");
				System.out.printf("%2d시 %2d분%n", i, j);
			}
		}
	}
	
	public void method8() {
		// 한 줄에 별표(*)가 5번 출력되는데 그 줄은 사용자가 입력한 수만큼 출력
		/* 
		 	출력할 줄 수 : 3      출력할 줄 수 : 5 
		 	*****         *****
		 	*****         *****
		 	*****         *****
		 	              *****
		 	              *****
		 */
		// 그러나 한 번에 별표가 하나씩만 출력되어야 함
		// 틀린 답안
//		for(int i = 1; i <= 3; i++) {
//			System.out.println("*****");
//		}
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 줄 수를 입력하세요 : ");
		int row = sc.nextInt();
		
		// 별을 하나씩 찍으려면 for문 하나로는 부족 -> 중첩 for문 필요
		// 큰 for문은 줄 출력, 작은 for문에서 별 출
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
	
	public void method9() {
		// 한 줄에 별표 문자를 입력된 줄 수와 칸 수만큼 출력
		// 단, 줄 수와 칸 수가 일치하는 위치에는 줄 번호에 대한 정수 출력
		/* 
	 		줄 수 : 6 		줄 수 : 5		줄 수 : 4
	 		칸 수 : 6		칸 수 : 4		칸 수 : 5
	 		1*****		1***		1****
	 		*2****		*2**		*2***
	 		**3***		**3*		**3**
	 	    ***4**		***4		***4*
	 	    ****5*		****
	 	    *****6     
	 	    */
		Scanner sc = new Scanner(System.in);
		System.out.print("출력할 줄 수를 입력하세요 : ");
		int row = sc.nextInt();
		System.out.print("출력할 칸 수를 입력하세요 : ");
		int col = sc.nextInt();
		
		for(int i = 1; i <= row; i++) {
			for(int j = 1; j <= col; j++) {
				if(i == j) {
					System.out.print(j);
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
		}


		
	}
}
