package com.kh.example.chap00_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	public void method() {
		try {
			File f1 = new File("test.txt"); // f1�� test.txt��� ������ ������ ������ �ְڴٴ� ��, �̰͸� �ϸ� ���� ���� �� ��
			f1.createNewFile(); // ���ο� ������ �������ִ� �޼ҵ�
			// Unhandled exception type IOException
			// ���� Ŭ������ �ִ� createNewFile�� ȣ���ϴµ� �ش� �޼ҵ尡 IOException�� �����ϰ� ����
			// ���� ����ϰ����ϴ� ���� �̰��� ó�����־�� ��
			// ��θ� �������� ���� ���¿��� ������ ������ �ָ� ������Ʈ�� �ֻ�ܿ� ������ �������
			
			File f2 = new File("c:/test/test.txt"); // ��� ����
			f2.createNewFile(); // java.io.IOException: ������ ��θ� ã�� �� �����ϴ�
			// �� c����̺꿡 test��� ������ ��� ���� �Ұ���
			// createNewFile�� �ܼ��� ���ϸ� ������ִ� �޼ҵ�� ��ΰ� ������ ��������� ����. ��δ� ���� ������ ��� ��
			// c����̺꿡 test ������ ���� �� �����ϸ� �ش� ������ test.text ���� �������
			
			File f3 = new File("c:temp1/temp2");
			File f4 = new File("c:temp1/temp2/test.txt");
//			f4.createNewFile(); // �Ұ���. ��θ� ���� ����� ��� ��
			f3.mkdirs(); // make directories : ��θ� ������� (�������� ��θ� �������)
			// mkdir()�� �� �ϳ��� ��θ� ����� �ִ� ��
			f4.createNewFile();
			f4.delete(); // ���� ����
			
			System.out.println(f2.exists()); // true
			System.out.println(f3.exists()); // true : ���� ��ü�� ����
			System.out.println(f4.exists()); // false : ������
			System.out.println(f3.isFile()); // �̰� �����̴�? : false
			
			System.out.println(f1.getName());
			System.out.println(f1.getAbsolutePath()); // ���� ���, ����� Ǯ����
			System.out.println(f1.getPath()); // ��� ���
			System.out.println(f1.length());
			System.out.println(f1.getParent()); // ���� ������ ��������
			System.out.println(f4.getParent());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
