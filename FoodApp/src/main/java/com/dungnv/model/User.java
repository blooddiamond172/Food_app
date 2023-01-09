package com.dungnv.model;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer userID;
	private String username;
	private String password;
	private String phoneNumber;
	private String address;
	
	public User() {
	}

	public User(String phoneNumber ,String password) {
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public User(Integer userID, 
			String password, 
			String phoneNumber) {
		this(phoneNumber, password);
		this.userID = userID;
	}

	public User(Integer userID,
			String username, 
			String phoneNumber, 
			String address) {
		this.userID = userID;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public User(String phoneNumber, 
			String username,
			String password, 
			String address) {
		this(phoneNumber, password);
		this.username = username;
		this.address = address;
	}
	
	public User(Integer userID,
			String username, 
			String password, 
			String phoneNumber, 
			String address) {
		this(userID, username, phoneNumber, address);
		this.password = password;
	}

	public Integer getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
