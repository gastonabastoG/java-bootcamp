package com.leap92.RomanIntConverter;

public class Roman {
	
	private String roman;
	
	 private static int[] numbers = { 1000,  900,  500,  400,  100,   90,  50,   40,   10,    9,    5,    4,    1 };
          
	 private static String[] letters = { "M",  "CM",  "D",  "CD", "C",  "XC",  "L",  "XL",  "X",  "IX", "V",  "IV", "I" }; 
	
	

	public Roman(String roman) {
		try {
			//should check if its a "leqal" roman numbr
			this.roman = roman;
		}
		catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Roman(int integerNumber) {
		roman = "";
		int n = integerNumber;
		for (int i = 0; i < letters.length; i++) {
			while (n >= numbers[i]) {
				roman += letters[i];
				n -= numbers[i];
			}
		}
	}
	
	public String toString() {
		return this.roman;
	}
	
	public int toInt() {
		//returns value of the Roman numeral as an int
		int integerValue = 0;
		int i = 0;
		char ch;
		while (i < roman.length()) {
			ch = roman.charAt(i);
			int N = letterToNumber(ch);
			i++;
			if (i == roman.length()) {
				integerValue += N;
			}
			else {
				ch = roman.charAt(i);
				int nextNumber = letterToNumber(ch);
				if (nextNumber > N) {
					integerValue += (nextNumber - N);
					i++;
				}
				else {
					integerValue += N;
				}
			}
		}
		return integerValue;
		
	}
	
	private int letterToNumber(char letter) {
		switch (letter) {
        case 'I':  return 1;
        case 'V':  return 5;
        case 'X':  return 10;
        case 'L':  return 50;
        case 'C':  return 100;
        case 'D':  return 500;
        case 'M':  return 1000;
        default:   return -1;
        }
	}
}

	