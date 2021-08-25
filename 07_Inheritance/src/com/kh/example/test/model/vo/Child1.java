package com.kh.example.test.model.vo;

public class Child1 {
	private String str;
	
	public Child1() {
//		super. -> Object에 접근
		// Parent에 접근하기 위해서는 객체를 만들어 줘야 함
		Parent p = new Parent();
//		p.num = 10; // private 접근 불가능
		p.dNum = 0.0; // default 접근 가능
		p.bool = false; // protected 접근 가능 -> 같은 패키지라서. 상속이 아니라서 default와 동일한 범위 
		p.ch = 'A'; // public 접근 가능
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}
