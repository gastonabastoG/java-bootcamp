package com.mfidececchi.topic2;

public class Paypal extends PaymentType {

	// private instance variables
	private String email;
	private String password;

	// Constructor
	public Paypal(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	// getters
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Paypal @ "+getEmail();		
	}

	
}
