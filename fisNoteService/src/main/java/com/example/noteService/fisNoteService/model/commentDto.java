package com.example.noteService.fisNoteService.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class commentDto {
	
	int cid;

	int pid;
	
	String commenter;

	String comment;
	public commentDto()
	{
		
	}
	public commentDto(int cid, int pid, String commenter, String comment) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.commenter = commenter;
		this.comment = comment;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getCommenter() {
		return commenter;
	}
	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
