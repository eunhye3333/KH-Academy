package com.kh.example.chap05_constructor.run;

import java.util.Date;

import com.kh.example.chap05_constructor.model.vo.User;

public class Run {
	public static void main(String[] args) {
		User u1 = new User();
//		System.out.println("u1 : " + u1); // this와 해당 객체 주소가 같음
//		User   u1    =      new   User();
//		클래스명 변수명 대입연산자 new연산자   ??
		// User이라는 메소드를 만들어 주지 않았음 
		// 메소드 이름은 대문자로 시작하지 않음, 클래스명과 똑같음
		// => User()은 생성자다.
		// 그런데 소괄호에 아무 매개변수도 없음 -> 기본 생성자
		
		u1.inform();
		
//		int[] arr = new int[3]; // 0 0 0이 들어가 있는 상태
//		arr[0] = 1;
//		arr[1] = 2;
//		arr[2] = 3;
//		// 1 2 3이 들어가짐
//		
//		int[] arr = {1, 2, 3}; // 바로 1, 2, 3이 들어감 (생성자 느낌)
		
		User u2 = new User("user01", "pass011", "강건강", new Date()); // 매개변수 생성자
//		System.out.println("u2 : " + u2);
		u2.inform(); // user01, pass011, 강건강, Thu Aug 19 14:46:22 KST 2021
		
		User u3 = new User("user02", "pass02", "남나눔");
//		System.out.println("u3 : " + u3);
		u3.inform();
		
		User u4 = new User("user03", "pass03");
//		System.out.println("u4 : " + u4);
		u4.inform();
		
	}
}
