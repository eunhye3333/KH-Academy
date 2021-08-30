package com.kh.example.chap02_tryCatch.controller;

import java.io.IOException;

public class TryCatchController {
	public void method1() {
		System.out.println("method1() 호출됨...");
		try {
			method2();
			System.out.println("출력될까, 안될까?"); // 예외 처리가 안 된 상태이기 때문에 여기까지 닿지 않음
			// 예외 발생 시에는 출력되지 않음
		} catch (IOException e) {
			// Unreachable catch block for IOException. It is already handled by the catch block for Exception
			// IOException에 대한 catch는 도달할 수 없는 catch절이다. 이미 Exception catch절에 의해 처리되었다
			// IOException을 아래에 두면 해당 오류 발생 -> 부모 클래스인 Exception에서 이미 다 처리를 해서
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception으로 잡음");
		} finally {
			System.out.println("finally 출력");
			// 예외 발생 여부와 상관 없이 무조건 수행
		}
		
		System.out.println("method1() 종료됨...");
	}
	
	public void method2() throws IOException {
		System.out.println("method2() 호출됨...");
//		throw new NullPointerException(); // 여기에는 빨간줄이 안 뜸
		// NullPointerException은 RuntimeException의 후손이기 때문에 Unchecked Exception으로 분류가 돼서 예외처리가 필요하지 않음
		throw new IOException();
//		System.out.println("method2() 종료됨..."); // 빨간 줄이 뜸
		// 에러가 떠서 도달할 수 없는 상황
		
	}
}
