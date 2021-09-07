package com.oqa.quizquestionservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {
	@Id
	@Column(name="question_id")
	private int id;
	@Column(name="description")
	private String description;
	@Column 
	private String option1;
	@Column
	private String option2;
	@Column
	private String option3;
	@Column(name="ans_option")
	private String answerOption;
	@Column(name = "quiz_id")
	private int quizId;
	public Question() {
		super();
	}
	
	

	public Question(int id, String description, String option1, String option2, String option3,
			String answerOption, int quizId) {
		super();
		this.id = id;
		this.description = description;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.answerOption = answerOption;
		this.quizId = quizId;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getAnswerOption() {
		return answerOption;
	}
	public void setAnswerOption(String answerOption) {
		this.answerOption = answerOption;
	}
	
	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", description=" + description + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", answerOption=" + answerOption + ", quizId=" + quizId + "]";
	}

}
