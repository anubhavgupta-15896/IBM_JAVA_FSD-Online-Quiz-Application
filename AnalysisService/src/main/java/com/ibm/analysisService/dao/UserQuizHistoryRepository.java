package com.ibm.analysisService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.analysisService.entity.UserQuizHistory;

public interface UserQuizHistoryRepository extends JpaRepository<UserQuizHistory, Integer> {

}
