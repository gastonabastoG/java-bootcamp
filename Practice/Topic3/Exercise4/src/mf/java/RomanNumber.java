package mf.java;

import java.util.Hashtable;

public class RomanNumber {

	private static Hashtable<Character, Integer> ht;

	static private void initHashtable() {
		ht = new Hashtable<Character, Integer>();
		ht.put('I', 1);
		ht.put('X', 10);
		ht.put('C', 100);
		ht.put('M', 1000);
		ht.put('V', 5);
		ht.put('L', 50);
		ht.put('D', 500);
	}

	// method that returns an integer that represents the Roman number provided
	// as parameter.
	// if the parameter is wrong Roman number, the function returns0.
	public static int getInteger(String num) {

		if (ht == null) {
			initHashtable();
		}

		int intNum = 0;
		int prev = 0;
		for (int i = num.length() - 1; i >= 0; i--) {
			int temp = ht.get(num.charAt(i));
			if (temp < prev)
				intNum -= temp;
			else
				intNum += temp;
			prev = temp;
		}

		if (getRoman(intNum).equals(num)) {
			// verify the integrity of writing. example: a "XXD" input returns 0
			// because is wrong Roman number.
			return intNum;
		} else {
			return 0;
		}

	}

	// method that returns a string that represents the Roman number provided as
	// parameter.
	public static String getRoman(int number) {
		if (number > 0 && number < 4000) {
			String s = "";
			while (number >= 1000) {
				s += "M";
				number -= 1000;
			}
			while (number >= 900) {
				s += "CM";
				number -= 900;
			}
			while (number >= 500) {
				s += "D";
				number -= 500;
			}
			while (number >= 400) {
				s += "CD";
				number -= 400;
			}
			while (number >= 100) {
				s += "C";
				number -= 100;
			}
			while (number >= 90) {
				s += "XC";
				number -= 90;
			}
			while (number >= 50) {
				s += "L";
				number -= 50;
			}
			while (number >= 40) {
				s += "XL";
				number -= 40;
			}
			while (number >= 10) {
				s += "X";
				number -= 10;
			}
			while (number >= 9) {
				s += "IX";
				number -= 9;
			}
			while (number >= 5) {
				s += "V";
				number -= 5;
			}
			while (number >= 4) {
				s += "IV";
				number -= 4;
			}
			while (number >= 1) {
				s += "I";
				number -= 1;
			}
			return s;
		}
		return null;
	}

}