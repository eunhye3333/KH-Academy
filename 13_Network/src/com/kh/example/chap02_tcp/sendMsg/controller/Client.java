package com.kh.example.chap02_tcp.sendMsg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public void clientStart() {
		// Ŭ���̾�Ʈ�� TCP ���� ���α׷��� ����
		// 1. ������ IP �ּҿ� ������ ���� ��Ʈ ��ȣ�� �Ű� ������ �Ͽ� Ŭ���̾�Ʈ�� ���� ��ü ����
		// 2. �������� ����� ��Ʈ�� ����
		// 3. ���� ��Ʈ������ ���� ����
		// 4. ��Ʈ���� ���� �а� ����
		// 5. ��� ����
		
		try {
			// 1. ������ IP �ּҿ� ������ ���� ��Ʈ ��ȣ�� �Ű� ������ �Ͽ� Ŭ���̾�Ʈ�� ���� ��ü ����
			int port = 8500;
			// ���� ���� IP�� �ٸ� �ּҶ�� �Ѵٸ� �� ip�� ���� �� ���¿��� �Ű������� �־�� ��
//			String serverIP = "192.157.10.99";
			String serverIP = InetAddress.getLocalHost().getHostAddress();
			Socket socket = new Socket(serverIP, port);
			// ������ ����� Ŭ���̾�Ʈ�� ip�� ������ ip�� ���� ������(�� ��ǻ�Ϳ��� �ؼ�) �� ip ����
			
			// ���ῡ ������ ��� null�� ��ȯ�ϱ� ������ ���ῡ �������� ���� ������ �� �ֵ��� if�� �ۼ�
			if(socket != null) {
				// 2. �������� ����� ��Ʈ�� ����
				// 3. ���� ��Ʈ������ ���� ����
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				
				// 4. ��Ʈ���� ���� �а� ����
				// Ŭ���̾�Ʈ -> ���� �޼��� ����
				pw.println("�ݰ�����");
				pw.flush();

				// ���� -> Ŭ���̾�Ʈ �޼��� �б�
				String message = br.readLine();
				System.out.println(message);
				
				// 5. ��� ����
				pw.close();
				br.close();
				socket.close();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
