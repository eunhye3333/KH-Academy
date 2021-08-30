package com.kh.example.chap03_user.model.exception;

public class MyException extends Exception {
	// 상속을 해야 예외 클래스가 됨
	public MyException() {}
	public MyException(String msg) {
		super(msg);
	}
}
