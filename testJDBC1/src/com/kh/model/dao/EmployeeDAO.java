package com.kh.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Employee;

public class EmployeeDAO {
// DB�� ���������� ����Ǵ� ���� => DB�� ���� �ʿ�
	
	// finally���� �ݾ��ֱ� ���� try �ܺο� ����
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	
	// ������ ���� ������ ��
	ArrayList<Employee> list = null;
	
	public ArrayList<Employee> selectAll() {
		try {
			// 1. DB�� ���� Driver ��� : Class.forName("JDBC ����̹�");
			// DBMS ������ ���� ����̹��� �޶���. �Ʒ��� ����Ŭ�� ���� ����̹�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Driver�� ����ϸ� DriverManager�� �� �� �ְ� ��
			
			// 2. �����ͺ��̽� ���� �۾�
			// DriverManager : Connection�� ������ֱ� ���� Ŭ����
			// 		DriverManager.getConnection(String url, String user, String password):Connection
			//			Ư�� DB�� ����� Connection�� ��ȯ�ϴ� �޼ҵ�
			//				url : ��� ��ǻ�� DB�� ������ ������
			//				user : ������ ���� �̸�
			// 				password : ������ ���� ��й�ȣ
			// Connection : DB�� ����� ���� ������ ��
			// DriverManager : �̱�������
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
														  "SCOTT", "SCOTT"); 
			// jdbc:oracle:thin: 		jdbc ����̹��� thinŸ����
			// @127.0.0.1				������ �����ͺ��̽��� �� ��ǻ�Ϳ� ����(�� ��ǻ�Ϳ� ���� ip�ּ�)
			// 1521:xe					��Ʈ��ȣ�� xe Ÿ���̴ٶ�� ��
			
			// 3. ���� �ۼ� �� ���� ����
			// 4. ���� ��� �� �޾ƿ���
			String query = "SELECT * FROM EMP"; // ������ ������ DB���� �˾Ƽ� �����ݷ��� �ٿ��ֱ� ������ �������� �����ݷ��� �� �ٿ��� ������ ��
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query); // ������ ���� �� ����� ResultSet���� �Ѿ��
			
			// 5. �޾ƿ� ��� �� ��ȯ
//			System.out.println(rset); // �̷��� ����ϸ� ��� : oracle.jdbc.driver.ForwardOnlyResultSet@b7f23d9 -> ��ȯ���� �������� ��
			
			// ResultSet �ȿ� ���� ��(0~n��)�� ���� �� ���� ���ɼ��� �ִٸ� while������ ���� : ���� ���� �ִ��� ������(���� ������ �𸣱� ������ �� �� �ݺ����� ��)
			// ��ȸ��
		
			// ResultSet �ȿ� �� ��(0~1��)�� �ุ �� ���� ���ɼ��� �ִٸ� if������ ���� : ���� �ִ��� ������(�� �� ���� ������ ���� ��)
			// 1ȸ��
			list = new ArrayList<>(); // Ÿ�� �߷� : jdk 1.6 �̻���� �޺κ� ���׸� ���� ����. �տ� �� ���׸��� ����.
			
			while(rset.next()) { // next():boolean ���� ���� �����Ѵٸ� true ��ȯ
				int empNo = rset.getInt("EMPNO");
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
				// ���� ������ SELECT ��� ResultSet�� �÷����� ������ ���� ����, �ش� ���̺��� �÷����� �״�� ������ ���°��� �ƴ�
				
				Employee emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
				list.add(emp);
			}
			
//			for(Employee e : list) { // �� ��µǴ��� Ȯ�� -> ����� View���� �ؾ� �ϱ� ������ ���⿡�� �ϸ� �� ��
//				System.out.println(e);
//			}
			
			// 6. �ڿ� �ݳ� -> ������ ���� �� � ��Ȳ�� �������� �� ����� ��
			// ���� ������ �ƴ϶� �Ųٷ� �ݾ� ��� �� (ResultSet -> Statement -> Connection)
			// ���� �� �Ʒ��� ������ ������ ���� ��� close���� �������� ���� �� ���� -> finally �������� close ����� ��
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. �ڿ� �ݳ�
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public Employee selectEmployee(int empNo) {
		Connection conn = null;
//		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		Employee emp = null;
		
		try {
			// 1. DB�� ���� Driver ��� : Class.forName()
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			// Driver�� �߸� �ԷµǾ��ų� �ش� ����̹��� ������ ���� ���� JARs ������ ���� �� ����̹��� ������ �� �� ���� ��Ȳ�� ���� ClassNotFoundException ����ó��
			
			// 2.DB�� ���� : DriverManager�� ���� Connection ��ü ����
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			// @127.0.0.1�� @localhost�� ���� ������ ��(�� ��ǻ�Ϳ� ����)
			
			// 3. query �ۼ� �� ����
//			String query = "SELECT * FROM EMP WHERE EMPNO = ?"; // ������ ������ �߻� : PreparedStatement ����ϴ� ���� �̵�, ��ġȦ�� ? ���
//			// ��ġȦ���� ���� ��� �־ �Ϻ��� ������ �ƴϱ� ������ �ϼ�������� ��
//			pstmt = conn.prepareStatement(query);
//			// ���� �ϼ��� ���� ��ġȦ���� �� �߰�
//			// setInt(parameterIndex, x):void
//			// 		parameterIndex : ��ġȦ�� �ڸ� ��ȣ(1, 2, 3...)
//			//      x : ������ �� 
//			pstmt.setInt(1, empNo);
//			rset = pstmt.executeQuery();
			
			// Statement ����
			String query = "SELECT * FROM EMP WHERE EMPNO = " + empNo; // ��ġȦ���� ������� �ʰ� ���� ������ �޾ƿ���
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			// 4. ��� �� ��ȯ : ResultSet �ȿ��� �ִ� 1���� ���� �� ���� ���̹Ƿ� if ���
			if(rset.next()) {
//				int empNo = rset.getInt("empno"); // ���� �޾Ƽ� ������� �ʰ� �Ű������� �޾ƿ� empNo�� ��ü ����ص� ��
				// �÷����� ��ҹ��ڸ� �������� �ʱ� ������ �ҹ��ڷ� �ᵵ ��
				String empName = rset.getString("ename");
				String job = rset.getString("job");
				int mgr = rset.getInt("mgr");
				Date hireDate = rset.getDate("hiredate");
				int sal = rset.getInt("sal");
				int comm = rset.getInt("comm");
				int deptNo = rset.getInt("deptno");
				
				emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
			}
			
			// 5. �ڿ� �ݳ� �� ������ ��ȯ
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// try~with~resource�� ����� ���������� DB�� ����� �κп� ���ؼ��� ���� close�ϴ� ���� ������
			try {
				rset.close();
//				pstmt.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
	}

	public int insertEmployee(Employee emp) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			conn.setAutoCommit(false); // �ڵ� Ŀ������ �� ��� ������ �߻��ϱ� ������ �ڵ� Ŀ���� ���� �ʵ��� ��������
			
			String query = "INSERT INTO EMP VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)";
			// Statement�� ����ϴ� ��� 
			// String query = "INSERT INTO EMP VALUES(" + emp.getEmpNo() + ", "... ���·� ��� ����� ��
			// ������ ���� �ʹ� ������ ��ġȦ���� ����ϴ� ���� ����
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setInt(5, emp.getSal());
			pstmt.setInt(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptNo());
			
			// ������ SELECT�̸� - executeQuery() : ResultSet
			// ������ DML�̸�(INSERT, UPDATE, DELETE) - executeUpdate() : int
			// Oracle���� INSERT ������ �����ϸ� 1 ����(��) ���ԵǾ����ϴٶ�� ��
			//                           -- -> �� ���� �࿡ ���ؼ� ����/����/���� �ߴ��� ��ȯ��
			// INSERT�� ����� �� �� ��� ��ȯ���� 0 ����
			// DML(INSERT, UPDATE, DELETE)�� ������ ���Ŀ��� Ʈ������(COMMIT, ROLLBACK)�� �Ϸ��Ͽ��� �Ϸ�� ����
			result = pstmt.executeUpdate();
			
			if(result > 0) { // ������ �ùٸ��� ����� ���
				conn.commit();
			} else { // �ùٸ��� ������� ���� ���
				conn.rollback();
				// commit, rollback �� �� SQLException �����ϰ� ����
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result; // ����/���� ���θ� �˷��ֱ� ���� return �ʿ�
	}

	public int updateEmployee(Employee e) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "SCOTT", "SCOTT");
			conn.setAutoCommit(false);
			
			String query = "UPDATE EMP SET JOB = ?, SAL = ?, COMM = ? WHERE EMPNO = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, e.getJob());
			pstmt.setInt(2, e.getSal());
			pstmt.setInt(3, e.getComm());
			pstmt.setInt(4, e.getEmpNo());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e1) { 
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return result;
	}

	public int deleteEmployee(int empNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			conn.setAutoCommit(false);
			
			String query = "DELETE FROM EMP WHERE EMPNO = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empNo);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	

}
