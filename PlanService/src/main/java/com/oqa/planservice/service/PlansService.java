package com.oqa.planservice.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oqa.planservice.dao.PlansDao;
import com.oqa.planservice.model.Plans;

@Service
public class PlansService {
	@Autowired
	PlansDao dao;
	String planName;
	
	@Transactional(readOnly = true)
	public Plans getPlans(int planId) {
		Optional<Plans> p = dao.findById(planId);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
	}
	
	@Transactional(readOnly = true)
	public List<Plans> getPlans(){
		return dao.findAll();
	}
	
	public List<Plans> getPlansByPlanId(String planId){
		Optional<List<Plans>> p = dao.findByPlanName(planName);
		if (p.isPresent()) {
			return p.get();
		}
		return null;
	}
	@Transactional
	public boolean insertPlan(Plans plan) {
		if ((dao.save(plan)) != null) {
			return true;
		}
		return false;
	}
	@Transactional
	public boolean modifyPlans(Plans plan) {
		if ((dao.save(plan)) != null) {
			return true;
		}
		return false;
	}
	@Transactional
	public void deletePlans(int planId) {
		dao.deleteById(planId);
	}
	

}
