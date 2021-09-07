package com.ibm.analysisService.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "quiz_schedule")
public class QuizSchedule {

	@Id
	@Column(name = "schedule_id")
	private int scheduleId;
	
	@Column(name = "user_name")
	private String userName;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quiz_id")
	private Quiz quiz;
	
	@Column(name = "quiz_date")
	private LocalDate quizDate;
	
	@Column(name = "quiz_time")
	private LocalTime quizTime;
	
	@OneToMany(mappedBy="scheduleId")
	private Collection<UserQuizHistory> question;
	
	public QuizSchedule() { }

	public QuizSchedule(int scheduleId, String userName, Quiz quiz, LocalDate quizDate, LocalTime quizTime,
			Collection<UserQuizHistory> question) {
		super();
		this.scheduleId = scheduleId;
		this.userName = userName;
		this.quiz = quiz;
		this.quizDate = quizDate;
		this.quizTime = quizTime;
		this.question = question;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public LocalDate getQuizDate() {
		return quizDate;
	}

	public void setQuizDate(LocalDate quizDate) {
		this.quizDate = quizDate;
	}

	public LocalTime getQuizTime() {
		return quizTime;
	}

	public void setQuizTime(LocalTime quizTime) {
		this.quizTime = quizTime;
	}

	public Collection<UserQuizHistory> getQuestion() {
		return question;
	}

	public void setQuestion(Collection<UserQuizHistory> question) {
		this.question = question;
	}
	
	
}
