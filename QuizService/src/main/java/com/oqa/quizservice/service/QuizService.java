package com.oqa.quizservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oqa.quizservice.dao.QuestionDao;
import com.oqa.quizservice.dao.QuizDao;
import com.oqa.quizservice.dao.QuizScheduleDao;
import com.oqa.quizservice.dao.UserQuizHistoryDao;
import com.oqa.quizservice.entity.Question;
import com.oqa.quizservice.entity.Quiz;
import com.oqa.quizservice.entity.QuizSchedule;
import com.oqa.quizservice.entity.UserQuizHistory;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	
//	@Autowired
//	RestTemplate restTemplate;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	QuizScheduleDao quizScheduleDao;
	
	@Autowired
	UserQuizHistoryDao userQuizHistoryDao;
	
	public Quiz getQuizById(int id) {
		Optional<Quiz> q = quizDao.findById(id);
		if(q.isPresent()) {
			Quiz quiz = q.get();
			Optional<List<Question>> questionList = questionDao.findByQuizId(quiz.getId(), quiz.getNumberofquestions());
			if(questionList.isPresent()) {
				quiz.setQuestions(questionList.get());
			}else {
				return null;
			}
			return quiz;
		}
		return null;
	}
	public boolean submitConductedQuiz(QuizSchedule quizSchedule) {
		QuizSchedule qs = quizScheduleDao.save(quizSchedule);
		System.out.println(qs.toString());
		if(qs != null) {	
			for(UserQuizHistory uqh : quizSchedule.getUserQuizAnswerList()) {
				uqh.setScheduleId(qs.getScheduleId());
				userQuizHistoryDao.save(uqh);
			}
			return true;
		}
		return false;
	}
	
	public QuizSchedule getQuizByScheduleId(int scheduleId) {
		Optional<QuizSchedule> qs = quizScheduleDao.findById(scheduleId);
		if(qs.isPresent())
			return qs.get();
		return null;
	}
	
	
	
	public List<Quiz> getQuizBySubject(String subject){
		Optional<List<Quiz>> quizList = quizDao.findBySubject(subject);
		if(quizList.isPresent())
			return  quizList.get();
		return null;
	}
	
	public boolean insertQuizDetail(Quiz quiz) {
		if(quizDao.save(quiz) != null)
			return true;
		throw new RuntimeException("Quiz Detail not added, Insertion failed");
	}
	
	public List<String> getSubjectListOfQuiz(){
		Optional<List<String>> subjectList = quizDao.getListOfSubject();
		if(subjectList.isPresent())
			return subjectList.get();
		return null;
	}

	public boolean modifyQuizDetail(Quiz quiz) {
		if(quizDao.save(quiz) != null)
			return true;
		throw new RuntimeException("Quiz Detail no modified, modification failed");
	}
	
//	public boolean deleteQuiz(int quizId) {
//		quizDao.deleteById(quizId);
//		restTemplate.delete("http://localhost:8082/quiz/"+quizId+"/questions");
//		return true;
//	}
//	@Transactional
//	public boolean createQuizSchedule(int quizId,String userName) {
//		Quiz q =this.getQuizById(quizId);
//		if(q != null)
//		{
//			if("free".equalsIgnoreCase(q.getQuizType())) {
//				QuizSchedule qs = quizScheduleDao.save(new QuizSchedule(userName,q));
//				if(qs != null) {
//					this.insertUserQuizHistory(qs, q);
//				}
//					
//			}else if("paid".equalsIgnoreCase(q.getQuizType())) {
//				String isSubscribed = restTemplate.getForEntity("http://localhost:8083/subscription/is-subscribed/"+userName, String.class).getBody();
//				if("subscribed".equalsIgnoreCase(isSubscribed)) {
//					QuizSchedule qs = quizScheduleDao.save(new QuizSchedule(userName,q));
//					if(qs != null) {
//						this.insertUserQuizHistory(qs, q);
//					}
//				}
//			}
//		}
//		return false;
//	}
//	@Transactional
//	public void insertUserQuizHistory(QuizSchedule qs, Quiz quiz) {
//		Question[] questionList = restTemplate.getForEntity("http://localhost:8082//quiz/"+quiz.getId()+"/questions", Question[].class).getBody();
//		for(Question q : questionList) {
//			userQuizHistoryDao.save(new UserQuizHistory(q.getId(),qs));
//		}
//	}
}
