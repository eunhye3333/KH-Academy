package com.kh.example.chap02_tcp.sendMsg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	// TCP(Transmission Control Protocol)
	// 		������ Ŭ���̾�Ʈ ���� 1:1 ���� ���(���� ������ ��������)
	//		������ ���� �� ���� ������ Ŭ���̾�Ʈ�� ����Ǿ� �־�� ��
	//			==> ������ Ŭ���̾�Ʈ�� ���� �����ϰ� ������ ���� ����Ǿ� Ŭ���̾�Ʈ�� ��û�� ��ٸ�
	
	// ServerSocket
	//		��Ʈ�� ����Ǿ� �ܺ��� ��û�� ��ٸ��� ��û�� ������ ���� �� Socket�� ������ ���ϰ� ���� ���� ����� �̷������ ��
	//		�� ��Ʈ�� �ϳ��� SeverSocket�� ���� ����
	// Socket
	//		���μ��� �� ��� ���
	//		InputStream/OutputStream ���� : �� ��Ʈ������ ���μ��� ���� ����� �̷����

	public void serverStart() {
		// ������ TPC ���� ���α׷��� ����
		// 1. ���� ��Ʈ��ȣ ���ϱ�
		// 2. ������ ���� ��ü ���� �� ��Ʈ�� ����
		// 3. Ŭ���̾�Ʈ �ʿ��� ��û�� ���� ��ٸ�
		// 4. ��û�� ���� ���� �� �ش� Ŭ���̾�Ʈ�� ���� ���� ��ü ����
		// 5. ����� Ŭ���̾�Ʈ�� ����� ��Ʈ�� ����
		// 6. ���� ��Ʈ���� ���� ���� ����
		// 7. ��Ʈ���� ���� �а� ����
		// 8. ��� ����
		
		// 1. ���� ��Ʈ��ȣ ���ϱ� : 0~65535 ���� ���� (��� 1023 ���ϴ� �̹� ��� ���� ��Ʈ�� ���� ������ �� �̻��� ���� ����. ���� 5000���� ���ķ� ����ϸ�, 10000�� ���� ����)
		int port = 8500;
		
		// 2. ������ ���� ��ü(SeverSocket) ���� �� ��Ʈ�� ����
		try {
			ServerSocket server = new ServerSocket(port); // ������ ��

			// 3. Ŭ���̾�Ʈ �ʿ��� ��û�� ���� ��ٸ�
			System.out.println("Ŭ���̾�Ʈ�� ��û�� ��ٸ��� �ֽ��ϴ�..."); // ����ϴ� ���� �ڵ�� �ۼ� �Ұ���
			
			// 4. ��û�� ���� ���� �� �ش� Ŭ���̾�Ʈ�� ���� ����(Socket) ��ü ����
			Socket client = server.accept(); // ��ȯ �� : Socket -> accept���� ��ȯ�� �Ǵ� Socket�� Ŭ���̾�Ʈ�� ���� ���� ��ü�� ��
			// ��ȯ�ϴ� ���� �޾��ִ� �͸����ε� ���� ��ü�� �����ϴ� ���̴� -> new ������� �ʾƵ� ��
			
			String clientIP = client.getInetAddress().getHostAddress();
			System.out.println(clientIP + "�� ������ ��û��...");
			
			// 5. ����� Ŭ���̾�Ʈ�� ����� ��Ʈ�� ����
			InputStream in = client.getInputStream();
			OutputStream out = client.getOutputStream();
			
			// 6. ���� ��Ʈ���� ���� ���� ����
			// �ѱ��� ������ ���ؼ��� ���� ������ ���� ������ �� -> ���� ����
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(out);
			
			// 7. ��Ʈ���� ���� �а� ����
			// Ŭ���̾�Ʈ -> ������ ������ �޼��� �б�
			String message = br.readLine();
			System.out.println(clientIP + "�� ���� �޼��� : " + message);
			// ���� -> Ŭ���̾�Ʈ�� �޼��� ����
			pw.println("������ �ݰ����ϴ�.");
			pw.flush(); // ���۸� �����ϰ� �� �ִ� ����
			
			// 8. ��� ����
			pw.close();
			br.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
