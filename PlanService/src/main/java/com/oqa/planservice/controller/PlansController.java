package com.oqa.planservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oqa.planservice.dao.PlansDao;
import com.oqa.planservice.model.Plans;
import com.oqa.planservice.service.PlansService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/plans")
public class PlansController {
	
	@Autowired 
	PlansService plansService;
	
	@GetMapping
	public ResponseEntity<List<Plans>> getAllPlans(){
		return new ResponseEntity<List<Plans>>(plansService.getPlans(),HttpStatus.OK);
	}
	
	@GetMapping(value = "/{planId}", produces ="application/json")
	
	public ResponseEntity<Plans> getPlans(@PathVariable int planId){
		Plans p = plansService.getPlans(planId);
		if (p != null) {
			return new ResponseEntity<Plans>(p, HttpStatus.OK);
		}
		return new ResponseEntity<Plans>(p, HttpStatus.NOT_FOUND);
}
	@PutMapping(consumes = "application/json")
	public HttpStatus addPlanDetails(@RequestBody Plans plan) {
		if (plansService.insertPlan(plan)) {
			return HttpStatus.OK;
		}
		return HttpStatus.FAILED_DEPENDENCY;
	}
	@PostMapping(consumes = "application/json")
	public HttpStatus modifyPlanDetails(@RequestBody Plans plan) {
		if (plansService.modifyPlans(plan)) {
			return HttpStatus.OK;
		}
		return HttpStatus.FAILED_DEPENDENCY;
		}
	@DeleteMapping("/{planId}")
	public HttpStatus deletePlans(@PathVariable int planId) {
		plansService.deletePlans(planId);
		return HttpStatus.OK;

	}
}
	
	
	
	
	
	
	
	
