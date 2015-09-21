package com.conversions;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class AmountToTextConversorTest {

	@Test
	public void testAmountConversion1() {
		assertEquals("Two thousand five hundred twenty three and 4/100 dollars",
				new AmountToTextConversor().getDollarsAmount(new BigDecimal(2523.04)));
	}
	
	@Test
	public void testAmountConversion2() {
		assertEquals("One hundred twenty five and 70/100 dollars",
				new AmountToTextConversor().getDollarsAmount(new BigDecimal(125.70)));
	}
	
	@Test
	public void testAmountConversion3() {
		assertEquals("Sixty five thousand two hundred dollars",
				new AmountToTextConversor().getDollarsAmount(new BigDecimal(65200)));
	}

}
