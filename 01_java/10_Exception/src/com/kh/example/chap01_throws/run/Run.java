package com.kh.example.chap01_throws.run;

import com.kh.example.chap01_throws.controller.ThrowsController;

public class Run {
//	public static void main(String[] args) throws Exception {
	// throws Exception�� main�� �߰��ϸ� ������ ���� ��
	public static void main(String[] args) {
		ThrowsController tc = new ThrowsController();
		try {
			tc.method1();
		} catch(Exception e) { // e : Exception�� �θ����� �ϴ� ����
//			e.printStackTrace();
			// ���� ���� �� �߻� ��ġ�� �ֿܼ� ������ִ� �޼ҵ�
			System.out.println("���� ��Ȳ�� �߻��Ͽ����ϴ�");
		}
		
		
		System.out.println("���������� �����...");
		// �����ϸ� ������ ���µ� ���������� ������� ��µ�
		// -> ������ Exception in thread "main"�� ����
		// -> ���ܸ� ���� �Ϳ� ���� ������ ������� ��
	}
}
