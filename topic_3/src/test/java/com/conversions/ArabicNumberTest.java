package com.conversions;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArabicNumberTest {

	@Test
	public void testArabicToRomanConversion1() {
		assertEquals("IV", new ArabicNumber(4).toRoman());
	}
	
	@Test
	public void testArabicToRomanConversion2() {
		assertEquals("CDLV", new ArabicNumber(455).toRoman());
	}
	
	@Test
	public void testArabicToRomanConversion3() {
		assertEquals("III", new ArabicNumber(3).toRoman());
	}
	
	@Test
	public void testArabicToRomanConversion4() {
		assertEquals("MDLXIX", new ArabicNumber(1569).toRoman());
	}
	
	@Test
	public void testArabicToRomanConversion5() {
		assertEquals("XXXI", new ArabicNumber(31).toRoman());
	}
	
	@Test
	public void testArabicToRomanConversion6() {
		assertEquals("MCMXCI", new ArabicNumber(1991).toRoman());
	}

}
