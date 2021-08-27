package com.kh.example.family.model.vo;

public class Mother extends Family implements Basic {
	// The type Mother must implement the inherited abstract method Family.sleep()
	// 부모 클래스에 추상 메소드를 만드는 경우 생기는 에러
	// 상속받은 추상 메소드를 반드시 구현하라는 뜻
	private String babyBirth;
	
	public Mother() {}
	public Mother(String name, double weight, int health, String babyBirth) {
		super(name, weight, health);
		this.babyBirth = babyBirth;
	}
	
	public String getBabyBirth() {
		return babyBirth;
	}
	
	public void setBabyBirth(String babyBirth) {
		this.babyBirth = babyBirth;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + babyBirth;
	}
	@Override
	public void eat() {
		super.setWeight(super.getWeight() + 10);
		super.setHealth(super.getHealth() - 5);
	}

	@Override
	public void sleep() {
		super.setHealth(super.getHealth() + 10);
	}
	
//	public void eat() {
//		super.setWeight(super.getWeight() + 10);
//		super.setHealth(super.getHealth() - 5);
//	}
//	
//	public void sleep() {
//		super.setHealth(super.getHealth() + 10);
//	}
}
