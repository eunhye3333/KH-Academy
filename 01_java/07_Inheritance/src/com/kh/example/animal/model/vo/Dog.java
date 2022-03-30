package com.kh.example.animal.model.vo;

public class Dog extends Animal {
	private double height;
	private String hair;
	
	public Dog() {}
	
	public Dog(String name, int age, double weight, double height, String hair) {
//		super.setName(name);
//		super.setAge(age);
//		super.setWeight(weight);
		// name, age, weight ���� �ʱ�ȭ ���־�� �ϱ� ������ setter�� �̿��� ���� �־��� 
		super(name, age, weight); // super �����ڸ� �̿��� �� �ٿ� �ʱ�ȭ
		this.height = height;
		this.hair = hair;
	}
	
	// �̰͵� ����� �������̵��� �� ������. but �Ϻ��ϰ� �������̵��� X
//	public String inform() { // �޼ҵ��� �̸�, �Ű����� ����, Ÿ��, ���� Ÿ���� ������
//	public String inform(String name) { // �������̵� ���� �� ��
		// �̰͸� ������ �������̵��� �ƴ��� �� �� �ִ� ����� ����
		// Annotation, @Override�� ���̸� �������̵��� �Ǿ����� �� �� ���� -> �������̵� ���ǿ� ���� �ʴ� ��� �˷� ��
		// -> ��� ������ �ִ� ���� ���� ����
		
//		// name�� ����ϸ� ������ �� ��� ������ ��
//		// super.name -> �θ� Ŭ������ �ʵ忡 �����ϴ� ��������� name�� ���������ڰ� private�̶� ������ �� ����
//		return super.getName() + " " + super.getAge() + " " + super.getWeight() + " " + height + " " + hair;
//	}
	
//	@Override // Annotation
//	public String inform() { // Animal���� ���� inform �޼ҵ�� ����� �Ȱ���
//		return super.inform() + " " + height + " " + hair; // super. -> �θ� ��ü�� ����Ű�� ���۷��� ����
//		//      -> name + " " + age + " " + weight 
//	}
	
	@Override
	public String toString() {
		return super.toString() + " " + height + " " + hair; // �ش� toString�� Animal Ŭ������ �ִ� toString�� ����Ŵ
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}
}
