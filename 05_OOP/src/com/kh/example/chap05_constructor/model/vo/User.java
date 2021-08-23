package com.kh.example.chap05_constructor.model.vo;

import java.util.Date;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private Date enrollDate;
	
	// �������� ��� ����
	//		��ü�� �����ϸ鼭 �ʵ� �ʱ�ȭ�ϱ� ���� ���
	
	// ������ Ư¡
	// 		1. �����ڸ��� Ŭ������� ����(��ҹ��ڱ���)
	//	 	2. ��ȯ Ÿ���� �������� ����
	
	// �⺻ ������
	// 		�ƹ� �Ű������� ���� ������
	// 		�� ���� �ʾƵ� JVM�� �⺻������ ��������
	// 		�⺻ �����ڰ� ���� ���¿��� �Ű����� �ִ� �����ڸ� ������ָ� �⺻ �����ڴ� �ڵ����� �������� ����
	// �����Ǿ����� �⺻ ������
	
//	{
//		System.out.println(this); // ��� �����ڿ� ���� �� �����̶�� �ʱ�ȭ�� ����ϴ� ���� �� ����
//	}
	
	public User() {
		// �⺻ �����ڸ� ����� ctrl + Ŭ���ϸ� �� �⺻ ������������ ��
		// �����Ǿ� �ִ� ��� �����Ǿ� �־� ã�� �� ���� ������ Ŭ������ ����Ű�� ����
	}
	
	// �Ű����� �ִ� ������
	// 		�Ű������� �ִ� ������
	// 		�Ѱܹ��� �Ű������� �̿��Ͽ� �ʵ带 �ʱ�ȭ�� ��� ���
	
	public void inform() {
		System.out.println(userId + ", " + userPwd + ", " + userName + ", " + enrollDate);
	}
	
//	private Date editDate;
	
//	public User(String id, String pwd, String name, Date enrollDate, Date editDate) {
//		userId = id;
//		userPwd = pwd;
//		userName = name;
//		enrollDate = enrollDate; // The assignment to variable enrollDate has no effect
//		editDate = editDate;     // ��������(�Ű�����)�� ���������� ������
//		this.enrollDate = enrollDate; 
//		this.editDate = editDate;
//		// �� ���� ������ �ν����� ���ϴ°� -> �ش� �����ڴ� ���������� ������
//		// ���������� �ڱ� ���� �ȿ� ������ �ڱⰡ �켱������ ��. ������������ �켱
//		
//	}

//	public User(String id, String pwd, String name, Date date) { // ������ 8���� ���� ��. �̸��� �ʵ�� �Ȱ��� ���� 4���� ���� �������� �� ������
//																 // � ������ ��� ������ �� �� ����
//		userId = id;
//		userPwd = pwd;
//		userName = name;
//		enrollDate = date;
//	}
	
	public User(String userId, String userPwd, String userName, Date enrollDate) { // ���� ���� ���̰� ������ ���̱�
//		this.userId = userId;
//		this.userPwd = userPwd;
//		this.userName = userName;
		this(userId, userPwd, userName);
		this.enrollDate = enrollDate;
		
//		this.userId = userId; // �ߺ���
//		this.userPwd = userPwd;
//		this.userName = userName;
	}
	
	public User(String userId, String userPwd, String userName) {
//		this.userId = userId;
//		this.userPwd = userPwd;
		this(userId, userPwd); // �ߺ� ������ ���� this ������. �Ű������� String �� ���� �����ڸ� ȣ���ϴ� ��
		this.userName = userName;
		
//		this.userId = userId;  // �ߺ���
//		this.userPwd = userPwd;
	}
	
	public User(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}

//	public User(String id, String name) { // �Ű������� Ÿ��, ����, ������ �� ���Ƽ� �����ε� �� ��
//	                                      // ���� �ִ� �Ŷ� ���� �Ŷ� ������ ���� ��. �̸��� �ٸ� �� �ҿ����
//		userId = id;
//		userName = name;
//	}
}
