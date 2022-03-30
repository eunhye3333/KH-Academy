package com.kh.spring.member.model.service;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDAO;
import com.kh.spring.member.model.vo.Member;

@Service("mService") // Controller에서 변수의 이름을 mService으로 했기 때문에 ("mService")을 작성해주면 바로 찾을 수 있어서 조금 더 정확해짐(조금 더 빨리 찾을 수 있게 하는 장치), 생략 가능
public class MemberServiceImpl implements MemberService {
	// Impl : 구현을 했다는 뜻
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Member memberLogin(Member m) {
		return mDAO.memberLogin(sqlSession, m);
	}
	
	@Override
	public int insertMember(Member m) {
		return mDAO.insertMember(sqlSession, m);
	}
	
//	@Override
//	public String pwdCheck(Member m) {
//		return mDAO.pwdCheck(sqlSession, m);
//		
//	}
	
	@Override
	public int updateMember(Member m) {
		return mDAO.updateMember(sqlSession, m);
	}
	
//	@Override
//	public int updatePwd(Member m) {
//		return mDAO.updatePwd(sqlSession, m);
//	}
	
	@Override
	public int updatePwd(HashMap<String, String> map) {
		return mDAO.updatePwd(sqlSession, map);
	}
	
	@Override
	public int deleteMember(String id) {
		return mDAO.deleteMember(sqlSession, id);
	}

	@Override
	public int duplicateId(String id) {
		return mDAO.duplicateId(sqlSession, id);
	}
	
}
