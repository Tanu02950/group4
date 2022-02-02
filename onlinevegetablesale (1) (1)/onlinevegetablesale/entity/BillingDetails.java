package com.siri.proj.java.onlinevegetablesale.entity;





import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity(name="BillingDetails_TB")
public class BillingDetails {
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int buildingId;
	
	@Min(value=1)
	@Max(value=1000000)
	private int orderId;
	
	@Enumerated(value=EnumType.STRING)
	private TransactionMode transactionMode;
	
	
	private Date transactionDate;
	
	@Enumerated(value=EnumType.STRING)
	private TransactionStatus transactionStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address buildingAddress;
	public BillingDetails() {
		super();
		
	}
	public BillingDetails(int buildingId, int orderId, TransactionMode transactionMode,Date transactionDate,
			TransactionStatus transactionStatus, Address buildingAddress) {
		super();
		this.buildingId = buildingId;
		this.orderId = orderId;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.transactionStatus = transactionStatus;
		this.buildingAddress = buildingAddress;
	}
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public TransactionMode getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(TransactionMode transactionMode) {
		this.transactionMode = transactionMode;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public Address getBuildingAddress() {
		return buildingAddress;
	}
	public void setBuildingAddress(Address buildingAddress) {
		this.buildingAddress = buildingAddress;
	}
	@Override
	public String toString() {
		return "BillingDetails [buildingId=" + buildingId + ", orderId=" + orderId + ", transactionMode="
				+ transactionMode + ", transactionDate=" + transactionDate + ", transactionStatus=" + transactionStatus
				+ ", buildingAddress=" + buildingAddress + "]";
	}
	

}
