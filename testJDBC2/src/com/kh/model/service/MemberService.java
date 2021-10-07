package com.kh.model.service;

import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.rollback;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.ArrayList;

//import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

public class MemberService {
	// Controller -> Service (Connection ��ü ����) -> DAO (Connection ��ü�� ������ DAO�� �Ѿ)
	private MemberDAO mDAO = new MemberDAO();
	
	public int insertMember(Member mem) {
//		Connection conn = JDBCTemplate.getConnection();
		Connection conn = getConnection();
		// ������ Connection�� �ʿ��� ���� DAO -> DAO���� Connection�� �Ѱ���
		
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

	public int checkMember(String memberId) {
		Connection conn = getConnection();
		
		int result = mDAO.checkMember(memberId, conn);
		
		return result;
	}

	public int updateMember(String memberId, String input, int sel) {
		Connection conn = getConnection();
		
		int result = mDAO.updateMember(memberId, input, sel, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public void exitProgram() {
		Connection conn = getConnection();
		close(conn);
	}

	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		
		int result = mDAO.deleteMember(memberId, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
}
