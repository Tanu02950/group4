package com.siri.proj.java.onlinevegetablesale.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity(name="Cust_TB")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerId;
	
	@NotNull(message="Customer name should be mandatory")
	@Column(name="Customer_name")
	private String name;
	
	@NotNull(message="mobile Number should  not be null")
	@Pattern(regexp="^[6-9]{1}[0-9]{9}$",message="enter valid mobile Number")
	private String mobileNumber;
	
	@OneToOne(cascade=CascadeType.ALL) 
	private Address address;
	
	@Email(message="Email is mandatory")
	@Pattern(regexp="^([a-zA-Z]{1}[a-zA-Z]+)@([a-zA-Z]+)\\.([a-zA-Z]{2,30})$",message="enter valid email id")
	private String emailId;
	
	@NotNull(message="password is mandatory")
	@Length(min=8,message="you must enter atleast 8 characters!!!!")
	@Pattern(regexp="^[a-zA-Z!@#$%^&*()_+0-9]{8,20}",message="password should contain atleast one upper case, atleast one lower case and atleat one special character")
	private String password;
	
	
	private String confirmPassword;
	public Customer() {
		super();
		
	}
	public Customer(int customerId, String name, String mobileNumber, Address address, String emailId, String password,
			String confirmPassword) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", emailId=" + emailId + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ "]";
	}
	

}
