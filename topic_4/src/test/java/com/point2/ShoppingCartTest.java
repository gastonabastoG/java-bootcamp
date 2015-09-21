package com.point2;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.point2.CreditCardPayment;
import com.point2.Item;
import com.point2.ShoppingCart;

public class ShoppingCartTest {

	@Test
	public void testEmptyCart() {
		ShoppingCart cart = new ShoppingCart();
		assertEquals(true, cart.isEmpty());
		Item item = new Item("VGA adapter", new BigDecimal(7), "Thundervolt to VGA adapter");
		cart.addItem(item, 1);
		assertEquals(false, cart.isEmpty());
		cart.emptyCart();
		assertEquals(true, cart.isEmpty());
	}

	@Test
	public void testAddItem() {
		ShoppingCart cart = new ShoppingCart();
		Item item = new Item("VGA adapter", new BigDecimal(7), "Thundervolt to VGA adapter");
		cart.addItem(item, 1);
		assertEquals(true, cart.contains(item));
	}

	@Test
	public void testAddManyItems() {
		ShoppingCart cart = new ShoppingCart();
		Item item = new Item("VGA adapter", new BigDecimal(7), "Thundervolt to VGA adapter");
		cart.addItem(item, 3);
		assertEquals(3, cart.getItemQuantity(item));
	}

	@Test
	public void testDeleteItem() {
		ShoppingCart cart = new ShoppingCart();
		Item item = new Item("VGA adapter", new BigDecimal(7), "Thundervolt to VGA adapter");
		cart.addItem(item, 2);
		cart.removeItem(item);
		assertEquals(1, cart.getItemQuantity(item));
		cart.removeItem(item);
		assertEquals(false, cart.contains(item));
	}

	@Test
	public void testDeleteByIndex() {
		ShoppingCart cart = new ShoppingCart();
		Item item = new Item("VGA adapter", new BigDecimal(7), "Thundervolt to VGA adapter");
		cart.addItem(item, 1);
		cart.remove(0);
		assertEquals(false, cart.contains(item));
	}

	@Test
	public void testNullPayment() {
		ShoppingCart cart = new ShoppingCart();
		assertEquals(null, cart.getPayment());
	}

	@Test
	public void testCheckOutFail() {
		ShoppingCart cart = new ShoppingCart();
		Item item = new Item("VGA adapter", new BigDecimal(7), "Thundervolt to VGA adapter");
		cart.addItem(item, 3);
		cart.checkOut();
		assertEquals(false, cart.isPaid()); // because there is no payment assigned
	}
	
	@Test
	public void testCheckOut() {
		ShoppingCart cart = new ShoppingCart();
		Item item = new Item("VGA adapter", new BigDecimal(7), "Thundervolt to VGA adapter");
		cart.addItem(item, 3);
		cart.setPayment(new CreditCardPayment());
		cart.checkOut();
		assertEquals(true, cart.isPaid());
	}

}
