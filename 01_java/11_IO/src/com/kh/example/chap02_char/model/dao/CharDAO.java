package com.kh.example.chap02_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharDAO {
	public void fileOpen() {
		// ���Ϸκ��� ���� ������� �����͸� �о���� �ʹ�
		// ----   ---------      -------
		// File    Stream x       Reader  => FileReader
		FileReader fr = null;
		try {
			fr = new FileReader("b_char.txt");
			
			int value;
			while((value = fr.read()) != -1) {
				System.out.print((char)value + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileOpen2() {
		try(FileReader fr = new FileReader("b_char.txt");) {
			// Unhandled exception type IOException thrown by automatic close() invocation on fr
			// FileReader ��ü�� FileNotFoundException�� ������ �ִ� �� ������, close �ϴ� �޼ҵ�� IOException�� �����ϰ� ����
			// ���� �ڵ� close�� �Ϸ��� IOException�� ���� ó���� �ʿ���
			
			int value;
			while((value = fr.read()) != -1) {
				System.out.print((char)value + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void fileSave() {
		// ���Ͽ� ���� ������� �����͸� ���� �ʹ�
		// ---  -----         ------
		// File Stream x      Writer  => FileWriter
		FileWriter fw = null;
		try {
			fw = new FileWriter("b_char.txt", true); // �̾ ����
			fw.write("��, IO ��մ�!");
			fw.write('A');
			char[] cArr = {'a', 'p', 'p', 'l', 'e'};
			fw.write(cArr);
			// ������ �� �Ǿ� ����. close�� �� ���� �ʾұ� ������
			// ���� ����� ���ڷ� �о���� ���̱� ������ byte�� �ٸ��� �ݾ� ��� �� ������ ��
			// �����ٰ� �˷� ��� ��
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave2() {
		try(FileWriter fw = new FileWriter("b_char.txt", true);) { // �ڵ� close 
			//                                                - �����ݷ��� �־ �ǰ� ��� �Ǵµ� �ݾƾ� �ϴ� ��ü�� ���� ��쿡�� �����ݷ����� �����ؾ� �ϱ� ������ ���ִ°� ����
			fw.write("��, IO ��մ�!");
			fw.write('A');
			char[] cArr = {'a', 'p', 'p', 'l', 'e'};
			fw.write(cArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
