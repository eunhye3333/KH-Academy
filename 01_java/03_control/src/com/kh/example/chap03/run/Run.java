package com.kh.example.chap03.run;

import com.kh.example.chap03.branch.A_Break;
import com.kh.example.chap03.branch.B_Continue;

public class Run {
	public static void main(String[] args) {
		A_Break ab = new A_Break();
//		ab.method();
		
		B_Continue bc = new B_Continue();
		bc.method();
	}
}
