package com.oqa.planservice.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oqa.planservice.model.Plans;

@Repository
public interface PlansDao extends JpaRepository<Plans, Integer>{
	public Optional<List<Plans>> findByPlanName(String planName);

}
