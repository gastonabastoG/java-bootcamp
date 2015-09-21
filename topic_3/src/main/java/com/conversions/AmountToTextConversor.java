package com.conversions;

import java.math.BigDecimal;

public class AmountToTextConversor {
	private static final String[] 
			SPECIALNAMES = { "", " thousand", " million", " billion", " trillion", " quadrillion", " quintillion" },
			TENSNAMES = { "", " ten", " twenty", " thirty", " fourty", " fifty", " sixty", " seventy", " eighty",	" ninety" },
			NUMNAMES = { "", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine", " ten",	" eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen" };

	
	
	
	public String getDollarsAmount(BigDecimal amount) {
		// set whole part
		int whole = amount.intValue();
		String text = convert(whole);
		// add fractional part
		Double fractionalPart = getFractionalPart(amount);
		if (fractionalPart != 0)
			text = text + " and " + fractionalPart.intValue() + "/100";
		// add currency
		text = text + " dollars";
		return text;
	}

	
	private String convertLessThanOneThousand(int number) {
		String current;

		if (number % 100 < 20) {
			current = NUMNAMES[number % 100];
			number /= 100;
		} else {
			current = NUMNAMES[number % 10];
			number /= 10;

			current = TENSNAMES[number % 10] + current;
			number /= 10;
		}
		if (number == 0)
			return current;
		return NUMNAMES[number] + " hundred" + current;
	}

	private String convert(int number) {

		if (number == 0) {
			return "zero";
		}

		String current = "";
		int place = 0;

		do {
			int n = number % 1000;
			if (n != 0) {
				String s = convertLessThanOneThousand(n);
				current = s + SPECIALNAMES[place] + current;
			}
			place++;
			number /= 1000;
		} while (number > 0);

		// first letter to uppercase
		String first = current.substring(1, 2).toUpperCase();
		return (first + current.substring(2));
	}
	
	private Double getFractionalPart(BigDecimal amount){
		Double fractionalPart = ((amount.doubleValue() - amount.intValue()) * 100);	
		if ((0.5 + fractionalPart.byteValue()) < fractionalPart)
			fractionalPart = fractionalPart + 1;
		return fractionalPart;
	}

}
