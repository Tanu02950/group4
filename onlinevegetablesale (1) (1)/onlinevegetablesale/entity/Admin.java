package com.siri.proj.java.onlinevegetablesale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name="Admin_Table")
public class Admin {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	
	@NotNull(message="Admin name should not be null")
	@Column(name="admin_name")
	private String name;
	
	@NotNull(message="Mobile number is mandatory")
	@Pattern(regexp="^[6-9]{1}[0-9]{9}$",message="contact number is invalid and should start with valid number  ")
	private String contactNumber;
	
	@Email(message="email is mandatory")
	@Pattern(regexp="^([a-zA-Z]{1}[a-zA-Z]+)@([a-zA-Z]+)\\.([a-zA-Z]{2,30})$")
	
	private String emailId;
	public Admin() {
		super();
		
	}
	public Admin(int adminId, String name, String contactNumber, String emailId) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", name=" + name + ", contactNumber=" + contactNumber + ", emailId="
				+ emailId + "]";
	}
	
	
	

}
