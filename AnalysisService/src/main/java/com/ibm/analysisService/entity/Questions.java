package com.ibm.analysisService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {

	@Id
	@Column(name = "question_id")
	private int questionId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "option1")
	private String opt1;

	@Column(name = "option2")
	private String opt2;

	@Column(name = "option3")
	private String opt3;

	@Column(name = "ans_option")
	private String ans_opt;
	
	@Column(name = "quiz_id")
	private int quizId;
	
//	@OneToOne(mappedBy = "question")
//	private UserQuizHistory userQuizHistory;
	
	
	public Questions() { }

	public Questions(int questionId, String description, String opt1, String opt2, String opt3, String ans_opt,
			int quizId, UserQuizHistory userQuizHistory) {
		super();
		this.questionId = questionId;
		this.description = description;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.ans_opt = ans_opt;
		this.quizId = quizId;
//		this.userQuizHistory = userQuizHistory;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOpt1() {
		return opt1;
	}

	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}

	public String getOpt2() {
		return opt2;
	}

	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}

	public String getOpt3() {
		return opt3;
	}

	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}

	public String getAns_opt() {
		return ans_opt;
	}

	public void setAns_opt(String ans_opt) {
		this.ans_opt = ans_opt;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

//	public UserQuizHistory getUserQuizHistory() {
//		return userQuizHistory;
//	}
//
//	public void setUserQuizHistory(UserQuizHistory userQuizHistory) {
//		this.userQuizHistory = userQuizHistory;
//	}

	
}
