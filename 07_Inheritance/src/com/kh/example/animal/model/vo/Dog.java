package com.kh.example.animal.model.vo;

public class Dog extends Animal {
	private double height;
	private String hair;
	
	public Dog() {}
	
	public Dog(String name, int age, double weight, double height, String hair) {
//		super.setName(name);
//		super.setAge(age);
//		super.setWeight(weight);
		// name, age, weight 값도 초기화 해주어야 하기 때문에 setter를 이용해 값을 넣어줌 
		super(name, age, weight); // super 생성자를 이용해 한 줄에 초기화
		this.height = height;
		this.hair = hair;
	}
	
	// 이것도 사실은 오버라이딩이 된 상태임. but 완벽하게 오버라이딩은 X
//	public String inform() { // 메소드의 이름, 매개변수 개수, 타입, 리턴 타입이 동일함
//	public String inform(String name) { // 오버라이딩 성립 안 됨
		// 이것만 보고서는 오버라이딩이 됐는지 알 수 있는 방법이 없음
		// Annotation, @Override를 붙이면 오버라이딩이 되었는지 알 수 있음 -> 오버라이딩 조건에 맞지 않는 경우 알려 줌
		// -> 없어도 되지만 있는 것이 좋은 이유
		
//		// name을 사용하면 접근할 수 없어서 오류가 뜸
//		// super.name -> 부모 클래스의 필드에 접근하는 방법이지만 name의 접근제한자가 private이라서 접근할 수 없음
//		return super.getName() + " " + super.getAge() + " " + super.getWeight() + " " + height + " " + hair;
//	}
	
//	@Override // Annotation
//	public String inform() { // Animal에서 만든 inform 메소드와 상단은 똑같음
//		return super.inform() + " " + height + " " + hair; // super. -> 부모 객체를 가리키는 레퍼런스 변수
//		//      -> name + " " + age + " " + weight 
//	}
	
	@Override
	public String toString() {
		return super.toString() + " " + height + " " + hair; // 해당 toString은 Animal 클래스에 있는 toString을 가리킴
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
