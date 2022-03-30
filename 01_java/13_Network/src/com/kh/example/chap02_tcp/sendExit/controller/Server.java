package com.kh.example.chap02_tcp.sendExit.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	// 양방향으로 통신하려면 스레드를 사용해야 함 -> 어려워서 클라이언트만 보내는 방식으로 작성
	public void startServer() {
		// 서버용 TCP 소켓 프로그래밍 순서
		// 1. 서버의 포트 번호 정하기
		// 2. 서버용 소켓 객체 생성 후 포트와 결합
		// 3. 클라이언트 쪽에서 접속 요청이 오길 기다림
		// 4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
		// 5. 연결된 클라이언트와 입출력 객체 생성
		// 6. 보조 스트림으로 성능 개성
		// 7. 스트림을 통해 읽고 쓰기 
		// 8. 통신 종료
		
		// 1. 서버의 포트 번호 정하기
		int port = 6666;
		
		// 2. 서버용 소켓 객체 생성 후 포트와 결합
		try {
			ServerSocket server = new ServerSocket(port);
			
			// 3. 클라이언트 쪽에서 접속 요청이 오길 기다림
			System.out.println("클라이언트의 요청을 기다리고 있습니다...");
			
			// 4. 접속 요청이 오면 요청 수락 후 해당 클라이언트에 대한 소켓 객체 생성
			Socket client = server.accept();
			
			String clientIP = client.getInetAddress().getHostAddress();
			System.out.println(clientIP + "가 연결을 요청함...");
			
			// 5. 연결된 클라이언트와 입출력 객체 생성
			// 6. 보조 스트림으로 성능 개선
			BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter pw = new PrintWriter(client.getOutputStream());
			
			// 7. 스트림을 통해 읽고 쓰기 
			// 반복하여야 계속 받아올 수 있음
			while(true) {
				String message = br.readLine();
				
				if(!message.equals("exit")) {
					System.out.println(clientIP + "가 보낸 메세지 : " + message);
					pw.println("메세지 받기 성공");
					pw.flush();
				} else {
					System.out.println("접속 종료");
					break;
				}
			}
			
			// 8. 통신 종료
			br.close();
			pw.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
