package com.point2;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

import com.point2.Item;

public class ItemTest {

	@Test
	public void setUp() {
		Item item = new Item("VGA adapter", new BigDecimal(7),"Thundervolt to VGA adapter");
		assertEquals("VGA adapter", item.getName());
		assertEquals(7, item.getPrice().intValue());
		assertEquals("Thundervolt to VGA adapter", item.getDescription());
	}
	
	@Test
	public void testPriceChange(){
		Item item = new Item("VGA adapter", new BigDecimal(7),"Thundervolt to VGA adapter");
		item.setPrice(new BigDecimal(8));
		assertEquals(8, item.getPrice().intValue());
	}
	
	@Test
	public void testToString(){
		Item item = new Item("VGA adapter", new BigDecimal(7),"Thundervolt to VGA adapter");
		assertEquals("VGA adapter - $7", item.toString());
	}

}
