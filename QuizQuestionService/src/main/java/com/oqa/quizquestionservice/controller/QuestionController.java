package com.oqa.quizquestionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oqa.quizquestionservice.entity.Question;
import com.oqa.quizquestionservice.service.QuestionService;

@RestController
public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@GetMapping(value = "/quiz/{quizId}/questions",produces  = "application/json")
	public ResponseEntity<List<Question>> getQuestionByQuizId(@PathVariable int quizId) {
		try {
			List<Question> questions = questionService.getQuestionByQuizId(quizId);
			if(questions != null && !questions.isEmpty())
				return new ResponseEntity<List<Question>>(questions,HttpStatus.OK);
			}catch(Exception ex) {
				System.out.println(ex);
			}
			return new ResponseEntity<List<Question>>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "/quiz/{quizId}/question",consumes = "application/json")
	public HttpStatus insertQuestion(@RequestBody Question question,@PathVariable int quizId) {
		try {
			questionService.insertQuestion(question, quizId);
			return HttpStatus.OK;
			}catch(Exception ex) {
				System.out.println(ex);
			}
			return HttpStatus.SERVICE_UNAVAILABLE;
	}
	
	@PutMapping(value = "/question",consumes = "application/json")
	public HttpStatus modifyQuestion(@RequestBody Question question) {
		try {
			if(questionService.modifyQuestionWithoutQuiz(question))
				return HttpStatus.OK;
			}catch(Exception ex) {
				System.out.println(ex);
			}
			return HttpStatus.SERVICE_UNAVAILABLE;
	}
	
	@DeleteMapping(value = "/question/{questionId}")
	public HttpStatus deleteQuestion(@PathVariable int questionId) {
		questionService.deleteQuestion(questionId);
		return HttpStatus.OK;
	}
	
	@DeleteMapping(value = "quiz/{quizId}/questions")
	public HttpStatus deleteQuestionByQuizId(@PathVariable int quizId)
	{
		questionService.deleteQuestionByquizId(quizId);
		return HttpStatus.OK;
	}
}
