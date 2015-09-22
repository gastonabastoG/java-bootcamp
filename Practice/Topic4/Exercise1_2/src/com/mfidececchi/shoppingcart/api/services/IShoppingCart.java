package com.mfidececchi.shoppingcart.api.services;

import com.mfidececchi.shoppingcart.api.entities.Item;
import com.mfidececchi.shoppingcart.api.entities.PaymentType;

public interface IShoppingCart {

	public boolean addPaymentLine(Item item, int quantity);

	public boolean removePaymentLine(int index);

	public boolean setPaymentType(PaymentType paymentType);

	public PaymentType getPaymentType();

	public boolean checkout();

	public void setTotal();

	public double getTotal();
}
