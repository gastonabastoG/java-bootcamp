package com.leap92.checkConverter;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestCheckConverter {

	//Tests that try to convert a number with
	//a certain number of digits
	@Test
	public void convertOneUnitNumberToText() {
		CheckConverter converter = new CheckConverter();
		String text = converter.convertNumberToText(2);
		assertEquals("two", text);
	}
	
	@Test
	public void convertTwoUnitsNumberToText() {
		CheckConverter converter = new CheckConverter();
		String text = converter.convertNumberToText(52);
		assertEquals("fifty-two", text);
	}
	
	@Test
	public void convertThreeUnitsNumberToText() {
		CheckConverter converter = new CheckConverter();
		String text = converter.convertNumberToText(572);
		assertEquals("five hundred seventy-two", text);
	}
	
	@Test
	public void convertFourUnitsNumberToText() {
		CheckConverter converter = new CheckConverter();
		String text = converter.convertNumberToText(5325);
		assertEquals("five thousand three hundred twenty-five", text);
	}
	
	@Test
	public void convertFiveUnitsNumberToText() {
		CheckConverter converter = new CheckConverter();
		String text = converter.convertNumberToText(75325);
		assertEquals("seventy-five thousand three hundred twenty-five", text);
	}
	
	@Test
	public void convertSevenUnitsNumberToText() {
		CheckConverter converter = new CheckConverter();
		String text = converter.convertNumberToText(1253864);
		assertEquals("one million two hundred fifty-three thousand eight hundred sixty-four", text);
	}
	
	//Test that tries to convert
	//a number with a fractional part
	@Test
	public void passNumberWithFractionalAndConvert () {
		String number = "2953.03" ;
		CheckConverter converter = new CheckConverter();
		String text = converter.getConvertedNumber(number);
		assertEquals("two thousand nine hundred fifty-three and 3/100 dollars",text);
		
		number = "4835";
		text = converter.getConvertedNumber(number);
		assertEquals("four thousand eight hundred thirty-five",text);
		
		
	}

}
