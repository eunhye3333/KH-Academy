package com.kh.run;

import com.kh.variable.A_Variable; // 해당 패키지에 있는 A_Variable을 갖다 쓰겠다 
import com.kh.variable.B_Constant;
import com.kh.variable.C_Cast;
import com.kh.variable.D_PrintMethod;
import com.kh.variable.E_KeyboardInput;
// import는 내가 지금 갖다 쓰는 클래스의 위치를 명시해주는 역할
// package는 현재 내가 있는 위치
// import 후 저장해야 반영 가능

public class Run { // 실행 클래스
	public static void main(String[] args) { // 실행 메소드
		// A_Variable 클래스 접근
		// 1. 클래스 앞에 패키지까지 다 적어 클래스의 풀네임으로 접근
//		com.kh.variable.A_Variable av = new com.kh.variable.A_Variable();
//		-------------------------- -> 이 부분이 클래스의 풀네임이다. 
//		A_Variable av = new A_Variable(); 무슨 타입인지 알 수 없다는 에러 발생. 아래에 빠르게 고치는 방법 제시하고 있음.
		// 2. import를 사용하여 접근 (더 많이 사용)
		A_Variable av = new A_Variable();
		//             ------------------ -> 이 부분은 클래스에 대한 알맹이를 만드는 부분. 알맹이가 있어야 조작/사용 가능. 알맹이를 av라는 변수에 담아두고 있는 것.
		
		// 클래스 안에 있는 메소드에 접근
//		av.declareVariable(); // av 변수 안에 있는 메소드 실행
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
