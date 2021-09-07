package com.ibm.studymaterial.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ibm.studymaterial.dao.CommentImpl;

@Document(collection = "subject_dicussionForum")
public class DiscussionForum {
	
	@Id
	private String id;
	private String subject;
	private String userName;
	private LocalDateTime created;
	private String questionDescription;
	private List<CommentImpl> Comments ;
	
	public DiscussionForum() {}

	public DiscussionForum(String subject, String userName, String questionDescription,
			List<CommentImpl> comments) {
		super();
		this.subject = subject;
		this.userName = userName;
		this.created = LocalDateTime.now();
		this.questionDescription = questionDescription;
		Comments = comments;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public List<CommentImpl> getComments() {
		return Comments;
	}

	public void setComments(List<CommentImpl> comments) {
		Comments = comments;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = LocalDateTime.now();
	}
}
