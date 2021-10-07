package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Member;

public class MemberDAO {
	
	private Properties prop = null;
	
	public MemberDAO() {
		// MemberDAO 객체가 생성될 때 파일을 읽어옴
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Connection conn, Member mem) {
		/*
		  	이전 프로젝트에서 DAO가 맡은 업무
		  		1) JDBC 드라이버 등록
		  		2) DB 연결 Connection 객체 생성
		  		3) SQL 실행
		  		4) 트랜잭션 처리
		  		5) 자원 반납
		  		
		  	--> 사실 DAO는 SQL문을 DB로 전달하고 전달 후 나온 결과값을 반환받는 일만 진행해야 함(3번 업무)
		  	         그런데 하지 않아도 되는 1, 2, 4, 5까지 하고 있었음
		  	--> 1, 2, 4, 5 역할을 분리
		  		--> 위 업무들은 공통적인 업무이기 때문에 한 번에 묶어서 처리 : JDBCTemplate 
		 */
		
		// DAO는 SQL을 전달만 하는 부분이기 때문에 JDBCTemplate을 불러오면 안 됨 (JDBCTemplate을 불러오게 되면 Connection 객체를 생성하는 것과 같은 상황이 됨 => 원하는 것 x)
		// -> 서비스에서 불러옴
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
//			String query = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			String query = prop.getProperty("insertMember"); // 프로퍼티 파일로 쿼리 삽입
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPwd());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, mem.getGender()+""); // getChar는 없음
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getPhone());
			pstmt.setString(7, mem.getAddress());
			pstmt.setInt(8, mem.getAge());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			JDBCTemplate.close(pstmt); // 너무 길면 위에 import 하고 생략 가능
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Member> selectAll(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
				
		try {
			String query = prop.getProperty("selectAll");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Member>();
			
			while(rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				int age = rset.getInt("AGE");
				String address = rset.getString("ADDRESS");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				Member mem = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address, enrollDate);
				
				list.add(mem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
		
	}

	public ArrayList<Member> selectMemberId(String id, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		
//		Statement stmt = null;
		
		try {
			String query = prop.getProperty("selectMemberId");
			pstmt = conn.prepareStatement(query);
			// query에 like가 들어갔다는 이야기는 부분만 일치해도 가져오겠다는 이야기
			// 다시 말하면 내가 원하는 데이터에 %나 _와 같은 와일드카드가 있어야 함
			// 따라서 123번째 줄을 id라고만 넣는 것이 아니라 바꿔야 됨
			pstmt.setString(1, "%" + id + "%");
			rset = pstmt.executeQuery();
			list = new ArrayList<Member>();
			
			// Statement 버전
//			String query = prop.getProperty("selectMemberId") + "'%" + id + "%'";
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
			// 원래 쿼리에서 LIKE를 쓰고자 할 경우 위와 같이(line 138) ' ' 안에 검색하고자 하는 데이터를 넣어줌
			//		ex. SELECT * FROM MEMBER WHERE MEMBER_ID LIKE '%연%';
			// Statememt를 사용할 때는 위와 같이 ''를 사용하지만 PreparedStatement를 사용할때는 그렇지 않음
			// 그 이유는 PreparedStatement는 ?(위치홀더) 자리에 데이터가 들어가면 자동으로 그 데이터를 ''로 감싸주기 때문에 없어도 됨 -> 위치홀더 유무의 차이
			
			while(rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				int age = rset.getInt("AGE");
				String address = rset.getString("ADDRESS");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				Member m = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address, enrollDate);
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
//			close(stmt);
		}
		
		return list;
	}

	public ArrayList<Member> selectGender(char gender, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		
		try {
			String query = prop.getProperty("selectGender");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gender+"");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Member>();
			
			while(rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				int age = rset.getInt("AGE");
				String address = rset.getString("ADDRESS");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				Member m = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address, enrollDate);
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int checkMember(String memberId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0; // DML은 int를 사용하고, SELECT는 ArrayList를 사용하라고 정해진 것이 아님. SELECT를 뭘 할 것이냐에 따라 다름
		 
		try {
			String query = prop.getProperty("checkMember");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery(); // rset에 들어갈 수 있는 결과값(행의 개수)은 무조건 1개
			// COUNT(*)를 사용하면 아이디가 있든 없든 하나의 행이 출력되고 해당 행에 담긴 값만 달라짐(0 또는 1의 값)
			// 따라서 ResultSet에 담겨지는 결과는 무조건 1개
			
			if(rset.next()) {
//				result = rset.getInt("count(*)");
//				rset.getInt(columnLabel); --> 컬럼의 이름으로 가지고 옴
//				rset.getInt(columnIndex); --> 컬럼의 순번으로도 가지고 올 수 있음
				result = rset.getInt(1);
				// 컬럼명으로 쓰는 것이 더 직관적
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int updateMember(String memberId, String input, int sel, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = prop.getProperty("updateMember");
		
		// UPDATE MEMBER SET ? = ? WHERE MEMBER_ID = ?
//		String col = null;
//		switch(sel) {
//		case 1: col = "member_pwd"; break;
//		case 2: col = "email"; break;
//		case 3: col = "phone"; break;
//		case 4: col = "address"; break;
//		}
		// 위와 같이 나눈 후 쿼리에 삽입하면(pstmt.setString(1,col);) ' '이 같이 들어감
		// ex. 1번 선택 -> 비밀번호 변경
		// UPDATE MEMBER SET 'member_pwd' = '123' WHERE MEMBER_ID = 'USER01'이라는 쿼리가 만들어지게 됨
		// => member_pwd를 컬럼으로 인지하지 못함 (효율은 좋으나 치명적인 단점으로 작용) 따라서 쿼리를 쪼개야 됨(쿼리 분리/구분을 위해 sel을 가지고 온 것)
		// updateMember1~4로 쿼리를 쪼개서 프로퍼티에 작성
		
		try {
			String query = prop.getProperty("updateMember" + sel);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, input);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(String memberId, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String query = prop.getProperty("deleteMember");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}
