package com.kh.example.chap00_file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {
	public void method() {
		try {
			File f1 = new File("test.txt"); // f1은 test.txt라는 파일의 정보를 가지고 있겠다는 뜻, 이것만 하면 파일 생성 안 됨
			f1.createNewFile(); // 새로운 파일을 생성해주는 메소드
			// Unhandled exception type IOException
			// 파일 클래스에 있는 createNewFile을 호출하는데 해당 메소드가 IOException을 위임하고 있음
			// 따라서 사용하고자하는 내가 이것을 처리해주어야 함
			// 경로를 지정하지 않은 상태에서 파일을 생성해 주면 프로젝트의 최상단에 파일이 만들어짐
			
			File f2 = new File("c:/test/test.txt"); // 경로 지정
			f2.createNewFile(); // java.io.IOException: 지정된 경로를 찾을 수 없습니다
			// 내 c드라이브에 test라는 폴더가 없어서 생성 불가능
			// createNewFile은 단순히 파일만 만들어주는 메소드라서 경로가 없으면 만들어지지 않음. 경로는 직접 설정해 줘야 함
			// c드라이브에 test 폴더를 만든 후 실행하면 해당 폴더에 test.text 파일 만들어짐
			
			File f3 = new File("c:temp1/temp2");
			File f4 = new File("c:temp1/temp2/test.txt");
//			f4.createNewFile(); // 불가능. 경로를 먼저 만들어 줘야 함
			f3.mkdirs(); // make directories : 경로를 만들어줌 (여러개의 경로를 만들어줌)
			// mkdir()은 딱 하나의 경로만 만들어 주는 것
			f4.createNewFile();
			f4.delete(); // 파일 삭제
			
			System.out.println(f2.exists()); // true
			System.out.println(f3.exists()); // true : 폴더 자체는 존재
			System.out.println(f4.exists()); // false : 삭제함
			System.out.println(f3.isFile()); // 이게 파일이니? : false
			
			System.out.println(f1.getName());
			System.out.println(f1.getAbsolutePath()); // 절대 경로, 경로의 풀네임
			System.out.println(f1.getPath()); // 상대 경로
			System.out.println(f1.length());
			System.out.println(f1.getParent()); // 상위 폴더가 무엇인지
			System.out.println(f4.getParent());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
