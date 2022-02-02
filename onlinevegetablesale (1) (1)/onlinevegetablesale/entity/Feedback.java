package com.siri.proj.java.onlinevegetablesale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@Entity(name="FeedBack_TB")
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedbackId;
	@NotNull(message="Feedback ID shoulb not be null and must be a positive value")
	@Min(value=1)
	@Max(value=1000000)
	private int customerId;
	
	@NotNull(message="VegetableId Must be not null and positive number")
	@Min(value=3)
	@Max(value=1000)
	private int vegetableId;
	
	
	@Min(value=1)
	@Max(value=10)
	private int rating;
	
	@Pattern(regexp="[a-z A-Z]+")
	private String comments;
	
	public Feedback() {
		super();
		
	}
	public Feedback(int feedbackId, int customerId, int vegetableId, int rating, String comments) {
		super();
		this.feedbackId = feedbackId;
		this.customerId = customerId;
		this.vegetableId = vegetableId;
		this.rating = rating;
		this.comments = comments;
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getVegetableId() {
		return vegetableId;
	}
	public void setVegetableId(int vegetableId) {
		this.vegetableId = vegetableId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customerId=" + customerId + ", vegetableId=" + vegetableId
				+ ", rating=" + rating + ", comments=" + comments + "]";
	}
	

}
