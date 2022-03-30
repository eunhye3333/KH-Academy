package com.kh.variable;

import java.util.Scanner;

public class E_KeyboardInput {
	public void inputScanner1() {
		Scanner sc = new Scanner(System.in);
//		sc.nextLine(); // nextLine() : 사용자에게 문자열을 받아주는 메소드
		// 실행하면 아무 일도 일어나지 않지만 console에 빨간색 불이 들어와있음. 실행이 완려되면 까만색이어야 됨.
		// 빨간색 불이 들어와 있다는 것은 계속 실행중이라는 것. 할 일이 남았다. -> 사용자에게 데이터를 받지 않았다
		// 데이터를 입력하고 엔터를 누르면 종료됨. sc.nextLine()은 입력한 데이터 자체가 됨.
		// 만약 데이터를 받고 끝내면 다른 곳에 저장되는 것이 아니기 때문에 데이터가 사라짐. 만약 데이터가 사라지지 않게 하려면 변수에 저장해야 함.
		System.out.print("이름을 입력하세요 : "); // 이름을 입력하게 하기 위해 안내문 작성 필요. 보기 편하게 하기 위해서 줄바꿈하지 않음.
//		String name = sc.nextLine();
		String name = sc.next(); // next() : 사용지에게 문자열을 받아오는 메소드 
		// next, nextLine 차이점을 아직 알 수 없음
		
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt(); // nextInt() : 사용자에게 정수를 받아오는 메소드
		
		System.out.print("키를 입력하세요(소수점 첫째자리까지 입력) : ");
		double height = sc.nextDouble(); // nextDouble() : 사용자에게 실수를 받아오는 메소드
		
		
		System.out.println(name + "님은 " + age + "세이며, 키는 " + height + "cm입니다.");
	}
	
	public void inputScanner2() {
		// next()와 nextLine() 비교
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine(); // 박신우\n 가져감
		
//		System.out.print("나이를 입력하세요 : ");
//		int age = sc.nextInt(); // 20 가져감
		
//		System.out.print("주소를 입력하세요 : ");
//		String address = sc.nextLine(); // 주소 입력이 제대로 되지 않는 문제가 생김 (\n 가져감)
		
		// 해결 방법 1. 엔터를 인지하지 못하게 만들어줌 : next()
//		//		System.out.print("주소를 입력하세요 : ");
//		String address = sc.next(); // 띄어쓰기가 인지가 안 됨. next는 띄어쓰기를 구분자로 인식하기 때문에 띄어쓰기가 있을 경우 그중 일부만 읽어오게 됨
		// 띄어쓰기 뒷부분을 출력하고 싶으면 sc.next()를 띄어쓰기 수만큼 출력해줘야함
		
		// 해결 방법 2. 줄바꿈을 없애기 위한 nextLine 추가
		// nextLine이 줄바꿈을 인식하니까 하나를 써서 없애면 다시 버퍼를 깨끗하게 만들 수 있음
//		System.out.print("주소를 입력하세요 : ");
//		sc.nextLine();
//		String address = sc.nextLine();
		
		// 해결 방법 3. 파싱(parsing)하기 : 문자열을 다른 자료형으로 바꾸는 것. 나이에 대해서 파싱
		System.out.print("나이를 입력하세요 : ");
		String strAge = sc.nextLine(); // 나이를 숫자가 아니라 스트링으로 받아오기. 원래는  int로 받아야 되는데 String으로 받음. but 버퍼에 줄바꿈이 안 생김.
		// 문자열 나이를 int로 바꿔 줘야 함 -> 파싱
		int age = Integer.parseInt(strAge); // strAge를 int로 바꾸겠다	
		
		
		System.out.print("주소를 입력하세요 : ");
		String address = sc.nextLine(); // 줄바꿈이 없으므로 그냥 바로 nextLine을 이용해 주소를 입력받을 수 있음
		
		// + char 받기
		System.out.print("성별을 입력하세요(M/F) : ");
		String strGender = sc.nextLine();
		char gender = strGender.charAt(0); // charAt(int index) : char -> String 클래스 안에 있는 메소드
		
		System.out.println(name + "님(" + gender + ")은 " + age + "세이며, 사는 곳은 " + address + "입니다.");
		
	}
}
