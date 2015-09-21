package com.conversions;

public class ArabicNumber {
	
	private final int arabic;
	private static int[] NUMBERS = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static String[] LETTERS = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public ArabicNumber(int arabicNumber) {
		this.arabic = arabicNumber;
	}
	
	public int getNumber(){
		return arabic;
	}
	
	public String toRoman() {
		String roman = "";
		int number = arabic;
		for (int i = 0; i < NUMBERS.length; i++) {
			while (number >= NUMBERS[i]) {
				roman += LETTERS[i];
				number -= NUMBERS[i];
			}
		}
		return roman;
	}

}
