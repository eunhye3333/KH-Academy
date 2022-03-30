package notice.model.service;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {

	private NoticeDAO nDAO = new NoticeDAO();
	
	public ArrayList<Notice> selectList() {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = nDAO.selectList(conn);
		
		close(conn);
		
		return list;
	}

	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = nDAO.insertNotice(conn, n);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Notice selectNotice(int no, String upd) {
		Connection conn = getConnection();
		
		// 만일 upd가 있으면 update이후 실행하는 것이기 때문에 updateCount를 안 해도 되고, upd가 없으면 그냥 조회를 하는 것이기 때문에 updateCount를 해주어야 함
		
		// 공지사항을 보면 조회수가 올라가기 때문에 조회수도 같이 업데이트되어야 함
		int result =  0;
		if(!(upd != null && upd.equals("Y"))) {
			result = nDAO.updateCount(conn, no);
		}
		
		Notice notice = nDAO.selectNotice(conn, no);
		
		if(result > 0 && notice != null) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return notice;
	}

	public int updateNotice(Notice notice) {
		Connection conn = getConnection();
		
		int result = nDAO.updateNotice(conn, notice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int deleteNotice(int no) {
		Connection conn = getConnection();
		
		int result = nDAO.deleteNotice(conn, no);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
