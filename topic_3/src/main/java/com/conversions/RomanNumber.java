package com.conversions;

public class RomanNumber {

	private final String roman;

	public RomanNumber(String romanNumber) {
		if (romanNumber.length() == 0) {
			throw new NumberFormatException("An empty string does not define a Roman numeral.");
		}
		this.roman = romanNumber.toUpperCase();
	}

	public String getNumber() {
		return roman;
	}

	public int toArabic() {
		int i = 0; // A position in the string romanNumber;
		int arabic = 0;
		while (i < roman.length()) {
			char letter = roman.charAt(i);
			int number = charToNumber(letter);
			if (number < 0)
				throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");
			i++; // Move on to next position in the string
			if (i == roman.length()) {
				arabic += number;
			} else {
				int nextNumber = charToNumber(roman.charAt(i));
				if (nextNumber > number) {
					arabic += (nextNumber - number);
					i++;
				} else
					arabic += number;
			}
		}

		return arabic;
	}

	private int charToNumber(char letter) {
		switch (letter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}

}
