package com.mfidececchi.topic2;

public class PaymentLine {

	// Private instance variables
	private Item item;
	private int quantity;

	// Constructor
	public PaymentLine(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public double getTotal() {
		return quantity * item.getPrice();
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

}
