package com.dungnv.model;

import java.io.Serializable;

public class UserCart implements Serializable {
	private static final long serialVersionUID = 5L; 
	
	private Integer cartID;
	private Integer userID;
	
	public UserCart() {
	}

	public UserCart(Integer cartID, Integer userID) {
		this.cartID = cartID;
		this.userID = userID;
	}

	public Integer getCartID() {
		return cartID;
	}

	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
}
