package com.kh.example.family.model.vo;

import java.io.Serializable;

// �������̽����� ��� ���� : extends -> ���� ��� ����
public interface Basic extends Cloneable, Serializable{
	//                          Marker Interface
	//                          : ���ο� ����� �޼ҵ�� ���� �̸��� �ִ� �������̽�
	//                          : �޼ҵ� ����(�ϼ�)�� ������ �ƴ϶� Ŭ������ Ư���� ��Ÿ���� ����
	public static final double PI = 3.14;
	String NATION = "���ѹα�";
	// interface �ȿ� �ִ� �ʵ�� ���������� public static final
	
	public abstract void eat();
	void sleep();
	// interface �ȿ� �ִ� �޼ҵ�� ���������� public abstract
}
