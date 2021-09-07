package com.oqa.quizquestionservice.support;

public class Quiz {
	private String quizId;
	private String quizName;
	private String Subject;
	private int noOfQuestions;
	private int duration;
	private int maxMarks;
	private int passMarks;
	public Quiz(String quizId, String quizName, String subject, int noOfQuestions, int duration, int maxMarks,
			int passMarks) {
		super();
		this.quizId = quizId;
		this.quizName = quizName;
		Subject = subject;
		this.noOfQuestions = noOfQuestions;
		this.duration = duration;
		this.maxMarks = maxMarks;
		this.passMarks = passMarks;
	}
	public Quiz() {
		super();
	}
	public String getQuizId() {
		return quizId;
	}
	public void setQuizId(String quizId) {
		this.quizId = quizId;
	}
	public String getQuizName() {
		return quizName;
	}
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getMaxMarks() {
		return maxMarks;
	}
	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}
	public int getPassMarks() {
		return passMarks;
	}
	public void setPassMarks(int passMarks) {
		this.passMarks = passMarks;
	}
	
}
