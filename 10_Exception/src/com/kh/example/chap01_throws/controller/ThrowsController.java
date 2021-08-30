package com.kh.example.chap01_throws.controller;

public class ThrowsController {
	public void method1() throws Exception {
		System.out.println("method1() ȣ���...");
		method2();
		System.out.println("method1() �����...");
		// ������ ������ ���� ���·� ���� ó���� ���� ȣ���� �޼ҵ�� �Ѿ�� ������ �ش� ������ ������� ����
	}
	
	public void method2() throws Exception {
		System.out.println("method2() ȣ���...");
		method3();
		// ��ĥ �� �ִ� ��� : throws, try~catch
		System.out.println("method2() �����...");
		// ������ ������ ���� ���·� ���� ó���� ���� ȣ���� �޼ҵ�� �Ѿ�� ������ �ش� ������ ������� ����
		// �����ϱ� ���ؼ��� �ش� �κп� try~catch�� �־� ��� ��
		// ���� Unreachable code�� �ƴϱ� ������ Unreachable code ������ �߻����� ���� (try~catch�� ����ϸ� ���� ����)
		// ��� ����� ���� ��Ŭ������ ��������� �ʱ� ������ ���� �߻� x
	}
	
	public void method3() throws Exception {
		System.out.println("method3() ȣ���...");
		// ���� Exception �߻� : try~catch x -> �Ǳ� �ǰ� ������ ���� ���� �ƴ����� �ǹ̰� ����
		throw new Exception();
		// Unhandled exception type Exception
		// Exception Ÿ���� ó������ ���� ���ܰ� �����Ѵ�
		// ���ܸ� ó���ؾ� ��
		// ��ĥ �� �ִ� ��� : throws
//		System.out.println("method3() �����...");
		// Unreachable code
		// ������ �� ���� �ڵ�
		// ���ܰ� �߻��ϸ� ó���� ���ֵ� �����ֵ� ���ܸ� ó���Ϸ� ����, ������ ���ᰡ �Ǳ� ������ �Ʒ��� �ִ� �ڵ�� ���� �� ��
		
		
	}
}
