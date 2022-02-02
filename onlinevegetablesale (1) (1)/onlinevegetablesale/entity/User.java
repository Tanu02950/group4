package com.siri.proj.java.onlinevegetablesale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="User_TB")
public class User {                                     

	@Id
	@GeneratedValue(generator="uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	private String userId;

	
	
	@Pattern(regexp="^[a-zA-Z!@#$%^&*()_+0-9]{8,20}",message="password should contain atleast one upper case, atleast one lower case and atleat one special character")
	private String password;
	
	
	private String role;
	
	
	public User() {
		super();
		
	}
	public User(String userId, String password, String role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + "]";
	}
	

}
