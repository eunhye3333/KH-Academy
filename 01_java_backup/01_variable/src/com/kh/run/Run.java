package com.kh.run;

import com.kh.variable.A_Variable; // �ش� ��Ű���� �ִ� A_Variable�� ���� ���ڴ� 
import com.kh.variable.B_Constant;
import com.kh.variable.C_Cast;
import com.kh.variable.D_PrintMethod;
import com.kh.variable.E_KeyboardInput;
// import�� ���� ���� ���� ���� Ŭ������ ��ġ�� ������ִ� ����
// package�� ���� ���� �ִ� ��ġ
// import �� �����ؾ� �ݿ� ����

public class Run { // ���� Ŭ����
	public static void main(String[] args) { // ���� �޼ҵ�
		// A_Variable Ŭ���� ����
		// 1. Ŭ���� �տ� ��Ű������ �� ���� Ŭ������ Ǯ�������� ����
//		com.kh.variable.A_Variable av = new com.kh.variable.A_Variable();
//		-------------------------- -> �� �κ��� Ŭ������ Ǯ�����̴�. 
//		A_Variable av = new A_Variable(); ���� Ÿ������ �� �� ���ٴ� ���� �߻�. �Ʒ��� ������ ��ġ�� ��� �����ϰ� ����.
		// 2. import�� ����Ͽ� ���� (�� ���� ���)
		A_Variable av = new A_Variable();
		//             ------------------ -> �� �κ��� Ŭ������ ���� �˸��̸� ����� �κ�. �˸��̰� �־�� ����/��� ����. �˸��̸� av��� ������ ��Ƶΰ� �ִ� ��.
		
		// Ŭ���� �ȿ� �ִ� �޼ҵ忡 ����
//		av.declareVariable(); // av ���� �ȿ� �ִ� �޼ҵ� ����
//		av.initVariable();
		
		B_Constant bc = new B_Constant();
//		bc.finalConstant();

		C_Cast cc = new C_Cast();
//		cc.rule1();
//		cc.rule2();
		
		D_PrintMethod dp = new D_PrintMethod();
//		dp.printlnExample();
//		dp.printExample();
//		dp.printfExample();
		
		E_KeyboardInput eki = new E_KeyboardInput();
//		eki.inputScanner1();
		eki.inputScanner2();
		
		
	}
}
