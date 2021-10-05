package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.dao.EmployeeDAO;
import com.kh.model.vo.Employee;
import com.kh.view.Menu;

public class EmployeeController {
// Controller : View와 Model을 연결하는 역할, 넘겨받은 데이터를 가공하는 역할
	private Menu menu = new Menu();
	private EmployeeDAO empDAO = new EmployeeDAO();
	
	public void selectAll() {
		// 전체 데이터를 불러오면 되기 때문에 데이터 가공이 필요가 없음
		// 바로 DAO로 넘어가면 됨
		ArrayList<Employee> list = empDAO.selectAll();

		// 컨트롤러의 역할 : 결과에 따라 뷰를 띄움 
		if(!list.isEmpty()) {
			// list 안에 저장된 데이터가 있다면 조회 결과를 출력하는 view로 이동
			menu.selectAll(list);
		} else {
			// list 안에 저장된 데이터가 없다면 에러를 띄우는 view로 이동
			menu.displayError("조회결과가 없습니다.");
		}
		
	}

	public void selectEmployee() {
		// 사번을 받기 위해 view로 이종
		int empNo = menu.selectEmpNo();
		
		// 데이터 조회를 위해 DAO로 이동
		Employee emp = empDAO.selectEmployee(empNo);
		
		// 결과에 따라 조건 분기
		if(emp != null) {
			menu.selectEmployee(emp);
		} else {
			menu.displayError("해당 사번에 대한 결과가 없습니다.");
		}
	}

	public void insertEmployee() {
		// 사원 정보를 받기 위해 view로 이동
		Employee emp = menu.insertEmployee();
		
		int result = empDAO.insertEmployee(emp);
		
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 추가되었습니다.");
		} else {
			menu.displayError("데이터 삽입 과정 중 오류 발생");
		}
	}

	public void updateEmployee() {
		int empNo = menu.selectEmpNo();
		
		Employee e = menu.updateEmployee();
		e.setEmpNo(empNo); // 누구를 수정할지 알아야 하기 때문에 empNo도 같이 넘김
		
		int result = empDAO.updateEmployee(e);
		
		if(result > 0) {
			menu.displaySuccess(result + "개의 행이 수정되었습니다.");
		} else {
			menu.displayError("데이터 수정 과정 중 오류 발생");
		}
	}

	public void deleteEmployee() {
		int empNo = menu.selectEmpNo();
		
		char check = menu.deleteEmployee();
		
		if(check == 'y') {
			int result = empDAO.deleteEmployee(empNo);
			
			if(result > 0) {
				menu.displaySuccess(result + "개의 행이 삭제되었습니다.");
			} else {
				menu.displayError("데이터 삭제 과정 중 오류 발생");
			}
			
		} else if (check == 'n') {
			menu.displayError("사원 정보 삭제 취소");
		} else {
			menu.displayError("잘못 입력하셨습니다.(y 또는 n 입력)");
		}
	}
	
}
