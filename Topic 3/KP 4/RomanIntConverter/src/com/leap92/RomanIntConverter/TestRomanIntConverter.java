package com.leap92.RomanIntConverter;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestRomanIntConverter {
	
	@Test
	public void createRomanNumber() {
		Roman romanNumber = new Roman("X");
		assertEquals("X", romanNumber.toString());
	}

	@Test
	public void convertRomanLetterToInt() {
		Roman romanNumber = new Roman("XX");
		assertEquals(20,romanNumber.toInt());
	}
	
	@Test
	public void convertIntToRoman() {
		Roman romanNumber = new Roman(25);
		assertEquals("XXV",romanNumber.toString());
		System.out.println(romanNumber.toString());
	}
		

}
