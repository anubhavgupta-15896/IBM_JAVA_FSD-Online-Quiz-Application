package com.ibm.analysisService.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.analysisService.dto.Analysis;
import com.ibm.analysisService.entity.QuizSchedule;
import com.ibm.analysisService.service.AnalysisService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AnalysisController {
	
	@Autowired
	AnalysisService analysisService;
	
	@GetMapping(value = "/{scheduleId}/{username}",produces="application/json")
	public ResponseEntity<List<Analysis>> getReport(@PathVariable int scheduleId, @PathVariable String username)
	{
		List<Analysis> d = analysisService.getReportByQuizIdAndUsername(scheduleId,username);
		if(d!=null) return new ResponseEntity<List<Analysis>>(d,HttpStatus.OK);
		return new ResponseEntity<List<Analysis>>(d,HttpStatus.NOT_FOUND);
	} 
	
	@GetMapping(value = "/myquiz/{username}",produces="application/json")
	public ResponseEntity<List<QuizSchedule>> getMyQuizes(@PathVariable String username)
	{
		List<QuizSchedule> d = analysisService.getMyQuizes(username);
		if(d!=null) return new ResponseEntity<List<QuizSchedule>>(d,HttpStatus.OK);
		return new ResponseEntity<List<QuizSchedule>>(d,HttpStatus.NOT_FOUND);
	} 
	
}
