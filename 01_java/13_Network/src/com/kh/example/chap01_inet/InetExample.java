package com.kh.example.chap01_inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetExample {
	public static void main(String[] args) {
		try {
			InetAddress localIP = InetAddress.getLocalHost(); // static �޼ҵ� -> Ŭ���� �̸�.���� ���� ������
			// Unhandled exception type UnknownHostException
			// ����ó�� ���־�� ��
			// ���� ȣ��Ʈ(��Ʈ��ũ�� ����Ǿ� �ִ� ��ǻ��)�� Host��� IP �ּ� ��ȯ
			System.out.println("localIP : " + localIP);
			System.out.println("�� PC �� : " + localIP.getHostName()); // ȣ��Ʈ �̸� ��ȯ
			System.out.println("�� IP : " + localIP.getHostAddress()); // ȣ��Ʈ IP �ּ� ��ȯ
			
			byte[] ipAddress = localIP.getAddress(); // IP�ּҸ� byte �迭�� ��ȯ
			for(byte b:ipAddress) {
				System.out.print(b + " "); // -64 -88 -37 100 
				// byte�� ������ ����� �Ǹ� ���ڰ� ��ȯ�ϱ� ������ - ������ ���� �� ����(-128~127) : �����÷ο�
				// �����÷ο� : ���� �� �ִ� �ִ� �������� ��� ��
			}
			
			System.out.println();
			System.out.println();
			
			InetAddress iei = InetAddress.getByName("www.iei.or.kr"); // �������� ���� IP �ּҸ� ���״� �޼ҵ�, ������ : ����Ʈ �ּ�
			System.out.println("iei ���� �� : " + iei.getHostName());
			System.out.println("iei ���� ip : " + iei.getHostAddress());
			
			System.out.println();
			
			InetAddress[] google = InetAddress.getAllByName("www.google.com"); // ������ ū ���� ������ ���� ���� ��찡 �ִµ� �̰��� Ȯ���ϱ� ���ؼ��� getAllByName ���
			System.out.println("���� IP ���� : " + google.length);
			for(InetAddress ip : google) {
				System.out.println(ip.getHostAddress());
			}
		
			System.out.println();
			
			InetAddress[] naver = InetAddress.getAllByName("www.naver.com"); 
			System.out.println("���̹� IP ���� : " + naver.length);
			for(InetAddress ip : naver) {
				System.out.println(ip);
			}
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
	}
}
