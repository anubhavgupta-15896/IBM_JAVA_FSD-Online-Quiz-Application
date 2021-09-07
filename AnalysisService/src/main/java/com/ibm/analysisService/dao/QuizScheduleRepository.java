package com.ibm.analysisService.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ibm.analysisService.dto.Analysis;
import com.ibm.analysisService.entity.QuizSchedule;

public interface QuizScheduleRepository extends JpaRepository<QuizSchedule, Integer> {
	
	@Query(value = "select qs.quiz_id as quizId, qs.user_name as userName, qs.quiz_date as quizDate, \r\n"
			+ "qs.quiz_time as quizTime, uqh.question_id as questionId , q.description as question, \r\n"
			+ "q.option1 , q.option2, q.option3, q.ans_option as ansOption,\r\n"
			+ "uqh.option_selected as optionSelected,\r\n"
			+ "IF(uqh.option_selected=q.ans_option, true, false) as result\r\n"
			+ "from quiz_schedule qs join user_quiz_history uqh on qs.schedule_id = uqh.schedule_id\r\n"
			+ "join questions q on uqh.question_id = q.question_id \r\n"
			+ "where qs.schedule_id = :scheduleId and qs.user_name = :userName ", nativeQuery = true)
	List<Analysis> getReportByQuizIdAndUserId(@Param("scheduleId") int scheduleId, @Param("userName") String userName);

	List<QuizSchedule> findByUserName(String username);
	
}
