package com.dungnv.model;

import java.io.Serializable;

public class Bill implements Serializable{
	private static final long serialVersionUID = 7L; 

	private Integer billID;
	private Product product;
	private User user;
	private Cart cart;
	
	public Bill() {
	}

	
	public Bill(Integer billID, Cart cart) {
		this.billID = billID;
		this.cart = cart;
	}


	public Bill(Integer billID, Product product, User user) {
		this.billID = billID;
		this.product = product;
		this.user = user;
	}
	

	public Bill(Integer billID, Product product, User user, Cart cart) {
		this.billID = billID;
		this.product = product;
		this.user = user;
		this.cart = cart;
	}


	public Integer getBillID() {
		return billID;
	}

	public void setBillID(Integer billID) {
		this.billID = billID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Cart getCart() {
		return cart;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
}
