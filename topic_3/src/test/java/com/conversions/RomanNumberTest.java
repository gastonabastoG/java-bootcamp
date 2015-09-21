package com.conversions;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumberTest {

	@Test
	public void testRomanToArabicConversion1() {
		assertEquals(1,new RomanNumber("I").toArabic());
	}
	
	@Test
	public void testRomanToArabicConversion2() {
		assertEquals(4,new RomanNumber("IV").toArabic());
	}
	
	@Test
	public void testRomanToArabicConversion3() {
		assertEquals(28,new RomanNumber("XXVIII").toArabic());
	}
	
	@Test
	public void testRomanToArabicConversion4() {
		assertEquals(1492,new RomanNumber("MCDXCII").toArabic());
	}
	
	@Test
	public void testRomanToArabicConversion5() {
		assertEquals(90,new RomanNumber("LXL").toArabic()); // a way of writing 90
	}
	
	@Test
	public void testRomanToArabicConversion6() {
		assertEquals(90,new RomanNumber("XC").toArabic()); // another way of writing 90
	}
	
	@Test
	public void testRomanToArabicConversion7() {
		assertEquals(9,new RomanNumber("IX").toArabic());
	}

}
