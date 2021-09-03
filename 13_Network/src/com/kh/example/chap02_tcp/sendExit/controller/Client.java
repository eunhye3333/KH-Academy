package com.kh.example.chap02_tcp.sendExit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public void startClient() {
		// 클라이언트용 TCP 소켓 프로그래밍 순서
		// 1. 서버의 IP 주소와 서버가 정한 포트 번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
		// 2. 서버와의 입출력 스트림 오픈
		// 3. 보조 스트림으로 성능 개선
		// 4. 스트림을 통해 읽고 쓰기
		// 5. 통신 종료
		
		String serverIP;
		try {
			// 1. 서버의 IP 주소와 서버가 정한 포트 번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
			serverIP = InetAddress.getLocalHost().getHostAddress();
			int port = 6666;
			Socket socket = new Socket(serverIP, port);
			
			if(socket != null) {
				// 2. 서버와의 입출력 스트림 오픈
				// 3. 보조 스트림으로 성능 개선
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				
				// 4. 스트림을 통해 읽고 쓰기
				Scanner sc = new Scanner(System.in);
				
				do {
					System.out.print("대화 입력 : ");
					String message = sc.nextLine();
					pw.println(message);
					pw.flush();
					
					if(message.equals("exit")) {
						break;
					}
					
					String receiveMessage = br.readLine();
					System.out.println(receiveMessage);
				} while(true);
				
				// 5. 통신 종료
				br.close();
				pw.close();
				socket.close();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
