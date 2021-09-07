package com.ibm.analysisService.dto;

public interface Analysis {
	
	int getQuizId();
	String getUserName();
	String getQuizDate();
	String getQuizTime();
	int getQuestionId();
	String getQuestion();
	String getOption1();
	String getOption2();
	String getOption3();
	String getAnsOption();
	String getOptionSelected();
	String getResult();
}
