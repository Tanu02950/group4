package com.siri.proj.java.onlinevegetablesale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity(name="Veg_TB")
public class Vegetable {
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  vegId;
	
	@NotNull(message="vegetable name should not be null and should enter valid vegetable name")
	@Column(name="veg_name")
	
	@NotNull(message="vegetable name should not be null")
	private String name;
	
	@NotNull(message="type should not be null")
	private String type;
	
	@NotNull(message="price should not be null")
	@Min(value=15)
	@Max(value=1000)
	private double price;
	
	@NotNull(message="quantity should not be null and quantity should be in terms of kgs")
	@Min(value=1)
	@Max(value=10)
	private int quantity;
	public Vegetable() {
		super();
		
	}
	public Vegetable(int vegId, String name, String type, double price, int quantity) {
		super();
		this.vegId = vegId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
	}
	public int getVegId() {
		return vegId;
	}
	public void setVegId(int vegId) {
		this.vegId = vegId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "VegetableDTO [vegId=" + vegId + ", name=" + name + ", type=" + type + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	

}
