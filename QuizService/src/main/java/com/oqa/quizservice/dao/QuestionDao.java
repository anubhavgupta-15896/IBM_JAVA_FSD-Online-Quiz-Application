package com.oqa.quizservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oqa.quizservice.entity.Question;


public interface QuestionDao extends JpaRepository<Question, Integer>{
	@Query(value = "SELECT * FROM questions WHERE quiz_id=?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
	Optional<List<Question>> findByQuizId(int QuizId, int limit);

}
