package board.model.vo;

import java.sql.Date;

public class Reply {
	private int replyId;
	private String replyContent;
	private int refBId;
	private String replyWriter;
	private String nickname;
	private Date createDate;
	private Date modifyDate;
	private String status;
	
	public Reply() {}

	public Reply(int replyId, String replyContent, int refBId, String replyWriter, String nickname, Date createDate,
			Date modfiyDate, String status) {
		super();
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.refBId = refBId;
		this.replyWriter = replyWriter;
		this.nickname = nickname;
		this.createDate = createDate;
		this.modifyDate = modfiyDate;
		this.status = status;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getRefBId() {
		return refBId;
	}

	public void setRefBId(int refBId) {
		this.refBId = refBId;
	}

	public String getReplyWriter() {
		return replyWriter;
	}

	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		return "Reply [replyId=" + replyId + ", replyContent=" + replyContent + ", refBId=" + refBId + ", replyWriter="
				+ replyWriter + ", nickname=" + nickname + ", createDate=" + createDate + ", modfiyDate=" + modifyDate
				+ ", status=" + status + "]";
	}
	
	
}
