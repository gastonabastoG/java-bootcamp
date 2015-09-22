package com.mfidececchi.shoppingcart.api.services;

public class ShoppingCartFactory {

	private ShoppingCartFactory() {
	}

	public static ShoppingCart getLocalShoppingCart() {
		return new ShoppingCart();
	}

}
