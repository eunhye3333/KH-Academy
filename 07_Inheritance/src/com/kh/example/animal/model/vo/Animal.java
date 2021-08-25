package com.kh.example.animal.model.vo;

public class Animal {
	private String name;
	private int age;
	private double weight;
	
	public Animal() {}
	
	public Animal(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
//	public String inform() {
//		return name + " " + age + " " + weight;
//	}
	
	// 오버라이딩이 많이 사용되는 경우
	@Override
	public String toString() { // Object 클래스에 있는 toString을 상속받아 오는 것
		return name + " " + age + " " + weight;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}
