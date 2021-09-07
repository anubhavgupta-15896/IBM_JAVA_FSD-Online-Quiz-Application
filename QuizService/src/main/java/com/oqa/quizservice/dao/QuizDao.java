package com.oqa.quizservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oqa.quizservice.entity.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>
{
	public Optional<List<Quiz>> findBySubject(String subject);
	
	@Query("SELECT distinct q.subject FROM Quiz q")
	public Optional<List<String>> getListOfSubject();
}
