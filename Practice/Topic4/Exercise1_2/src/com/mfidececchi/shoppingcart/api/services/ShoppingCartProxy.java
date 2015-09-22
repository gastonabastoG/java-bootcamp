package com.mfidececchi.shoppingcart.api.services;

import com.mfidececchi.shoppingcart.api.entities.Item;
import com.mfidececchi.shoppingcart.api.entities.PaymentType;

public class ShoppingCartProxy implements IShoppingCart {

	private ShoppingCart shoppingCart;

	protected void ShoppingCartProxy(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	@Override
	public boolean addPaymentLine(Item item, int quantity) {
		return this.shoppingCart.addPaymentLine(item, quantity);
	}

	@Override
	public boolean removePaymentLine(int index) {
		return shoppingCart.removePaymentLine(index);
	}

	@Override
	public boolean setPaymentType(PaymentType paymentType) {
		return shoppingCart.setPaymentType(paymentType);
	}

	@Override
	public PaymentType getPaymentType() {
		return shoppingCart.getPaymentType();
	}

	@Override
	public boolean checkout() {
		return shoppingCart.checkout();
	}

	@Override
	public void setTotal() {
		shoppingCart.setTotal();

	}

	@Override
	public double getTotal() {
		return shoppingCart.getTotal();
	}

}
