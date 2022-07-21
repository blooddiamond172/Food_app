package com.dungnv.model;

import java.io.Serializable;

public class Comment implements Serializable {
	private static final long serialVersionUID = 3L; 
	
	private Integer userID;
	private String username;
	private String productID;
	private String comment;
	
	public Comment() {
	}

	public Comment(Integer userID, String productID, String comment) {
		this.userID = userID;
		this.productID = productID;
		this.comment = comment;
	}
	

	public Comment(Integer userID, String username, String productID, String comment) {
		this.userID = userID;
		this.username = username;
		this.productID = productID;
		this.comment = comment;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
}
