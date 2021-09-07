package com.oqa.quizservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oqa.quizservice.entity.QuizSchedule;

public interface QuizScheduleDao extends JpaRepository<QuizSchedule, Integer>{

}
