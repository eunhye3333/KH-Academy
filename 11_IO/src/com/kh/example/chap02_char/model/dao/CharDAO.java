package com.kh.example.chap02_char.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharDAO {
	public void fileOpen() {
		// 파일로부터 문자 기반으로 데이터를 읽어오고 싶다
		// ----   ---------      -------
		// File    Stream x       Reader  => FileReader
		FileReader fr = null;
		try {
			fr = new FileReader("b_char.txt");
			
			int value;
			while((value = fr.read()) != -1) {
				System.out.print((char)value + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileOpen2() {
		try(FileReader fr = new FileReader("b_char.txt");) {
			// Unhandled exception type IOException thrown by automatic close() invocation on fr
			// FileReader 자체는 FileNotFoundException만 가지고 있는 게 맞지만, close 하는 메소드는 IOException을 위임하고 있음
			// 따라서 자동 close를 하려면 IOException에 대한 처리가 필요함
			
			int value;
			while((value = fr.read()) != -1) {
				System.out.print((char)value + " ");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void fileSave() {
		// 파일에 문자 기반으로 데이터를 쓰고 싶다
		// ---  -----         ------
		// File Stream x      Writer  => FileWriter
		FileWriter fw = null;
		try {
			fw = new FileWriter("b_char.txt", true); // 이어서 쓰기
			fw.write("와, IO 재밌다!");
			fw.write('A');
			char[] cArr = {'a', 'p', 'p', 'l', 'e'};
			fw.write(cArr);
			// 저장이 안 되어 있음. close를 해 주지 않았기 때문에
			// 문자 기반은 문자로 읽어오는 것이기 때문에 byte와 다르게 닫아 줘야 잘 저장이 됨
			// 끝났다고 알려 줘야 함
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void fileSave2() {
		try(FileWriter fw = new FileWriter("b_char.txt", true);) { // 자동 close 
			//                                                - 세미콜론은 있어도 되고 없어도 되는데 닫아야 하는 객체가 많는 경우에는 세미콜론으로 구분해야 하기 때문에 써주는게 좋음
			fw.write("와, IO 재밌다!");
			fw.write('A');
			char[] cArr = {'a', 'p', 'p', 'l', 'e'};
			fw.write(cArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
