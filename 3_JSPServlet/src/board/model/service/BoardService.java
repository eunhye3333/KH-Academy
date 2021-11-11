package board.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import board.model.dao.BoardDAO;
import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;

public class BoardService {
	
	private BoardDAO bDAO = new BoardDAO();

	public int getListCount() {
		Connection conn = getConnection();
		
		int listCount = bDAO.getListCount(conn);
		
		close(conn);
		
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Board> list = bDAO.selectList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result = bDAO.insertBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Board selectBoard(int bId, String upd) {
		Connection conn = getConnection();
		
		int result = 0;
		
		if(!(upd != null && upd.equals("Y"))) {
			result = bDAO.updateCount(conn, bId);
		}
		
		Board b = bDAO.selectBoard(conn, bId);
		
		if(b != null && result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return b;
	}

	public int updateBoard(Board b) {
		Connection conn = getConnection();
		
		int result = bDAO.updateBoard(conn, b);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteBoard(int bId) {
		Connection conn = getConnection();
		
		int result = bDAO.deleteBoard(conn, bId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList selectTList(int i) {
		// 반환값을 ArrayList로 하면 알아서 <Board>, <Attachment>로 적용하여 가져감
		Connection conn = getConnection();
		
		ArrayList list = null;
		if(i == 1) {
			list = bDAO.selectBList(conn);
		} else {
			list = bDAO.selectFList(conn);
		}
		
		close(conn);
		
		return list;
	}

	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		
		int result1 = bDAO.insertBoard(conn, b);
		int result2 = bDAO.insertAttachment(conn, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result1 + result2;
	}

	public ArrayList<Attachment> selectThumbnail(int bId) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = bDAO.selectThumbnail(bId, conn);
		
		close(conn);
		
		return list;
	}

}
