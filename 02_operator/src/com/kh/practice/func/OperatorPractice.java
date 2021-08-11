package com.kh.practice.func;

import java.util.Scanner;

public class OperatorPractice {
	public void practice1() {
		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다", 양수가 아니면 "양수가 아니다"를 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		String result = num > 0 ? "양수다" : "양수가 아니다";
		
		System.out.println(result);
	}
	
	public void practice2() {
		// 키보드로 입력 받은 하나의 정수가 양수이면 "양수다",
		// 양수가 아닌 경우 중에서 0이면 "0이다", 0이 아니면 "음수다"를 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		String result = num > 0 ? "양수다" : (num == 0 ? "0이다" : "음수다");
		
		System.out.println(result);
	}
	
	public void practice3() {
		// 키보드로 입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "홀수다"를 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		
		String result = (num % 2) == 0 ? "짝수다" : "홀수다";
		
		System.out.println(result);
	}
	
	public void practice4() {
		// 인원수와 사탕 수를 입력 받고 1인당 동일하게 나눠가진 사탕 개수와 남은 사탕 수를 출력하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("인원 수 : ");
		int people = sc.nextInt();
		
		System.out.print("사탕 개수 : ");
		int candy = sc.nextInt();
		
		System.out.println("1인당 사탕 개수 : " + candy / people);
		System.out.println("남는 사탕 개수 : " + candy % people);
	}
	
	public void practice5() {
		// 키보드로 입력받은 값들을 변수에 기록하고 저장된 변수 값을 화면에 출력하세요
		// 이때 성별이 'M'아면 남학생, 'M'이 아니면 여학생으로 출력하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("학년(숫자만) : ");
		int grade = sc.nextInt();
		
		System.out.print("반(숫자만) : ");
		int class1 = sc.nextInt();

		System.out.print("번호(숫자만) : ");
		int num = sc.nextInt();
		
		System.out.print("성별(M/F) : ");
		char gender = sc.next().charAt(0);
		
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();
		
		String strGender = gender == 'M' ? "남학생" : "여학생";
		
		System.out.println(grade + "학년 " + class1 + "반 " + num + "번 " + name + " " + strGender + "의 성적은 " + score + "이다.");
	}
	
	public void practice6() {
		// 나이를 키보드로 입력받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 성인(19세 초과)인지 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		String str = age <= 13 ? "어린이" : (age > 19 ? "성인" : "청소년");
		
		System.out.println(str);
	}
	
	public void practice7() {
		// 국어, 영어, 수학에 대한 점수를 키보드를 이용해 정수로 입력받고,
		// 세 과목에 대한 합계를 구하세요
		// 세 과목 점수가 각각 40점 이상이면서 평균이 60점 이상일 때 합격, 아니라면 불합격을 출력하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 : ");
		int korean = sc.nextInt();
		
		System.out.print("영어 : ");
		int english = sc.nextInt();
		
		System.out.print("수학 : ");
		int math = sc.nextInt();
		
		int sum = korean + english + math;
		double avg = sum / 3.0;
		boolean bResult = math >= 40 && korean >= 40 && english >= 40 && avg >= 60;
		String result = bResult ? "합격" : "불합격";
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println(result);
	}
	
	public void practice8() {
		// 주민번호를 이용하여 남자인지 여자인지 구분하여 출력하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요(- 포함) : ");

		char pId = sc.nextLine().charAt(7);
		
		String gender = (pId == '2') || (pId == '4') ? "여자" : ((pId == '1') || (pId == '3') ? "남자" : "잘못 입력하셨습니다");
		
		System.out.println(gender);
	}
	
	public void practice9() {
		// 키보드로 정수 두 개를 입력받아 변수에 저장한 후 또 다른 정수를 입력받아 그 수가 첫 번째 정수 이하거나 두 번째 정수 초과이면 true를 출력하고 아니면 false를 출력하세요
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 : ");
		int num1 = sc.nextInt();
		
		System.out.print("정수 2 : ");
		int num2 = sc.nextInt();
		
		System.out.print("입력 : ");
		int num3 = sc.nextInt();
		
		System.out.println(num3 <= num1 || num3 > num2);
	}
	
	public void practice10() {
		// 3개의 수를 키보드로 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력1 : ");
		int a = sc.nextInt();
		
		System.out.print("입력2 : ");
		int b = sc.nextInt();

		System.out.print("입력3 : ");
		int c = sc.nextInt();
		
		System.out.println(a == b && a == c && b == c);
	}
	
	public void practice11() {
		// A, B, C 사원의 연봉을 입력받고, 각 사원의 연봉과 인센티브를 포함한 연봉을 계산하여 출력하고 인센티브 포함 급여가 3000만원 이상이면 3000 이상, 미만이면 3000 미만을 출력하세요
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("A 사원의 연봉 : ");
		int a = sc.nextInt();
		
		System.out.print("B 사원의 연봉 : ");
		int b = sc.nextInt();
		
		System.out.print("C 사원의 연봉 : ");
		int c = sc.nextInt();
		
		double sumA = a + a * 0.4;
		double sumB = b + b * 0;
		double sumC = c + c * 0.15;
		
		System.out.println("A사원 연봉/연봉 +a : " + a + "/" + sumA + "\n" + (sumA >= 3000 ? "3000 이상" : "3000 미만"));
		System.out.println("B사원 연봉/연봉 +a : " + b + "/" +  sumB + "\n" + (sumB >= 3000 ? "3000 이상" : "3000 미만"));
		System.out.println("C사원 연봉/연봉 +a : " + c + "/" +  sumC + "\n" + (sumC >= 3000 ? "3000 이상" : "3000 미만"));

	}
}
