package com.onlinequiz.userservice.entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User 
{
    @Id
    @Column(name="user_name")
    String username;
    
    @Column(name="password")
    String password;
    
    @Column(name="first_name")
    String firstName;
    
    @Column(name="last_name")
    String lastName;
    
    @Column(name="email_id")
    String emailId;
    
    @Column(name="mobile_no")
    long mobileNo;
    
    @Column(name="role_type")
    String roleType = "student";
    
    @OneToMany
    @JoinColumn(name="user_name",referencedColumnName="user_name")  
	List<Subscription> subscriptions;
    
    
    public User() {}
    
    public User(List<Subscription> subscriptions) { this.subscriptions=subscriptions; }
    
    
	public User(String username, String password, String emailId, long mobileNo,String roleType) 
	{
		this.username = username;		this.password = password;
		this.emailId = emailId;		this.mobileNo = mobileNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

	public String getRoleType() {
		return roleType;
	}

//	public void setRoleType(String roleType) {
//		this.roleType = roleType;
//	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", roleType=" + roleType
				+ ", subscriptions=" + subscriptions + "]";
	}
	
}
