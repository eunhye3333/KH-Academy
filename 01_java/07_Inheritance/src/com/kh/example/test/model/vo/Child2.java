package com.kh.example.test.model.vo;

// Ŭ���� Child2�� ��ӹ޴´� Parent Ŭ������
// ���� ��Ű�� �ȿ� �־ import �� �ص� ��
// �θ� Ŭ������ ��Ű���� �ٸ��� import ����� ��
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
