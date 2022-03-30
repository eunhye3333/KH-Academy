package com.kh.example.chap03_user.controller;

import java.util.Scanner;

import com.kh.example.chap03_user.model.exception.MyException;

public class UserExceptionController {
	public void inputAge() {
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		
		try {
			checkAge(age);
		} catch (MyException e) {
//			e.printStackTrace();
			System.out.println(e.getMessage()); // 입장 불가
		}
		// 에러 발생 시 com.kh.example.chap03_user.model.exception.MyException: 입장 불가
		// 내가 넘긴 메시지가 뜸
	}
	
	public void checkAge(int age) throws MyException {
		if(age < 19) {
			throw new MyException("입장 불가");
			// 굳이 예외 처리를 하지 않아도 if문을 사용하여 처리 가능
		} else {
			System.out.println("즐거운 관람 되시길 바랍니다.");
		}
	}
}
