package com.oqa.quizquestionservice.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.oqa.quizquestionservice.dao.QuestionRepository;
import com.oqa.quizquestionservice.entity.Question;
import com.oqa.quizquestionservice.support.Quiz;

@Service
public class QuestionService {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Transactional(readOnly = true)
	public List<Question> getQuestionByQuizId(int quizId){
		Quiz q = restTemplate.getForEntity("http://localhost:8082/quizs/"+quizId, Quiz.class).getBody();
		if(q != null) {
			Optional<List<Question>> questions = questionRepository.findByQuizId(quizId,q.getNoOfQuestions());
			if(questions.isPresent()) {
				return questions.get();
			}
		}
		return null;
	}
	
	@Transactional
	public boolean insertQuestion(Question question, int quizId) {
		question.setQuizId(quizId);
		if(questionRepository.save(question)!= null)
			return true;
		throw new RuntimeException("Book not added , insertion failed");
	}
	
	@Transactional
	public boolean modifyQuestionWithoutQuiz(Question question) {
		Optional<Question> ques = questionRepository.findById(question.getId());
		if(ques.isPresent()) {
			Question q = ques.get();
			q.setDescription(question.getDescription());
			q.setOption1(question.getOption1());
			q.setOption2(question.getOption2());
			q.setOption3(question.getOption3());
			q.setAnswerOption(question.getAnswerOption());
			if(questionRepository.save(q) != null)
				return true;	
		}
		throw new RuntimeException("Question not modified, modification faild");
	}
	
	@Transactional
	public void deleteQuestion(int id) {
		questionRepository.deleteById(id);
	}
	
	@Transactional
	public void deleteQuestionByquizId(int quizId) {
		questionRepository.deleteQuestionsByQuizId(quizId);
	}
	
	
}
