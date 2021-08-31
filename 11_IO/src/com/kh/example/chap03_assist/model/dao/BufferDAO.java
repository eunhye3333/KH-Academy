package com.kh.example.chap03_assist.model.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BufferDAO {
	public void inputByte() {
		// 나는 파일에 있는 데이터를 바이트 기반으로 빠르게 읽어오고 싶어
		//    ----          -------   ---- -----
		//    File          Stream         Input  => FileInputStream (기반)
		//                           Buffered     => BufferedInputStream -> 기반을 따라가야 함
		try(FileInputStream fis = new FileInputStream("c_buffer.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);) { // 기반과 함께 사용해야 함
			
			int value;
			while((value = bis.read()) != -1) {
				System.out.print((char)value + " ");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void outputByte() {
		// 파일에 데이터를 바이트 기반으로 빠르게 쓰고 싶다
		// ---       -----     ----- ----
		// File      Stream          Output  => FileOutputStream
		//                     Buffered      => BufferedOutputStream
//		BufferedOutputStream bos = null;
		try(FileOutputStream fos = new FileOutputStream("c_buffer.txt", true); // 얘가 밑에 있으면 bos를 인지하지 못해서 같이 넣어야 함
				// 마지막에 세미콜론은 없어도 되지만 중간 세미콜론은 구분을 위해 있어야 함 없으면 에러 
				BufferedOutputStream bos = new BufferedOutputStream(fos);) {
			
			bos.write(65);
			
			byte[] bArr = {66, 67, 68, 69};
			bos.write(bArr);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} /*finally {
			try {
				bos.close(); // bos 안에 fos가 있어서 bos만 닫아줘도 됨
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}*/
		
	}
	
	public void outputChar() {
		// 파일에 문자 기반으로 데이터를 빠르게 쓰고 싶어
		// --- ------         ---- -----
		// File Stream x           Writer  => FileWriter
		//                   Buffered      => BufferedWriter
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("c_buffer.txt", true));) {
			bw.write("안녕하세요\n");
			bw.write("반갑습니다\n");
			bw.write("저리가세요\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void inputChar() {
		// 파일로부터 문자 기반으로 데이터를 빠르게 읽고 싶어
		// ---    ------         ---- -----
		// File Stream x              Reader  => FileReader
		//                   Buffered         => BufferedReader
		
		try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"));) {
			
			String value = null;
			while((value = br.readLine()) != null) {
				System.out.println(value);
			}
//			br.readLine(); // BufferedReader가 제공하는 특별한 메소드
			// Scanner의 nextLine과 같은 뜻
			// Scanner의 nextLine 대신 사용 가능
			// read는 딱 한 글자씩만 읽어오는 것
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void ioTest() {
		// 사용자에게 이름과 나이를 입력 받고, 사용자의 10년 후의 나이 출력
		// 기본 입출력 (기반 스트림의 역할을 함)
		// System.in : InputStream
		// System.out : PrintStream
//		InputStreamReader isr = new InputStreamReader(System.in); // System.in -> 바이트 기반을 문자 기반으로 바꿔 주고 있음
//		BufferedReader br = new BufferedReader(isr); // isr로 System.in을 문자 기반으로 바꿨기 때문에 문자 기반을 사용해야 함
		
		try(InputStreamReader isr = new InputStreamReader(System.in); 
				BufferedReader br = new BufferedReader(isr);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));) {

			System.out.print("이름 입력 : ");
			String name = br.readLine();
			
			System.out.print("나이 입력 : ");
			int age = Integer.parseInt(br.readLine());
			
//			System.out.println(name + "님의 10년 후 나이는 " + (age + 10) + "살입니다.");
			bw.write(name + "님의 10년 후 나이는 " + (age + 10) + "살입니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
