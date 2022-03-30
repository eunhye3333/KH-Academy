package com.kh.example.family.model.vo;

// 추상 클래스
public abstract class Family {
	// The type Family must be an abstract class to define abstract methods
	// abstract 메소드를 정의하기 위해서는 abstract 클래스여야 함
	private String name;
	private double weight;
	private int health;
	
	public Family() {}
	
	public Family(String name, double weight, int health) {
		this.name = name;
		this.weight = weight;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	@Override
	public String toString() {
		return name + ", " + weight + "kg, " + health;
	}
	
	// 추상 메소드
	// This method requires a body instead of a semicolon
	// 이 메소드는 세미콜론 대신 몸체가 필요하다 -> abstract가 빠짐
	// The abstract method eat in type Family can only be defined by an abstract class
	// 이 추상 메소드는 추상 클래스 안에서만 정의될 수 있다
//	public abstract void eat();
//	public abstract void sleep();
}


