package com.kh.example.test.model.vo;

// 클래스 Child2는 상속받는다 Parent 클래스를
// 같은 패키지 안에 있어서 import 안 해도 됨
// 부모 클래스도 패키지가 다르면 import 해줘야 함
public class Child2 extends Parent { 
	private String str;
	
	public Child2() {
//		super.num = 10;
		super.dNum = 0.0;
		super.bool = false;
		super.ch = 'A';
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}
