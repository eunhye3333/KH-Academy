package board.model.vo;

import java.sql.Date;

public class Board {
	private int boardId;
	private int boardType;
	private String category;
	private String boardTitle;
	private String boardContent;
	private String boardWritter;
	private String nickName;
	private int boardCount;
	private Date createDate;
	private Date modifyDate;
	private String status;
	
	public Board() {}

	public Board(int boardId, int boardType, String category, String boardTitle, String boardContent,
			String boardWritter, String nickName, int boardCount, Date createDate, Date modifyDate, String status) {
		super();
		this.boardId = boardId;
		this.boardType = boardType;
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWritter = boardWritter;
		this.nickName = nickName;
		this.boardCount = boardCount;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getBoardType() {
		return boardType;
	}

	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWritter() {
		return boardWritter;
	}

	public void setBoardWritter(String boardWritter) {
		this.boardWritter = boardWritter;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", boardType=" + boardType + ", category=" + category + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", boardWritter=" + boardWritter + ", nickName="
				+ nickName + ", boardCount=" + boardCount + ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", status=" + status + "]";
	}
}
