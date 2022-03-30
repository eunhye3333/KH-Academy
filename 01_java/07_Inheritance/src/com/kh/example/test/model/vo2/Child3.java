package com.kh.example.test.model.vo2;

import com.kh.example.test.model.vo.Parent;

public class Child3 {
	public Child3() {
		Parent p = new Parent();
//		p.num = 10;
//		p.dNum = 0.0; // 패키지가 달라서 default 접근 불가
//		p.bool = false; // 패키지가 다르고 상속 관계도 아니므로 protected 접근 불가
		p.ch = 'A';
	}
}
