package com.onlinequiz.user.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subcription")
public class Subscription {
		@Id
		@Column(name = "subcription_id")
		int subscriptionId;
		
		//@Column(name = "user_id")
		//String userId;
		
		@Column(name="user_name")
		String userName;
		
	    //@Column(name="plan_id")
		//int planId;
	    
	    @Column(name="start_date")
		Date subscriptionStartDate;
	    
	    @Column(name="end_date")
	    Date subscriptionEndDate;
	    
	    @Column(name="transaction_id")
		int transactionId;
	    
	    @ManyToOne
	    @JoinColumn(name="subscription_id")
	    private User user;
	    
	    @ManyToOne
	    @JoinColumn(name="plan_id")
	    private Plans plan;
	    
		public Subscription() {}


		public Subscription(int subscriptionId, String userName, Date subscriptionStartDate, Date subscriptionEndDate,
				int transactionId, User user, Plans plan) {
			super();
			this.subscriptionId = subscriptionId;
			this.userName = userName;
			this.subscriptionStartDate = subscriptionStartDate;
			this.subscriptionEndDate = subscriptionEndDate;
			this.transactionId = transactionId;
			this.user = user;
			this.plan = plan;
		}

		public int getSubscriptionId() {
			return subscriptionId;
		}

		public void setSubscriptionId(int subscriptionId) {
			this.subscriptionId = subscriptionId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public Date getSubscriptionStartDate() {
			return subscriptionStartDate;
		}
		public void setSubscriptionStartDate(Date subscriptionStartDate) {
			this.subscriptionStartDate = subscriptionStartDate;
		}

		public Date getSubscriptionEndDate() {
			return subscriptionEndDate;
		}

		public void setSubscriptionEndDate(Date subscriptionEndDate) {
			this.subscriptionEndDate = subscriptionEndDate;
		}

		public int getTransactionId() {
			return transactionId;
		}

		public void setTransactionId(int transactionId) {
			this.transactionId = transactionId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Plans getPlan() {
			return plan;
		}


		public void setPlan(Plans plan) {
			this.plan = plan;
		}
}
		
		