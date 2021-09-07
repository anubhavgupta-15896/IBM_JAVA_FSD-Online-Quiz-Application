package com.onlinequiz.user.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "plans")
public class Plans {
	@Id
	@GeneratedValue
	
	@Column(name = "plan_id")
	int planId;
	@Column(name = "plan_name")
	String planName;
	
	@Column(name = "validity_in_days")
	int validityInDays;
	
	@Column(name = "plan_amount")
	double planAmount;
	
	@OneToMany(mappedBy = "plan")
	private List<Subscription> subscriptions;
	
	public Plans() {}
	public Plans(int planId, String planName, int validityInDays, double planAmount) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.validityInDays = validityInDays;
		this.planAmount = planAmount;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getValidityInDays() {
		return validityInDays;
	}

	public void setValidityInDays(int validityInDays) {
		this.validityInDays = validityInDays;
	}

	public double getPlanAmount() {
		return planAmount;
	}

	public void setPlanAmount(double planAmount) {
		this.planAmount = planAmount;
	}
	
	
}
