package com.dungnv.model;

public class InvalidAttributeException extends Exception {
	private String passwordInvalid;

	public InvalidAttributeException(String message, String passwordInvalid) {
		super(message);
		this.passwordInvalid = passwordInvalid;
	}

	public String getPasswordInvalid() {
		return passwordInvalid;
	}
}
