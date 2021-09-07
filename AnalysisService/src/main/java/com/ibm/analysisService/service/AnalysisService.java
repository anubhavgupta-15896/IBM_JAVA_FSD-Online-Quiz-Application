package com.ibm.analysisService.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.analysisService.dao.QuizScheduleRepository;
import com.ibm.analysisService.dto.Analysis;
import com.ibm.analysisService.entity.QuizSchedule;

@Service
public class AnalysisService {

	@Autowired
	QuizScheduleRepository quizScheduleRepository;
	
	public List<Analysis> getReportByQuizIdAndUsername(int scheduleId, String username) {
		
		List<Analysis> analysis = quizScheduleRepository.getReportByQuizIdAndUserId(scheduleId, username);
		if(analysis != null) return analysis;
		return null;
	}

	public List<QuizSchedule> getMyQuizes(String username) {
		List<QuizSchedule> myQuizes = quizScheduleRepository.findByUserName(username);
		if(myQuizes != null) return myQuizes;
		return null;
	}
}
