package com.kh.example.chap02_tryCatch.controller;

import java.io.IOException;

public class TryCatchController {
	public void method1() {
		System.out.println("method1() ȣ���...");
		try {
			method2();
			System.out.println("��µɱ�, �ȵɱ�?"); // ���� ó���� �� �� �����̱� ������ ������� ���� ����
			// ���� �߻� �ÿ��� ��µ��� ����
		} catch (IOException e) {
			// Unreachable catch block for IOException. It is already handled by the catch block for Exception
			// IOException�� ���� catch�� ������ �� ���� catch���̴�. �̹� Exception catch���� ���� ó���Ǿ���
			// IOException�� �Ʒ��� �θ� �ش� ���� �߻� -> �θ� Ŭ������ Exception���� �̹� �� ó���� �ؼ�
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception���� ����");
		} finally {
			System.out.println("finally ���");
			// ���� �߻� ���ο� ��� ���� ������ ����
		}
		
		System.out.println("method1() �����...");
	}
	
	public void method2() throws IOException {
		System.out.println("method2() ȣ���...");
//		throw new NullPointerException(); // ���⿡�� �������� �� ��
		// NullPointerException�� RuntimeException�� �ļ��̱� ������ Unchecked Exception���� �з��� �ż� ����ó���� �ʿ����� ����
		throw new IOException();
//		System.out.println("method2() �����..."); // ���� ���� ��
		// ������ ���� ������ �� ���� ��Ȳ
		
	}
}
