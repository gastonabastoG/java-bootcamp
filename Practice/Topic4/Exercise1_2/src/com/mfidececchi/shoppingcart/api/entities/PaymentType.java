package com.mfidececchi.shoppingcart.api.entities;

/** Abstract Class */
public abstract class PaymentType {

	// method to be inherited and overwritten in the subclasses
	// the purpose is to return the payment type description
	public abstract String toString();

}
