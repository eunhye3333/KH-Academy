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
		// MemberDAO ��ü�� ������ �� ������ �о��
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
		  	���� ������Ʈ���� DAO�� ���� ����
		  		1) JDBC ����̹� ���
		  		2) DB ���� Connection ��ü ����
		  		3) SQL ����
		  		4) Ʈ����� ó��
		  		5) �ڿ� �ݳ�
		  		
		  	--> ��� DAO�� SQL���� DB�� �����ϰ� ���� �� ���� ������� ��ȯ�޴� �ϸ� �����ؾ� ��(3�� ����)
		  	         �׷��� ���� �ʾƵ� �Ǵ� 1, 2, 4, 5���� �ϰ� �־���
		  	--> 1, 2, 4, 5 ������ �и�
		  		--> �� �������� �������� �����̱� ������ �� ���� ��� ó�� : JDBCTemplate 
		 */
		
		// DAO�� SQL�� ���޸� �ϴ� �κ��̱� ������ JDBCTemplate�� �ҷ����� �� �� (JDBCTemplate�� �ҷ����� �Ǹ� Connection ��ü�� �����ϴ� �Ͱ� ���� ��Ȳ�� �� => ���ϴ� �� x)
		// -> ���񽺿��� �ҷ���
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
//			String query = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			String query = prop.getProperty("insertMember"); // ������Ƽ ���Ϸ� ���� ����
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPwd());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, mem.getGender()+""); // getChar�� ����
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getPhone());
			pstmt.setString(7, mem.getAddress());
			pstmt.setInt(8, mem.getAge());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			JDBCTemplate.close(pstmt); // �ʹ� ��� ���� import �ϰ� ���� ����
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
			// query�� like�� ���ٴ� �̾߱�� �κи� ��ġ�ص� �������ڴٴ� �̾߱�
			// �ٽ� ���ϸ� ���� ���ϴ� �����Ϳ� %�� _�� ���� ���ϵ�ī�尡 �־�� ��
			// ���� 123��° ���� id��� �ִ� ���� �ƴ϶� �ٲ�� ��
			pstmt.setString(1, "%" + id + "%");
			rset = pstmt.executeQuery();
			list = new ArrayList<Member>();
			
			// Statement ����
//			String query = prop.getProperty("selectMemberId") + "'%" + id + "%'";
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
			// ���� �������� LIKE�� ������ �� ��� ���� ����(line 138) ' ' �ȿ� �˻��ϰ��� �ϴ� �����͸� �־���
			//		ex. SELECT * FROM MEMBER WHERE MEMBER_ID LIKE '%��%';
			// Statememt�� ����� ���� ���� ���� ''�� ��������� PreparedStatement�� ����Ҷ��� �׷��� ����
			// �� ������ PreparedStatement�� ?(��ġȦ��) �ڸ��� �����Ͱ� ���� �ڵ����� �� �����͸� ''�� �����ֱ� ������ ��� �� -> ��ġȦ�� ������ ����
			
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
	
}
