package com.kh.example.chap01_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {
	public void fileOpen() {
		// ���Ϸκ��� byte ������ �����͸� �о� ���� �ʹ�
		// ----   --------       -------
		// File    Stream         Input  => FileInputStream
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a_byte.txt"); // ���Ḹ �ϰ� �о���ڴٰ�� �� �ؼ� �̰͸� �ϸ� �ƹ��͵� �� ��
//			fis.read(); // ���� �о����. IOException ����ó�� �ʿ�
			// FileInputStream.read():int
			// ������ �ִ� ���� ���ʷ� ��ȯ�ϴµ�, (int�� �ƽ�Ű�ڵ��)
			// ������ ���� �������� ���� -1�� ��ȯ
			// for���̸� ���� ������� �Ǵµ� �����ʹ� �װ� �����ϱ� ������ ������ while�� ���
			
//			while(fis.read() != -1) { 
//				System.out.print((char)fis.read() + " "); // ������ ���� �� ����� �� ��
//				// while ���ǹ����� �� �� �а� �� �������� �Ѿ�� ������ Ȧ�� ��° ���� while�� ���ǹ����� �а�, �� ���� ���� �Ʒ����� �����
//			}
			
			int value;
			while((value = fis.read()) != -1) { // value�� ���� �ӽ÷� �����ϰ� value�� ����
				    							// fis.read()�� ���� �� ������� �ʵ���
				System.out.print((char)value + " "); 
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileOpen2() {
		try(FileInputStream fis = new FileInputStream("a_byte.txt");) {
			int value;
			while((value = fis.read()) != -1) { 
				System.out.print((char)value + " "); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void fileSave() {
		// ���Ͽ� byte ������ �����͸� ���� �ʹ�
		// --- --------        ------
 		// File Stream         Output  => FileOutputStream
		// ������ �������� ������ �ڵ����� ������ְ�, ������ �����Ѵٸ� ���
		FileOutputStream fos = null; // ������ �����̱� ������ �⺻���� null
		try {
			fos = new FileOutputStream("a_byte.txt");
			// Unhandled exception type FileNotFoundException
			// �ڵ����� ����� �شٰ� �ϴ���� Ȥ�ó��� ����� FileNotFoundException�� throws �ϰ� ����
			
			// �ƽ�Ű �ڵ忡 �´� int���� ������ ����� ��
			fos.write(97); // IOException�� �Ѱܹ޾Ƽ� ������ ��. �Ѱܹ����� �ű⿡�� ó�����ִ°� ����
			// Add catch clause to surrounding try -> ���� try�� catch�� �߰��ϰڴ�
			// Add exception to existing catch clause -> ���� �ִ� catch���� �߰��ϰڴ� -> catch(FileNotFoundException | IOException e)
			// -> �̷��� �ϸ� ������ �� : FileNotFoundException�� IOException�� �ļ��̱� ������ ���� �θ� FileNotFoundException�� �� ���� ����
			// try~catch�� �ȿ� �� �߰��� �� �ֱ� ������ ���⿡ ������ ����
			// Add catch clause to surrounding try ����
			
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			fos.write(bArr);
			// ����� �� ����
			// ���� �̾�Ⱑ �Ǿ��ٸ� ������ a�� �ΰ� �̾ �ٽ� �ۼ��� ���̱� ������ aabcdefg��� �ۼ��Ǿ�� ��
			
			// bArr = bcdefg
			// �ε��� 1���� 3���� ���ڸ� ���ڴ� => 3�� �ε����� �ƴ϶� length�̹Ƿ� ����
			fos.write(bArr, 1, 3);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();  // fos�� ������ try�����ε� finally���� ������ ������ �ؼ� ������ ��ġ�� ����.
				// ���� fos�� try~catch ���� �� ��� ��
				// Stream �ݱ�
				// ���� �ִ� catch�� ���� try�� ���� catch�̱� ������ ������ �޶� try~catch�� �� ����� ��� ��
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave2() {
		try(FileOutputStream fos = new FileOutputStream("a_byte.txt");) {
			fos.write(97);
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			fos.write(bArr);
			fos.write(bArr, 1, 3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
