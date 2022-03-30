package com.kh.example.animal.model.vo;

public class Snake extends Animal {
	private String pattern;
	
	public Snake() {}
	
	public Snake(String name, int age, double weight, String pattern) {
		super(name, age, weight);
		this.pattern = pattern;
	}
	
//	public String inform() {
//		return super.inform() + " " + pattern; // 하나하나 getter를 이용해 가져올 필요가 없다
//		// 이미 부모 클래스에 inform 메소드가 존재하기 때문에
//	}
	
//	@Override
//	public String inform() {
//		return super.inform() + " " + pattern;
//	}
	
	@Override
	public String toString() {
		return super.toString() + " " + pattern; // 해당 toString은 Animal 클래스에 있는 toString을 가리킴
	}
	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
}
