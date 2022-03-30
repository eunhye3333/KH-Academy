package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.EmployeeDAO;
import com.kh.model.vo.Employee;
import com.kh.view.Menu;

public class EmployeeController {
// Controller : View�� Model�� �����ϴ� ����, �Ѱܹ��� �����͸� �����ϴ� ����
	private Menu menu = new Menu();
	private EmployeeDAO empDAO = new EmployeeDAO();
	
	public void selectAll() {
		// ��ü �����͸� �ҷ����� �Ǳ� ������ ������ ������ �ʿ䰡 ����
		// �ٷ� DAO�� �Ѿ�� ��
		ArrayList<Employee> list = empDAO.selectAll();

		// ��Ʈ�ѷ��� ���� : ����� ���� �並 ��� 
		if(!list.isEmpty()) {
			// list �ȿ� ����� �����Ͱ� �ִٸ� ��ȸ ����� ����ϴ� view�� �̵�
			menu.selectAll(list);
		} else {
			// list �ȿ� ����� �����Ͱ� ���ٸ� ������ ���� view�� �̵�
			menu.displayError("��ȸ����� �����ϴ�.");
		}
		
	}

	public void selectEmployee() {
		// ����� �ޱ� ���� view�� ����
		int empNo = menu.selectEmpNo();
		
		// ������ ��ȸ�� ���� DAO�� �̵�
		Employee emp = empDAO.selectEmployee(empNo);
		
		// ����� ���� ���� �б�
		if(emp != null) {
			menu.selectEmployee(emp);
		} else {
			menu.displayError("�ش� ����� ���� ����� �����ϴ�.");
		}
	}

	public void insertEmployee() {
		// ��� ������ �ޱ� ���� view�� �̵�
		Employee emp = menu.insertEmployee();
		
		int result = empDAO.insertEmployee(emp);
		
		if(result > 0) {
			menu.displaySuccess(result + "���� ���� �߰��Ǿ����ϴ�.");
		} else {
			menu.displayError("������ ���� ���� �� ���� �߻�");
		}
	}

	public void updateEmployee() {
		int empNo = menu.selectEmpNo();
		
		Employee e = menu.updateEmployee();
		e.setEmpNo(empNo); // ������ �������� �˾ƾ� �ϱ� ������ empNo�� ���� �ѱ�
		
		int result = empDAO.updateEmployee(e);
		
		if(result > 0) {
			menu.displaySuccess(result + "���� ���� �����Ǿ����ϴ�.");
		} else {
			menu.displayError("������ ���� ���� �� ���� �߻�");
		}
	}

	public void deleteEmployee() {
		int empNo = menu.selectEmpNo();
		
		char check = menu.deleteEmployee();
		
		if(check == 'y') {
			int result = empDAO.deleteEmployee(empNo);
			
			if(result > 0) {
				menu.displaySuccess(result + "���� ���� �����Ǿ����ϴ�.");
			} else {
				menu.displayError("������ ���� ���� �� ���� �߻�");
			}
			
		} else if (check == 'n') {
			menu.displayError("��� ���� ���� ���");
		} else {
			menu.displayError("�߸� �Է��ϼ̽��ϴ�.(y �Ǵ� n �Է�)");
		}
	}
	
}
