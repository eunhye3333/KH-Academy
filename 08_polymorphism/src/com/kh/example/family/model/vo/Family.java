package com.kh.example.family.model.vo;

// �߻� Ŭ����
public abstract class Family {
	// The type Family must be an abstract class to define abstract methods
	// abstract �޼ҵ带 �����ϱ� ���ؼ��� abstract Ŭ�������� ��
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
	
	// �߻� �޼ҵ�
	// This method requires a body instead of a semicolon
	// �� �޼ҵ�� �����ݷ� ��� ��ü�� �ʿ��ϴ� -> abstract�� ����
	// The abstract method eat in type Family can only be defined by an abstract class
	// �� �߻� �޼ҵ�� �߻� Ŭ���� �ȿ����� ���ǵ� �� �ִ�
//	public abstract void eat();
//	public abstract void sleep();
}


