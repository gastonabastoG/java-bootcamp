package com.mf.shoppingcart.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.mfidececchi.shoppingcart.api.entities.Cash;
import com.mfidececchi.shoppingcart.api.entities.CreditCard;
import com.mfidececchi.shoppingcart.api.entities.Item;
import com.mfidececchi.shoppingcart.api.services.ShoppingCart;
import com.mfidececchi.shoppingcart.api.services.ShoppingCartFactory;

public class ShoppingCartTest {

	ShoppingCart sc;

	ArrayList<Item> stock;
	Item i1, i2, i3, i4, i5;

	@Before
	public void setUp() {
		sc = ShoppingCartFactory.getLocalShoppingCart();
		stock = new ArrayList<Item>();
		i1 = new Item("Coffee", 10.5, 100);
		i2 = new Item("Water", 6, 200);
		i3 = new Item("Milk", 16.5, 150);
		i4 = new Item("Orange Juice", 13.8, 300);
		i5 = new Item("Coca", 16.9, 310);
		stock.add(i1);
		stock.add(i2);
		stock.add(i3);
		stock.add(i4);
		stock.add(i5);
	}

	@Test
	public void testAddPaymentLine() {
		assertEquals(true, sc.addPaymentLine(i1, 5));
		assertEquals(false, sc.addPaymentLine(i1, 500));
	}

	@Test
	public void testRemovePaymentLine() {
		assertEquals(false, sc.removePaymentLine(0));

		sc.addPaymentLine(i1, 5);
		sc.addPaymentLine(i2, 10);
		assertEquals(true, sc.removePaymentLine(1));
		assertEquals(true, sc.removePaymentLine(0));
		assertEquals(false, sc.removePaymentLine(0));
	}

	@Test
	public void testSetPaymentType() {
		// test setPaymentType before of to checkout the cart.
		sc.addPaymentLine(i1, 10);
		assertEquals(true, sc.setPaymentType(new Cash()));
		assertEquals(true, sc.setPaymentType(new CreditCard("MasterdCard", 1010123123)));

		// checkout --> cart is paid.
		sc.checkout();
		assertEquals(false, sc.setPaymentType(new Cash()));
		assertEquals(false, sc.setPaymentType(new CreditCard("MasterdCard", 1010123123)));
	}

	@Test
	public void testCheckout() {
		// total = 0 , paymentType is not set
		assertEquals(false, sc.checkout());

		sc.setPaymentType(new Cash());
		// total = 0
		assertEquals(false, sc.checkout());

		sc.addPaymentLine(i4, 5);
		assertEquals(true, sc.checkout());
	}

	@Test
	public void testGetTotal() {

		assertEquals(0, sc.getTotal(), 0);

		sc.addPaymentLine(i1, 10);
		assertEquals(105, sc.getTotal(), 0);

		sc.addPaymentLine(i2, 3);
		assertEquals(123, sc.getTotal(), 0);

		sc.removePaymentLine(0);
		assertEquals(18, sc.getTotal(), 0);
	}

}
