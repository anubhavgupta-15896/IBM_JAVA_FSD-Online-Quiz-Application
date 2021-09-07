package com.oqa.quizservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "quiz_details")
public class Quiz {
	@Id
	@Column(name = "quiz_id")
	private int id;
	@Column(name = "quiz_name")
	private String name;
	@Column(name = "subject")
	private String subject;
	@Column(name = "no_of_questions")
	private int numberofquestions;
	@Column(name = "duration")
	private int durationInMinuites;
	@Column(name = "max_marks")
	private int maxMarks;
	@Column(name = "pass_marks")
	private int passingMarks;
	@Column(name = "quiz_type")
	private String quizType;
	@Transient
	private List<Question> questions;

	

	public Quiz(int id, String name, String subject, int numberofquestions, int durationInMinuites, int maxMarks,
			int passingMarks, String quizType) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.numberofquestions = numberofquestions;
		this.durationInMinuites = durationInMinuites;
		this.maxMarks = maxMarks;
		this.passingMarks = passingMarks;
		this.quizType = quizType;
	}

	public Quiz() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getNumberofquestions() {
		return numberofquestions;
	}

	public void setNumberofquestions(int numberofquestions) {
		this.numberofquestions = numberofquestions;
	}

	public int getDurationInMinuites() {
		return durationInMinuites;
	}

	public void setDurationInMinuites(int durationInMinuites) {
		this.durationInMinuites = durationInMinuites;
	}

	public int getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(int maxMarks) {
		this.maxMarks = maxMarks;
	}

	public int getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(int passingMarks) {
		this.passingMarks = passingMarks;
	}
	public String getQuizType() {
		return quizType;
	}

	public void setQuizType(String quizType) {
		this.quizType = quizType;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
