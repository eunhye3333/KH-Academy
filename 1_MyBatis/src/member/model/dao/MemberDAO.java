package member.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import member.model.exception.MemberException;
import member.model.vo.Member;

public class MemberDAO {

	public Member selectMember(SqlSession session, Member m) throws MemberException {
		/*
			session.selectOne(arg0)
			session.selectOne(arg0, arg1)
		
			- arg0 : 어느 Mapper에 있는 어떤 쿼리(id)에 접근할 것인가 (. 이용)
			                    쿼리를 구분했던 것처럼 mapper도 구분이 필요
			- arg1 : 쿼리로 보낼 데이터를 작성
		 			  쿼리가 완성되지 않았기 때문에 매개변수로 받아온 데이터를 mapper로 보내 줘야 함
		 			  
			보낼 데이터가 존재하지 않는 경우에는 매개변수 하나짜리 메소드를 사용하고, 보낼 데이터가 존재하는 경우에는 매개변수가 두 개인 메소드를 사용하여야 함
		*/
		
		Member member = session.selectOne("memberMapper.loginMember", m);
		// 원래 반환값은 T, 어떤 반환값이든 받아들이겠다(어떤 타입이든 다 받겠다) 이것을 클래스로 치환하면 Object
		
		if(member == null) {
			// 존재하지 않는 회원, 로그인이 실패했을 경우
			session.close();
			throw new MemberException("로그인에 실패하였습니다."); // 에러 강제 발생, throw를 해서 강제 발생시키는 경우 throws를 이용하여 위임
		}
		return member;
	}

	public void insertMember(SqlSession session, Member m) throws MemberException {
		int result = session.insert("memberMapper.insertMember", m);
		
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new MemberException("회원가입에 실패하였습니다.");
		}
	}

	public void updateMember(SqlSession session, Member m) throws MemberException {
		int result = session.update("memberMapper.updateMember", m);
		
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new MemberException("회원 정보 수정에 실패하였습니다.");
		}
		
	}

	public void updatePwd(SqlSession session, HashMap<String, String> map) throws MemberException {
		int result = session.update("memberMapper.updatePwd", map);
		
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new MemberException("비밀번호 수정에 실패하였습니다.");
		}
		
	}

	public void deleteMember(SqlSession session, String userId) throws MemberException {
		int result = session.update("memberMapper.deleteMember", userId);
		
		if(result <= 0) {
			session.rollback();
			session.close();
			throw new MemberException("회원 탈퇴에 실패하였습니다.");
		}
		
	}

}
