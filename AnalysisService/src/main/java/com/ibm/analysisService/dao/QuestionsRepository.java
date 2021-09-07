package com.ibm.analysisService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.analysisService.entity.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, String> {

}
