package com.oqa.quizquestionservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oqa.quizquestionservice.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	@Query(value = "SELECT * FROM questions WHERE quiz_id=?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
	Optional<List<Question>> findByQuizId(int QuizId, int limit);
	
	@Query("delete from Question q where q.quizId=:quizId")
	void deleteQuestionsByQuizId(@Param("quizId") int quizId);

}
