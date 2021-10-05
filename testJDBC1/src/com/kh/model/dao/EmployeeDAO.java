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
// DB와 직접적으로 연결되는 역할 => DB와 연결 필요
	
	// finally에서 닫아주기 위해 try 외부에 선언
	Connection conn = null;
	Statement stmt = null;
	ResultSet rset = null;
	
	// 리턴을 위해 밖으로 뺌
	ArrayList<Employee> list = null;
	
	public ArrayList<Employee> selectAll() {
		try {
			// 1. DB에 대한 Driver 등록 : Class.forName("JDBC 드라이버");
			// DBMS 종류에 따라 드라이버가 달라짐. 아래는 오라클에 대한 드라이버
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Driver를 등록하면 DriverManager를 쓸 수 있게 됨
			
			// 2. 데이터베이스 연결 작업
			// DriverManager : Connection을 만들어주기 위한 클래스
			// 		DriverManager.getConnection(String url, String user, String password):Connection
			//			특정 DB에 연결된 Connection을 반환하는 메소드
			//				url : 어느 컴퓨터 DB에 연결할 것인지
			//				user : 연결할 계정 이름
			// 				password : 연결할 계정 비밀번호
			// Connection : DB와 연결된 길의 역할을 함
			// DriverManager : 싱글톤패턴
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe",
														  "SCOTT", "SCOTT"); 
			// jdbc:oracle:thin: 		jdbc 드라이버가 thin타입임
			// @127.0.0.1				접근할 데이터베이스가 내 컴퓨터에 있음(내 컴퓨터에 대한 ip주소)
			// 1521:xe					포트번호와 xe 타입이다라는 뜻
			
			// 3. 쿼리 작성 및 쿼리 전송
			// 4. 쿼리 결과 값 받아오기
			String query = "SELECT * FROM EMP"; // 쿼리를 보내면 DB에서 알아서 세미콜론을 붙여주기 때문에 쿼리에는 세미콜론을 안 붙여서 보내도 됨
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query); // 쿼리를 보낸 후 결과가 ResultSet으로 넘어옴
			
			// 5. 받아온 결과 값 변환
//			System.out.println(rset); // 이렇게 출력하면 결과 : oracle.jdbc.driver.ForwardOnlyResultSet@b7f23d9 -> 변환시켜 출력해줘야 함
			
			// ResultSet 안에 여러 개(0~n개)의 행이 들어가 있을 가능성이 있다면 while문으로 진행 : 다음 값이 있느냐 없느냐(행의 개수를 모르기 때문에 몇 번 반복할지 모름)
			// 다회성
		
			// ResultSet 안에 한 개(0~1개)의 행만 들어가 있을 가능성이 있다면 if문으로 진행 : 행이 있느냐 없느냐(딱 한 번만 가지고 오면 됨)
			// 1회성
			list = new ArrayList<>(); // 타입 추론 : jdk 1.6 이상부터 뒷부분 제네릭 생략 가능. 앞에 쓴 제네릭을 따라감.
			
			while(rset.next()) { // next():boolean 다음 행이 존재한다면 true 반환
				int empNo = rset.getInt("EMPNO");
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
				// 위의 내용은 SELECT 결과 ResultSet의 컬럼명을 가지고 오는 것임, 해당 테이블의 컬럼명을 그대로 가지고 오는것이 아님
				
				Employee emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
				list.add(emp);
			}
			
//			for(Employee e : list) { // 잘 출력되는지 확인 -> 출력은 View에서 해야 하기 때문에 여기에서 하면 안 됨
//				System.out.println(e);
//			}
			
			// 6. 자원 반납 -> 에러가 나는 등 어떤 상황이 벌어져도 꼭 해줘야 함
			// 열린 순서가 아니라 거꾸로 닫아 줘야 함 (ResultSet -> Statement -> Connection)
			// 따라서 이 아래에 있으면 에러가 나는 경우 close까지 도달하지 않을 수 있음 -> finally 구문에서 close 해줘야 함
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 자원 반납
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
			// 1. DB에 대한 Driver 등록 : Class.forName()
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			// Driver가 잘못 입력되었거나 해당 드라이버를 가지고 오기 위한 JARs 파일이 없는 등 드라이버를 가지고 올 수 없는 상황을 위해 ClassNotFoundException 예외처리
			
			// 2.DB와 연결 : DriverManager를 통해 Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			// @127.0.0.1과 @localhost는 같은 역할을 함(내 컴퓨터에 접속)
			
			// 3. query 작성 및 전송
//			String query = "SELECT * FROM EMP WHERE EMPNO = ?"; // 동적인 데이터 발생 : PreparedStatement 사용하는 것이 이득, 위치홀더 ? 사용
//			// 위치홀더로 값이 비어 있어서 완벽한 쿼리가 아니기 때문에 완성시켜줘야 함
//			pstmt = conn.prepareStatement(query);
//			// 쿼리 완성을 위해 위치홀더에 값 추가
//			// setInt(parameterIndex, x):void
//			// 		parameterIndex : 위치홀더 자리 번호(1, 2, 3...)
//			//      x : 세팅할 값 
//			pstmt.setInt(1, empNo);
//			rset = pstmt.executeQuery();
			
			// Statement 버전
			String query = "SELECT * FROM EMP WHERE EMPNO = " + empNo; // 위치홀더를 사용하지 않고 동적 데이터 받아오기
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			// 4. 결과 값 변환 : ResultSet 안에는 최대 1개의 행이 들어가 있을 것이므로 if 사용
			if(rset.next()) {
//				int empNo = rset.getInt("empno"); // 새로 받아서 사용하지 않고 매개변수로 받아온 empNo로 대체 사용해도 됨
				// 컬럼명은 대소문자를 구분하지 않기 때문에 소문자로 써도 됨
				String empName = rset.getString("ename");
				String job = rset.getString("job");
				int mgr = rset.getInt("mgr");
				Date hireDate = rset.getDate("hiredate");
				int sal = rset.getInt("sal");
				int comm = rset.getInt("comm");
				int deptNo = rset.getInt("deptno");
				
				emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
			}
			
			// 5. 자원 반납 및 데이터 반환
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// try~with~resource도 사용이 가능하지만 DB와 연결된 부분에 대해서는 직접 close하는 것을 권장함
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
			conn.setAutoCommit(false); // 자동 커밋으로 할 경우 오류가 발생하기 때문에 자동 커밋을 하지 않도록 설정해줌
			
			String query = "INSERT INTO EMP VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)";
			// Statement를 사용하는 경우 
			// String query = "INSERT INTO EMP VALUES(" + emp.getEmpNo() + ", "... 형태로 계속 써줘야 함
			// 동적인 값이 너무 많으면 위치홀더를 사용하는 것이 나음
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setInt(5, emp.getSal());
			pstmt.setInt(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptNo());
			
			// 쿼리가 SELECT이면 - executeQuery() : ResultSet
			// 쿼리가 DML이면(INSERT, UPDATE, DELETE) - executeUpdate() : int
			// Oracle에서 INSERT 쿼리를 실행하면 1 행이(가) 삽입되었습니다라고 뜸
			//                           -- -> 몇 개의 행에 대해서 삽입/수정/삭제 했는지 반환함
			// INSERT가 제대로 안 된 경우 반환값이 0 이하
			// DML(INSERT, UPDATE, DELETE)을 진행한 이후에는 트랜젝션(COMMIT, ROLLBACK)을 완료하여야 완료된 것임
			result = pstmt.executeUpdate();
			
			if(result > 0) { // 쿼리가 올바르게 실행된 경우
				conn.commit();
			} else { // 올바르게 실행되지 않은 경우
				conn.rollback();
				// commit, rollback 둘 다 SQLException 위임하고 있음
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
		
		return result; // 성공/실패 여부를 알려주기 위해 return 필요
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
