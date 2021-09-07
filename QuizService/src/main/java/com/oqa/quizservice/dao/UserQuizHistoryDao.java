package com.oqa.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oqa.quizservice.entity.UserQuizHistory;

public interface UserQuizHistoryDao extends JpaRepository<UserQuizHistory, Integer>{

}
