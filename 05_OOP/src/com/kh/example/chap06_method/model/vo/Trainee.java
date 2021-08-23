package com.kh.example.chap06_method.model.vo;

public class Trainee {
	private String name;
	private final String ACADEMY = "KH";
	private char classRoom;
	private String time;
	private static double score;
	
	public Trainee() {
		
	}
	
	public Trainee (String name, char classRoom, String time, double score) {
		this.name = name;
		// ACADEMY�� ���� ���� ���� : ACADEMY�� final����(=���)�̱� ������ �� ����x
		//                        �����ڿ��� ���ο� ������ �ʱ�ȭ�� �Ұ����ϱ� ������ ���ܵ�
		this.classRoom = classRoom;
		this.time = time;
//		this.score = score; // The static field Trainee.score should be accessed in a static way
		// this.score�� ��� �޼����� �ߴ� ���� : this�� �ڽ��� �ּ� ���� ������ �ִ� ���۷��� ����(=���� ����)
		//   							   �ּ� ���� ���´ٴ� ���� heap �޸� ������ ������ �����, �� ��ü�� ����ٴ� ��
		//   							   �ٽ� ����, this�� �����ϴ� ���� ��ü�� ����� �����϶�� �Ͱ� ����
		//								  static ����/�޼ҵ�� ��ü�� ����� �����ϴ� �� �ƴ϶� Ŭ������.���� �����ؾ� �ϱ� ������ ��� �������� ���	
		Trainee.score = score;
	}
	
	public Trainee(char classRoom) {
		this.classRoom = classRoom;
	}
	
	public String inform() {
		return ACADEMY + " " + name + " �Ʒû��� " + classRoom + time + "���̰�, ������ " + score + "���Դϴ�.";
	}
	
	// ���ݱ����� �ʵ忡 �ִ� ���� �ʱ�ȭ�ϰ� ������ �Ű����� �ִ� �����ڸ� �̿��Ͽ���
	// �Ű����� �ִ� �����ڸ� �̿��Ͽ� ���� �� �ִ� ä�� ��ü�� ������µ�
	// ������ ���� �߸����� ���, ��� �����͸� ������ ���ΰ�? (�Ϻκи� �����ϰ� ���� ���)
	// -> �ʵ带 �ϳ����� ������ �ִ� ��ü�� ����� ���� ������? -> �� ��. ���� ��ü�� �ƴ϶� ���ο� ��ü�� ������ �������� ����
	// �Ϻ� �ʵ常 �����͸� ��ȸ�ϰ� ������ ��� �� ���ΰ�?
	// setter getter
	
	// name�� ���� setter, getter
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// ACADEMY�� ���� getter (����� setter�� ��� �Ұ���)
	public String getACADEMY() {
		return ACADEMY;
	}
	
	// classRoom�� ���� setter getter
	public void setClassRoom(char classRoom) {
		this.classRoom = classRoom;
	}
	
	public char getClassRoom() {
		return classRoom;
	}
	
	// time�� ���� setter, getter
	public void setTime(String time) { // settime���� ���� setter�� �ν����� ����
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	// score�� ���� setter, getter
	// score�� static�̱� ������ �̿��̸� static �޼ҵ�� �������ִ� ���� ����
	public static void setScore(double score) {
		Trainee.score = score;
	}
	
	public static double getScore() {
		return score;
	}

}
