package com.kh.example.chap01_throws.controller;

public class ThrowsController {
	public void method1() throws Exception {
		System.out.println("method1() 호출됨...");
		method2();
		System.out.println("method1() 종료됨...");
		// 실행할 여유가 없는 상태로 예외 처리를 위해 호출한 메소드로 넘어가기 때문에 해당 문장은 실행되지 않음
	}
	
	public void method2() throws Exception {
		System.out.println("method2() 호출됨...");
		method3();
		// 고칠 수 있는 방법 : throws, try~catch
		System.out.println("method2() 종료됨...");
		// 실행할 여유가 없는 상태로 예외 처리를 위해 호출한 메소드로 넘어가기 때문에 해당 문장은 실행되지 않음
		// 실행하기 위해서는 해당 부분에 try~catch를 넣어 줘야 됨
		// 당장 Unreachable code는 아니기 때문에 Unreachable code 에러가 발생하지 않음 (try~catch를 사용하면 도달 가능)
		// 모든 경우의 수를 이클립스가 잡아주지는 않기 때문에 에러 발생 x
	}
	
	public void method3() throws Exception {
		System.out.println("method3() 호출됨...");
		// 강제 Exception 발생 : try~catch x -> 되긴 되고 에러가 나는 것은 아니지만 의미가 없음
		throw new Exception();
		// Unhandled exception type Exception
		// Exception 타입의 처리되지 않은 예외가 존재한다
		// 예외를 처리해야 됨
		// 고칠 수 있는 방법 : throws
//		System.out.println("method3() 종료됨...");
		// Unreachable code
		// 도달할 수 없는 코드
		// 예외가 발생하면 처리를 해주든 못해주든 예외를 처리하러 가고, 비정상 종료가 되기 때문에 아래에 있는 코드는 실행 안 됨
		
		
	}
}
