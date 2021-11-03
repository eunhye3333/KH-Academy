package member.model.service;

import static common.JDBCTemplate.getConnection;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.rollback;
import static common.JDBCTemplate.close;

import java.sql.Connection;

import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	
	private MemberDAO mDAO = new MemberDAO();

	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		Member loginUser = mDAO.loginMember(userId, userPwd, conn);
		
		// JDBC에서는 하나의 프로그램 안에서 움직이는 것이기 때문에 프로그램이 종료되었을 때 닫았지만
		// 지금은 외부로 들어가기 때문에 종료한다 안 한다 하기가 어려워서 메소드 단위마다 닫아줌
		close(conn);
		
		return loginUser;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		
		int result = mDAO.insertMember(conn, member);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int checkId(String inputId) {
		Connection conn = getConnection();
		
		int result = mDAO.checkId(conn, inputId);
		
		close(conn);
		
		return result;
	}

	public int checkNick(String inputNick) {
		Connection conn = getConnection();
		
		int result = mDAO.checkNick(conn, inputNick);
		
		close(conn);
		return result;
	}

}
