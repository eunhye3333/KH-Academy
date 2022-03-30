package com.kh.example.chap01_inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetExample {
	public static void main(String[] args) {
		try {
			InetAddress localIP = InetAddress.getLocalHost(); // static 메소드 -> 클래스 이름.으로 들어가기 때문에
			// Unhandled exception type UnknownHostException
			// 예외처리 해주어야 함
			// 지역 호스트(네트워크에 연결되어 있는 컴퓨터)의 Host명과 IP 주소 반환
			System.out.println("localIP : " + localIP);
			System.out.println("내 PC 명 : " + localIP.getHostName()); // 호스트 이름 반환
			System.out.println("내 IP : " + localIP.getHostAddress()); // 호스트 IP 주소 반환
			
			byte[] ipAddress = localIP.getAddress(); // IP주소를 byte 배열로 반환
			for(byte b:ipAddress) {
				System.out.print(b + " "); // -64 -88 -37 100 
				// byte의 범위를 벗어나게 되면 숫자가 순환하기 때문에 - 형식이 나올 수 있음(-128~127) : 오버플로우
				// 오버플로우 : 가질 수 있는 최대 범위에서 벗어난 것
			}
			
			System.out.println();
			System.out.println();
			
			InetAddress iei = InetAddress.getByName("www.iei.or.kr"); // 도메인을 통해 IP 주소를 얻어네는 메소드, 도메인 : 사이트 주소
			System.out.println("iei 서버 명 : " + iei.getHostName());
			System.out.println("iei 서버 ip : " + iei.getHostAddress());
			
			System.out.println();
			
			InetAddress[] google = InetAddress.getAllByName("www.google.com"); // 서버가 큰 경우는 서버가 여러 개인 경우가 있는데 이것을 확인하기 위해서는 getAllByName 사용
			System.out.println("구글 IP 개수 : " + google.length);
			for(InetAddress ip : google) {
				System.out.println(ip.getHostAddress());
			}
		
			System.out.println();
			
			InetAddress[] naver = InetAddress.getAllByName("www.naver.com"); 
			System.out.println("네이버 IP 개수 : " + naver.length);
			for(InetAddress ip : naver) {
				System.out.println(ip);
			}
			
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
	}
}
