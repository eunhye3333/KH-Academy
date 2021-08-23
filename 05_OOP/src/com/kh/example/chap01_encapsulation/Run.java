package com.kh.example.chap01_encapsulation;

public class Run {
	public static void main(String[] args) {
		Account a = new Account();
		
		a.displayBalance(); // 아무것도 정의하지 않았기 때문에 아무것도 넣을 수 없음
		
		a.deposit(1000000); // int money를 받아온다고 했기 때문에 money를 전달해 줘야 함.
		// money가 정의된 자료형, 개수에 맞게 넣어줘야 함
		a.displayBalance();
		
		a.deposit(1500000);
		a.displayBalance();
		
		a.withdraw(500000);
		a.displayBalance();
		
//		a.balance -= 5000000; // 기능이 아니라 데이터에 접근
//		변수를 private으로 바꾸면 접근 불가능해짐 (The field Account.balance is not visible)
//		은닉화 되었기 때문에 보이지 않게 됨 (밖에서는 볼 수 없음)
//		
//		a.withdraw(100000);
//		a.displayBalance(); // 금액이 마이너스가 됨 -> 외부에서 내 데이터에 직접 접근할 수 없게 해야 함 => 캡슐화
		
		a.withdraw(100000);
		a.displayBalance(); // 잔액이 부족하지 않게 됨
	}
}
