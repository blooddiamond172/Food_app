package com.dungnv.model;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private String productID;
	private String name;
	private Integer price;
	private String imageLink;
	private String shortDescription;
	
	public Product() {
	}

	public Product(String productID, String name,
			Integer price, String imageLink,
			String shortDescription) {
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.imageLink = imageLink;
		this.shortDescription = shortDescription;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
}
