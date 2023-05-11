package com.kh.model.service;

import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.rollback;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.ArrayList;

//import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDAO;

public class MemberService {
	private MemberDAO mDAO = new MemberDAO();
	
	public int insertMember() {
		Connection conn = getConnection();
		
		int result = mDAO.insertMember(conn);
		
		if(result >= 380) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public ArrayList<String> selectMember() {
		Connection conn = getConnection();
		
		ArrayList<String> result = mDAO.selectMember(conn);
		
		
		return result;
	}
	
	public void updateMember() {
		Connection conn = getConnection();
		
		ArrayList<String> mem = selectMember();
		int result = mDAO.updateMember(conn, mem);
		
		if(result >= mem.size()) {
			commit(conn);
			System.out.println("성공");
		} else {
			rollback(conn);
			System.out.println("실패");
		}
		
		close(conn);
	}

}
