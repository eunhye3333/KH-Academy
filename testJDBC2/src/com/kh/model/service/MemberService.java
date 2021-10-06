package com.kh.model.service;

import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.rollback;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

//import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberService {
	// Controller -> Service (Connection 객체 생성) -> DAO (Connection 객체를 가지고 DAO로 넘어감)
	private MemberDAO mDAO = new MemberDAO();
	
	public int insertMember(Member mem) {
//		Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		// 실제로 Connection이 필요한 곳은 DAO -> DAO에게 Connection을 넘겨줌
		
		int result = mDAO.insertMember(conn, mem);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public ArrayList<Member> selectAll() {
		Connection conn = getConnection();
		
		ArrayList<Member> list = mDAO.selectAll(conn);
		
		return list;
	}

	public ArrayList<Member> selectMemberId(String id) {
		Connection conn = getConnection();
		
		ArrayList<Member> list = mDAO.selectMemberId(id, conn);
		
		return list;
	}

	public ArrayList<Member> selectGender(char gender) {
		Connection conn = getConnection();
		
		ArrayList<Member> list = mDAO.selectGender(gender, conn);
		
		return list;
	}
	
	
	
	
	
	
	
}
