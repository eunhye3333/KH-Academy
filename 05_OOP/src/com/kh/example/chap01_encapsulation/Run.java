package com.kh.example.chap01_encapsulation;

public class Run {
	public static void main(String[] args) {
		Account a = new Account();
		
		a.displayBalance(); // �ƹ��͵� �������� �ʾұ� ������ �ƹ��͵� ���� �� ����
		
		a.deposit(1000000); // int money�� �޾ƿ´ٰ� �߱� ������ money�� ������ ��� ��.
		// money�� ���ǵ� �ڷ���, ������ �°� �־���� ��
		a.displayBalance();
		
		a.deposit(1500000);
		a.displayBalance();
		
		a.withdraw(500000);
		a.displayBalance();
		
//		a.balance -= 5000000; // ����� �ƴ϶� �����Ϳ� ����
//		������ private���� �ٲٸ� ���� �Ұ������� (The field Account.balance is not visible)
//		����ȭ �Ǿ��� ������ ������ �ʰ� �� (�ۿ����� �� �� ����)
//		
//		a.withdraw(100000);
//		a.displayBalance(); // �ݾ��� ���̳ʽ��� �� -> �ܺο��� �� �����Ϳ� ���� ������ �� ���� �ؾ� �� => ĸ��ȭ
		
		a.withdraw(100000);
		a.displayBalance(); // �ܾ��� �������� �ʰ� ��
	}
}
