package com.kh.operator;

public class C_Arithmetic {
	public void method1() {
		int num1 = 10;
		int num2 = 3;
		
		System.out.println("num1 + num2 = " + (num1 + num2)); // 13
		System.out.println("num1 - num2 = " + (num1 - num2)); // 7
		System.out.println("num1 * num2 = " + (num1 * num2)); // 30
		System.out.println("num1 / num2 = " + (num1 / num2)); // 3
		System.out.println("num1 % num2 = " + (num1 % num2)); // 1
		
		double a = 35;
		double b = 10;
		
		double add = a + b;
		double sub = a - b;
		double mul = a * b;
		double div = a / b;
		double mod = a % b;
		System.out.println("add : " + add);
		System.out.println("sub : " + sub);
		System.out.println("mul : " + mul);
		System.out.println("div : " + div);
		System.out.println("mod : " + mod);
	}
	
	public void method2() {
		int a = 5;
		int b = 10;
		int c = (++a) + b; // a = 6, b = 10 -> 16
		//       6    + 10
		// a = 6, b = 10, c = 16
		int d = c / a; // 2
		//     16 / 6
		// d = 2
		int e = c % a; // 4
		//     16 % 6
		// e = 4
		int f = e++; // 4 -> e = 5
		// f = 4, e = 5
		int g = (--b) + (d--); // 10 -> b = 9, d = 1
		//        9   +   2
		// g = 11, b = 9, d = 1
		int h = 2;
		int i = a++ + b / (--c / f) * (g-- - d) % (++e + h);
		//                ( 15 / 4) * (11  - 1) % ( 6  + 2)
		//      6   + 9 /     3     *   10      %    8
		//      6   +     3         *   10      %    8
		//      6   +              30           %    8
		//      6   +                   6
		// i = 12
		
		System.out.println("a : " + a); // 7
		System.out.println("b : " + b); // 9 
		System.out.println("c : " + c); // 15
		System.out.println("d : " + d); // 1
		System.out.println("e : " + e); // 6
		System.out.println("f : " + f); // 4
		System.out.println("g : " + g); // 10
		System.out.println("h : " + h); // 2
		System.out.println("i : " + i); // 12
	}
}
