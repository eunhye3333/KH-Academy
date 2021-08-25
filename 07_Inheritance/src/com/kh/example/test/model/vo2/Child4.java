package com.kh.example.test.model.vo2;

import com.kh.example.test.model.vo.Parent;

public class Child4 extends Parent {
	public Child4() {
//		super.num = 10;
//		super.dNum = 0.0; // 패키지가 달라서 default 접근 불가
		super.bool = false; // protected 접근 가능. 다른 패키지이지만 상속이 되어 있기 때문에
		super.ch ='A';
	}

}
