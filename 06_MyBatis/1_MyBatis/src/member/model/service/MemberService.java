package member.model.service;

import static common.Template.getSqlSession;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import member.model.dao.MemberDAO;
import member.model.exception.MemberException;
import member.model.vo.Member;

public class MemberService {
	
	private MemberDAO mDAO = new MemberDAO();
	
	public Member selectMember(Member m) throws MemberException {
		SqlSession session = getSqlSession();
		
		Member member = mDAO.selectMember(session, m);
		
		session.close(); // 오류가 발생한 경우 비정상 종료가 되기 때문에 해당 부분을 실행할 수 없어 close가 일어나지 않음 따라서 DAO에서 에러를 발생시키기 전에 session을 닫아 주어야 함
		
		return member;
	}

	public void insertMember(Member m) throws MemberException {
		SqlSession session = getSqlSession();
		
		mDAO.insertMember(session, m);
		
		session.commit();
		session.close();
	}

	public void updateMember(Member m) throws MemberException {
		SqlSession session = getSqlSession();
		
		mDAO.updateMember(session, m);
		
		session.commit();
		session.close();
		
	}

	public void updatePwd(HashMap<String, String> map) throws MemberException {
		SqlSession session = getSqlSession();
		
		mDAO.updatePwd(session, map);
		
		session.commit();
		session.close();
	}

	public void deleteMember(String userId) throws MemberException {
		SqlSession session = getSqlSession();
		
		mDAO.deleteMember(session, userId);
		
		session.commit();
		session.close();
		
		
	}
	
}
