package com.ibm.analysisService.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_quiz_history")
public class UserQuizHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_quiz_history_id")
	private int userQuizHistoryId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
	private Questions question;
	
	
	@Column(name = "option_selected")
	private String optionSelected;

//	@Column(name = "results")
//	private String results;
	
	@Column(name = "schedule_id")
	private int scheduleId;
	
//	 @ManyToOne
//	 @JoinColumn(name="schedule_id", nullable=false)
//	 private QuizSchedule quizSchedule;
	
	public UserQuizHistory() {}

	public UserQuizHistory(int userQuizHistoryId, Questions question, String optionSelected, int scheduleId) {
		super();
		this.userQuizHistoryId = userQuizHistoryId;
		this.question = question;
		this.optionSelected = optionSelected;
		this.scheduleId = scheduleId;
	}
	
	public int getUserQuizHistoryId() {
		return userQuizHistoryId;
	}
	
	public void setUserQuizHistoryId(int userQuizHistoryId) {
		this.userQuizHistoryId = userQuizHistoryId;
	}
	
	public Questions getQuestion() {
		return question;
	}
	
	public void setQuestion(Questions question) {
		this.question = question;
	}
	
	public String getOptionSelected() {
		return optionSelected;
	}
	
	public void setOptionSelected(String optionSelected) {
		this.optionSelected = optionSelected;
	}
	
	public int getScheduleId() {
		return scheduleId;
	}
	
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	
}
