package com.siri.proj.java.onlinevegetablesale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;



@Entity(name="order_Table")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int orderNo;
	
	@NotNull(message=" CustomerId  should not be null")
	@Min(value=1)
	@Max(value=1000000)
	private int customerId;
	
	
	
	
	@Min(value=15)
	private double totalAmount;
	
	@NotNull(message="Status should be mandatory")
	private String status;
	public Order() {
		super();
		
	}
	public Order(int orderNo, int customerId, /*List<Vegetable> vegetableList,*/ double totalAmount, String status) {
		super();
		this.orderNo = orderNo;
		this.customerId = customerId;
		///this.vegetableList = vegetableList;
		this.totalAmount = totalAmount;
		this.status = status;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	/*public List<Vegetable> getVegetableList() {
		return vegetableList;
	}
	public void setVegetableList(List<Vegetable> vegetableList) {
		this.vegetableList = vegetableList;
	}*/
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", customerId=" + customerId + 
			", totalAmount=" + totalAmount + ", status=" + status + "]";
	}
	

}
