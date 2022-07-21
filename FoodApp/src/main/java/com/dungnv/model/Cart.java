package com.dungnv.model;

import java.io.Serializable;

public class Cart implements Serializable {
	private static final long serialVersionUID = 4L;
	
	private Integer cartID;
	private Product product;
	private int quantity;
	private Integer newPrice;
	
	public Cart() {
	}
	
	
	public Cart(Integer cartID, Product product, int quantity) {
		this.cartID = cartID;
		this.product = product;
		this.quantity = quantity;
	}


	public Cart(Integer cartID, Product product, int quantity, Integer newPrice) {
		this.cartID = cartID;
		this.product = product;
		this.quantity = quantity;
		this.newPrice = newPrice;
	}

	public Integer getCartID() {
		return cartID;
	}

	public void setCartID(Integer cartID) {
		this.cartID = cartID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Integer newPrice) {
		this.newPrice = newPrice;
	}
}
