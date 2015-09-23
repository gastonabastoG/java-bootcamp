package com.leap92.checkConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CheckConverter {
	
	
	private static final String[] units = new String[] {
			"", "one", "two","three", "four",
			"five", "six", "seven", "eight", "nine", "ten", 
			"eleven", "twelve", "thirteen", "fourteen", 
			"fifteen", "sixteen", "seventeen", "eighteen", 
			"nineteen"};
	
	private static final String[] tens = new String[] {
			"twenty", "thirty", "forty", "fifty", 
			"sixty", "seventy", "eighty", "ninety"
	};
	
	
	public String convertNumberToText(int i) {
		//Recursive method
		if (i<20) {
			return units[i];
		}
		else if (i<100) {
			return tens[i/10-2] + ((i % 10 != 0) ? "-" : "") + convertNumberToText(i % 10);
		}
		else if (i<1000) {
			return units[i/100] + " hundred" + 	((i % 100 != 0) ? " " : "") + convertNumberToText(i % 100);
		}
		
		else if (i<1000000) {
			return convertNumberToText(i/1000) + " thousand" + ((i % 1000 != 0) ? " " : "") + convertNumberToText(i % 1000);
		}
		else if (i<1000000000) {
			return convertNumberToText(i/1000000) + " million" + ((i % 1000000 != 0) ? " " : "") + convertNumberToText(i % 1000000);
		}
		else return "";
		//This can go on an on, for practical purposes
		//it doesn't work with billions (it's not necessary in this case)
	}


	public String getConvertedNumber(String number) {
		//Divides string input into decimal and fractional part
		String[] splittedNumber = number.split("\\.");
		
		BigDecimal decimal = new BigDecimal(splittedNumber[0]);
		BigDecimal real = new BigDecimal(number);
		BigDecimal fraction = real.subtract(decimal);
		
		//If the number doesn't has a fractional part,
		//it only calls the convert method
		if (fraction.equals(BigDecimal.ZERO)) {
			return convertNumberToText(real.intValueExact());
		}
		//If the number does have a fractional part,
		//it adds it at the end of the output string
		else {
			String s = convertNumberToText(decimal.intValueExact());
			s += " and " + fraction.multiply(new BigDecimal("100")).setScale(0, RoundingMode.HALF_UP) + "/100 dollars";
			return s;
		}
		
	}

	
}
