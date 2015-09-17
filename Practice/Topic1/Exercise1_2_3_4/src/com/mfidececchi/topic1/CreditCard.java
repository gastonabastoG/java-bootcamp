package com.mfidececchi.topic1;

public class CreditCard extends PaymentType {

	// private instance variables
	private String name;
	private int number;

	// Constructor
	public CreditCard(String name, int number) {
		this.name = name;
		this.number = number;
	}

	// getters
	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "CreditCard @ "+getName()+" "+getNumber();		
	}

}
