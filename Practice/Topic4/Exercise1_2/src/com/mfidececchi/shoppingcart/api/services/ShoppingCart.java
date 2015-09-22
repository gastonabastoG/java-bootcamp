package com.mfidececchi.shoppingcart.api.services;

import java.util.ArrayList;

import com.mfidececchi.shoppingcart.api.entities.Item;
import com.mfidececchi.shoppingcart.api.entities.PaymentLine;
import com.mfidececchi.shoppingcart.api.entities.PaymentType;

public class ShoppingCart implements IShoppingCart {

	private final ArrayList<PaymentLine> cart;
	private PaymentType paymentType;
	private boolean paid;
	private double total;

	public ShoppingCart() {
		cart = new ArrayList<PaymentLine>();
		paymentType = null;
		paid = false;
		total = 0;
	}

	@Override
	public boolean addPaymentLine(Item item, int quantity) {
		if (quantity <= item.getQuantity()) {
			cart.add(new PaymentLine(item, quantity));
			setTotal();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean removePaymentLine(int index) {
		if (index >= 0 && index <= cart.size() - 1) {
			cart.remove(index);
			setTotal();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean setPaymentType(PaymentType paymentType) {
		if (!paid) {
			this.paymentType = paymentType;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public PaymentType getPaymentType() {
		return paymentType;
	}

	@Override
	public boolean checkout() {
		if (paymentType != null && !paid && total > 0) {
			paid = true;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setTotal() {
		this.total = 0;
		for (PaymentLine i : cart) {
			total += i.getTotal();
		}
	}

	@Override
	public double getTotal() {
		return total;
	}
}