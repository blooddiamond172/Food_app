package com.dungnv.model;

import java.io.Serializable;

public class UserBill implements Serializable {
	private static final long serialVersionUID = 6L; 
	
	private Integer billID;
	private Integer userID;
	
	public UserBill() {
	}

	public UserBill(Integer billID, Integer userID) {
		this.billID = billID;
		this.userID = userID;
	}

	public Integer getBillID() {
		return billID;
	}

	public void setBillID(Integer billID) {
		this.billID = billID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
}
