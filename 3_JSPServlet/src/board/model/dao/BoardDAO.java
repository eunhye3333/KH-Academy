package board.model.dao;

import static common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import board.model.vo.Attachment;
import board.model.vo.Board;
import board.model.vo.PageInfo;
import board.model.vo.Reply;

public class BoardDAO {
	private Properties prop = null;
	
	public BoardDAO() {
		prop = new Properties();
		
		String fileName = BoardDAO.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getListCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String query = prop.getProperty("getListCount");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return listCount;
	}

	public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() - 1;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			while(rset.next()) {
				Board b = new Board(rset.getInt("BOARD_ID"),
									rset.getInt("BOARD_TYPE"),
									rset.getString("CATE_NAME"),
									rset.getString("BOARD_TITLE"),
									rset.getString("BOARD_CONTENT"),
									rset.getString("BOARD_WRITER"),
									rset.getString("NICKNAME"),
									rset.getInt("BOARD_COUNT"),
									rset.getDate("CREATE_DATE"),
									rset.getDate("MODIFY_DATE"),
									rset.getString("STATUS"));
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, b.getBoardType());
			pstmt.setInt(2, Integer.parseInt(b.getCategory()));
			pstmt.setString(3, b.getBoardTitle());
			pstmt.setString(4, b.getBoardContent());
			pstmt.setString(5, b.getBoardWritter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateCount(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Board selectBoard(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			rset = pstmt.executeQuery();

			if(rset.next()) {
				b = new Board(rset.getInt("BOARD_ID"), 
							  rset.getInt("BOARD_TYPE"), 
							  rset.getString("CATE_NAME"), 
							  rset.getString("BOARD_TITLE"),
							  rset.getString("BOARD_CONTENT"), 
							  rset.getString("BOARD_WRITER"), 
							  rset.getString("NICKNAME"), 
							  rset.getInt("BOARD_COUNT"), 
							  rset.getDate("CREATE_DATE"), 
							  rset.getDate("MODIFY_DATE"), 
							  rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return b;
	}

	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setInt(3, Integer.parseInt(b.getCategory()));
			pstmt.setInt(4, b.getBoardId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteBoard(Connection conn, int bId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteBoard");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList selectBList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectBList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Board>();
			while(rset.next()) {
//				Board b = new Board(rset.getInt("BOARD_ID"),
//									rset.getInt("BOARD_TYPE"),
//									rset.getString("CATE_NAME"),
//									rset.getString("BOARD_TITLE"),
//									rset.getString("BOARD_CONTENT"),
//									rset.getString("BOARD_WRITER"),
//									rset.getString("NICKNAME"),
//									rset.getInt("BOARD_COUNT"),
//									rset.getDate("CREATE_DATE"),
//									rset.getDate("MODIFY_DATE"),
//									rset.getString("STATUS"));
//				list.add(b);
				
				list.add(new Board(rset.getInt("BOARD_ID"),
								   rset.getInt("BOARD_TYPE"),
								   rset.getString("CATE_NAME"),
								   rset.getString("BOARD_TITLE"),
								   rset.getString("BOARD_CONTENT"),
								   rset.getString("BOARD_WRITER"),
								   rset.getString("NICKNAME"),
								   rset.getInt("BOARD_COUNT"),
								   rset.getDate("CREATE_DATE"),
								   rset.getDate("MODIFY_DATE"),
								   rset.getString("STATUS")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public ArrayList selectFList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectFList");
		// FILE_LEVEL = 0 : 썸네일에 관련된 것만 가지고 오겠다, 리스트만 볼 것이기 때문에 굳이 안에 있는 사진까지 가져오지 않아도 됨
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				Attachment a = new Attachment();
				a.setBoardId(rset.getInt("BOARD_ID"));
				a.setChangeName(rset.getString("CHANGE_NAME"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int insertAttachment(Connection conn, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		// 이미 Board를 넣은 상태로 진행하기 때문에 Board_ID = SEQ_BID.CURRVAL
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, fileList.get(i).getOriginName());
				pstmt.setString(2, fileList.get(i).getChangeName());
				pstmt.setString(3, fileList.get(i).getFilePath());
				pstmt.setInt(4, fileList.get(i).getFileLevel());
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Attachment> selectThumbnail(int bId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectThumbnail");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				Attachment a = new Attachment();
				a.setFiledId(rset.getInt("FILE_ID"));
				a.setOriginName(rset.getString("ORIGIN_NAME"));
				a.setChangeName(rset.getString("CHANGE_NAME"));
				a.setFilePath(rset.getString("FILE_PATH"));
				a.setUploadDate(rset.getDate("UPLOAD_DATE"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Reply> selectReplyList(int bId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = conn.prepareStatement(query);	
			pstmt.setInt(1, bId);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Reply>();
			
			while(rset.next()) {
				Reply r = new Reply(rset.getInt("REPLY_ID"),
									rset.getString("REPLY_CONTENT"),
									rset.getInt("REF_BID"),
									rset.getString("REPLY_WRITER"),
									rset.getString("NICKNAME"),
									rset.getDate("CREATE_DATE"),
									rset.getDate("MODIFY_DATE"),
									rset.getString("STATUS"));
				list.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int insertReply(Connection conn, Reply r) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getRefBId());
			pstmt.setString(3, r.getReplyWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}
