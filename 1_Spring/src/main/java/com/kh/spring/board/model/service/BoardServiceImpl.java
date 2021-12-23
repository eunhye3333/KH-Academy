package com.kh.spring.board.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.board.model.dao.BoardDAO;
import com.kh.spring.board.model.vo.Board;
import com.kh.spring.board.model.vo.PageInfo;
import com.kh.spring.board.model.vo.Reply;

@Service("bService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO bDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession; // 멤버에서 만들어 놓았기 때문에 또 정의하지 않아도 됨
	
	@Override
	public int getListCount() {
		return bDAO.getListCount(sqlSession);
	}
	
	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		return bDAO.selectList(sqlSession, pi);
	}
	
	@Override
	public int insertBoard(Board b) {
		return bDAO.insertBoard(sqlSession, b);
	}
	
	@Override
	public Board selectBoard(int bId, String upd) {
		
		Board b = null;
		
		if(upd != null && upd.equals("Y")) {
			b = bDAO.selectBoard(sqlSession, bId);
		} else {
			int result = bDAO.addReadCount(sqlSession, bId);
			if(result > 0) {
				b = bDAO.selectBoard(sqlSession, bId);
			} 
			
		}
		
		return b;
	}

	@Override
	public int updateBoard(Board b) {
		return bDAO.updateBoard(sqlSession, b);
	}

	@Override
	public int deleteBoard(int bId) {
		return bDAO.deleteBoard(sqlSession, bId);
	}

	@Override
	public int addReply(Reply r) {
		return bDAO.addReply(sqlSession, r);
	}
	
	@Override
	public ArrayList<Reply> selectReplyList(int bId) {
		return bDAO.selectReplyList(sqlSession, bId);
	}
	
	@Override
	public ArrayList<Board> topList() {
		return bDAO.topList(sqlSession);
	}
}
