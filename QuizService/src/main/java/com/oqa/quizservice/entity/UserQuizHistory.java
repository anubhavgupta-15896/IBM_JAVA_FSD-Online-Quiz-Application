package com.oqa.quizservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_quiz_history")
public class UserQuizHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_quiz_history_id")
	private int userQuizHistoryId;
	
	@ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
	
	@Column(name = "schedule_id")
	private int scheduleId;
	
	@Column(name = "option_selected")
	private String optionSelected;
	
	public UserQuizHistory(int userQuizHistoryId, Question question, int scheduleId, String optionSelected) {
		super();
		this.userQuizHistoryId = userQuizHistoryId;
		this.question = question;
		this.scheduleId = scheduleId;
		this.optionSelected = optionSelected;
	}

	public UserQuizHistory() {
		super();
	}

	public int getUserQuizHistoryId() {
		return userQuizHistoryId;
	}

	public void setUserQuizHistoryId(int userQuizHistoryId) {
		this.userQuizHistoryId = userQuizHistoryId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getOptionSelected() {
		return optionSelected;
	}
	
	public void setOptionSelected(String optionSelected) {
		this.optionSelected = optionSelected;
	}

	@Override
	public String toString() {
		return "UserQuizHistory [userQuizHistoryId=" + userQuizHistoryId + ", question=" + question + ", scheduleId="
				+ scheduleId + ", optionSelected=" + optionSelected + "]";
	}
	
	
}
