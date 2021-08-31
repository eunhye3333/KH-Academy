package com.kh.example.chap01_byte.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteDAO {
	public void fileOpen() {
		// 파일로부터 byte 단위로 데이터를 읽어 오고 싶다
		// ----   --------       -------
		// File    Stream         Input  => FileInputStream
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a_byte.txt"); // 연결만 하고 읽어오겠다고는 안 해서 이것만 하면 아무것도 안 뜸
//			fis.read(); // 파일 읽어오기. IOException 예외처리 필요
			// FileInputStream.read():int
			// 다음에 있는 값을 차례로 반환하는데, (int를 아스키코드로)
			// 파일의 끝에 도달했을 때는 -1을 반환
			// for문이면 끝을 정해줘야 되는데 데이터는 그게 복잡하기 때문에 간단한 while문 사용
			
//			while(fis.read() != -1) { 
//				System.out.print((char)fis.read() + " "); // 저장한 값이 다 출력이 안 됨
//				// while 조건문에서 한 번 읽고 그 다음으로 넘어가기 때문에 홀수 번째 값은 while의 조건문에서 읽고, 그 다음 값을 아래에서 출력함
//			}
			
			int value;
			while((value = fis.read()) != -1) { // value에 값을 임시로 저장하고 value를 찍음
				    							// fis.read()를 여러 번 사용하지 않도록
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
		// 파일에 byte 단위로 데이터를 쓰고 싶다
		// --- --------        ------
 		// File Stream         Output  => FileOutputStream
		// 파일이 존재하지 않으면 자동으로 만들어주고, 파일이 존재한다면 덮어씀
		FileOutputStream fos = null; // 참조형 변수이기 때문에 기본값이 null
		try {
			fos = new FileOutputStream("a_byte.txt");
			// Unhandled exception type FileNotFoundException
			// 자동으로 만들어 준다고 하더라고 혹시나를 대비해 FileNotFoundException을 throws 하고 있음
			
			// 아스키 코드에 맞는 int값을 넣으면 출력이 됨
			fos.write(97); // IOException을 넘겨받아서 에러가 남. 넘겨받으면 거기에서 처리해주는게 맞음
			// Add catch clause to surrounding try -> 지금 try에 catch를 추가하겠다
			// Add exception to existing catch clause -> 현재 있는 catch절에 추가하겠다 -> catch(FileNotFoundException | IOException e)
			// -> 이렇게 하면 에러가 남 : FileNotFoundException이 IOException의 후손이기 때문에 같이 두면 FileNotFoundException이 할 일이 없음
			// try~catch를 안에 또 추가할 수 있긴 하지만 보기에 좋지는 않음
			// Add catch clause to surrounding try 선택
			
			byte[] bArr = {98, 99, 100, 101, 102, 103};
			fos.write(bArr);
			// 덮어쓰기 된 것임
			// 만약 이어쓰기가 되었다면 기존의 a는 두고 이어서 다시 작성된 것이기 때문에 aabcdefg라고 작성되어야 함
			
			// bArr = bcdefg
			// 인덱스 1부터 3개의 문자만 쓰겠다 => 3은 인덱스가 아니라 length이므로 개수
			fos.write(bArr, 1, 3);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();  // fos는 영역이 try까지인데 finally에서 가지고 오려고 해서 영역이 겹치지 않음.
				// 따라서 fos를 try~catch 위로 빼 줘야 함
				// Stream 닫기
				// 위에 있는 catch는 위의 try에 대한 catch이기 때문에 영역이 달라서 try~catch를 또 만들어 줘야 함
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
