package com.kh.example.animal.model.vo;

public class Snake extends Animal {
	private String pattern;
	
	public Snake() {}
	
	public Snake(String name, int age, double weight, String pattern) {
		super(name, age, weight);
		this.pattern = pattern;
	}
	
//	public String inform() {
//		return super.inform() + " " + pattern; // �ϳ��ϳ� getter�� �̿��� ������ �ʿ䰡 ����
//		// �̹� �θ� Ŭ������ inform �޼ҵ尡 �����ϱ� ������
//	}
	
//	@Override
//	public String inform() {
//		return super.inform() + " " + pattern;
//	}
	
	@Override
	public String toString() {
		return super.toString() + " " + pattern; // �ش� toString�� Animal Ŭ������ �ִ� toString�� ����Ŵ
	}
	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
