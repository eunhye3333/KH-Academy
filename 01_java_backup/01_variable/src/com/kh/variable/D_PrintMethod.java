package com.kh.variable;

public class D_PrintMethod {
	public void printlnExample() {
		String str1 = "�ȳ��ϼ���";
		String str2 = "�ݰ����ϴ�";
		System.out.println(str1); // �ٹٲ��� �߰��� ��¹�. �ȳ��ϼ���+enter����
		System.out.println(str2); // �ٹٲ��� �� �Ǹ� �� ���� �ֵ��� �ٷ� �ڿ� ����. Ŀ���� �ٹٲ����� ������ �������� ������ �Ʒ��� ��µ�
		System.out.println(); // �ƹ��͵� ������� �ʴ´ٰ� �ص� �ٹٲ��� ��µǱ� ������ �̰� ��ü�� ��� ���� (�ٹٲ��� �ϰ� ���� ��� ���)
	}
	
	public void printExample() {
		String str1 = "�ȳ��ϼ���";
		String str2 = "�ݰ����ϴ�";
		System.out.print(str1);
		System.out.print(str2); // �ٹٲ��� ���� �ʾ� ����Ű�� �Űܵ� ������ �������� ����
//		System.out.print(); �ƹ��͵� ���� ������ �ƹ��͵� ��µ��� �ʱ� ������ �̰͸� ����ϸ� ������ ��. println�� �ٸ�
		// printf�� �ٸ��� �ٹٲ��� �ϰ� ���� ���� \n�� ��� ����. %n�� printf������ ��� ����.
	}
	
	public void printfExample() {
		String str1 = "�ȳ��ϼ���";
		String str2 = "�ݰ����ϴ�";
		
		// System.out.printf(format, args)
		//                   format : ����
		//                   args : ���Ŀ� �� ������
		
		// �ȳ��ϼ���, �ڽſ��Դϴ�. �ݰ����ϴ�. -> ���
		System.out.printf("%s, �ڽſ��Դϴ�. %s.\n", str1, str2);
		//                str1          str2
		
		// �ݰ����ϴ�, ģ�ϰ� ������.
		System.out.printf("%s, ģ�ϰ� ������.", str2); // ���� ���� �ſ� �ٷ� �ٿ��� ����. �ٹٲ��� ���� �ʱ� ������.
		
		System.out.println();
		
		int age = 20; 
		String name = "�ڽſ�";
		String job = "����";
		// �ȳ��ϼ���, ���� 20�� �ڽſ� �����Դϴ�. ������ �ݰ����ϴ�.
		System.out.printf("%s, ���� %d�� %s %s�Դϴ�. ������ %s.%n", str1, age, name, job, str2);
		
		System.out.printf("%s, ���� %s�� %s %s�Դϴ�. ������ %s.", str1, age, name, job, str2);
		// age�� int�� �ް� �ֱ� ������ %d�� ����ؾ� �Ѵ�. ������ %s�� �ص� ����� ��. (���ڰ� �ƴ� ���� 20���� �ν�)
		// �ٹٲ��� ���ְ� ������ println�� ���� �ʰ� %n or \n�� ������ �ٹٲ��� ��
		// %n�� �ٹٲ� �������� printf������ ��� ������ �ٹٲ���
	}
}
