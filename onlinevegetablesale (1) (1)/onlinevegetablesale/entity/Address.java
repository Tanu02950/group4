package com.siri.proj.java.onlinevegetablesale.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;



@Entity(name="Address_TB")
public class Address {
	@Id 

	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int  addressId;
	@NotNull(message="Area name should not be null")
	private String area;
	
	@NotNull(message="City name should not be null")
	private String city;
	
	@NotNull(message="State name should be mandatory")
	private String state;
	
	@NotNull(message="pincode should be mandatory")
	@Pattern(regexp="^[1-9]{1}[0-9]{5}$",message=" pin code number should not start with 0, must have only numbers and should have length  6")
	private String pincode;
	
	@Length(min=2,max=5)
	private String flatNo;
	
	@NotNull(message="building name should not be null")
	@Length(min=5,max=20,message="length should be minimum 5 and maximum 20 characters")
	private String buildingName;
	
	
	public Address() {
		super();
		
	}

	public Address(int addressId, String area, String city, String state, String pincode, String flatNo,
			String buildingName) {
		super();
		this.addressId = addressId;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.flatNo = flatNo;
		this.buildingName = buildingName;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", area=" + area + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", flatNo=" + flatNo + ", buildingName=" + buildingName + "]";
	}
	
	
	

}
