package com.kh.example.test.model.vo;

public class Child1 {
	private String str;
	
	public Child1() {
//		super. -> Object�� ����
		// Parent�� �����ϱ� ���ؼ��� ��ü�� ����� ��� ��
		Parent p = new Parent();
//		p.num = 10; // private ���� �Ұ���
		p.dNum = 0.0; // default ���� ����
		p.bool = false; // protected ���� ���� -> ���� ��Ű����. ����� �ƴ϶� default�� ������ ���� 
		p.ch = 'A'; // public ���� ����
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
}
