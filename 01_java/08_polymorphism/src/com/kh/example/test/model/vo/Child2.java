package com.kh.example.test.model.vo;

public class Child2 extends Parent {
	private int n;
	
	public Child2() {}
	
	public Child2(int x, int y, int n) {
		super(x, y);
		this.n = n;
	}
	
	public void printChild2() {
		System.out.println("�� �� ��° �ڽ���");
	}
	
	public int getN() {
		return n;
	}
	
	public void setZ(int n) {
		this.n = n;
	}
	
	@Override
	public void print() {
		System.out.println("�� �� ��° �ڽ��̶�ϱ�?");
	}
}
