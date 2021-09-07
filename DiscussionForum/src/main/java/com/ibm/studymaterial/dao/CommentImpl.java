package com.ibm.studymaterial.dao;

import java.time.LocalDateTime;

public class CommentImpl {
		
	private String comment;
	private String userName;
	private LocalDateTime created;
	
	public CommentImpl() {}

	public CommentImpl(String comment, String userName) {
		super();
		this.comment = comment;
		this.userName = userName;
		this.created = LocalDateTime.now();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = LocalDateTime.now();
	}

}
