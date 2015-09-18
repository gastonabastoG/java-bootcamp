package mf.test;

import static org.junit.Assert.*;

import org.junit.Test;

import mf.java.RomanNumber;

public class RomanNumberTest {

	@Test
	public void testIntToRoman() {
		// Integer to Roman testing
		assertEquals("I", RomanNumber.getRoman(1));
		assertEquals("V", RomanNumber.getRoman(5));
		assertEquals("X", RomanNumber.getRoman(10));
		assertEquals("L", RomanNumber.getRoman(50));
		assertEquals("C", RomanNumber.getRoman(100));
		assertEquals("D", RomanNumber.getRoman(500));
		assertEquals("M", RomanNumber.getRoman(1000));
		assertEquals("IV", RomanNumber.getRoman(4));
		assertEquals("MCLIII", RomanNumber.getRoman(1153));
		assertEquals("CMXCIX", RomanNumber.getRoman(999));
		assertEquals("MMMCMVII", RomanNumber.getRoman(3907));
	}

	@Test
	public void testRomanToInt() {
		// Roman to Integer testing
		assertEquals(1, RomanNumber.getInteger("I"));
		assertEquals(5, RomanNumber.getInteger("V"));
		assertEquals(10, RomanNumber.getInteger("X"));
		assertEquals(50, RomanNumber.getInteger("L"));
		assertEquals(100, RomanNumber.getInteger("C"));
		assertEquals(500, RomanNumber.getInteger("D"));
		assertEquals(1000, RomanNumber.getInteger("M"));
		assertEquals(4, RomanNumber.getInteger("IV"));
		assertEquals(1153, RomanNumber.getInteger("MCLIII"));
		assertEquals(999, RomanNumber.getInteger("CMXCIX"));
		assertEquals(3907, RomanNumber.getInteger("MMMCMVII"));
		assertEquals(490, RomanNumber.getInteger("CDXC"));
	}

}
