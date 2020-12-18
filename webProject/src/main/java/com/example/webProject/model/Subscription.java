package com.example.webProject.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscription {
	
	@Id
	private Integer subscriptionId;
	private String name;
	private String subscribedDate;
	private String returnedDate;
	private Integer bookId;
	public Integer getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubscribedDate() {
		return subscribedDate;
	}
	public void setSubscribedDate(String subscribedDate) {
		this.subscribedDate = subscribedDate;
	}
	public String getReturnedDate() {
		return returnedDate;
	}
	public void setReturnedDate(String returnedDate) {
		this.returnedDate = returnedDate;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	
	
	
	
}
