package mf.java;

import java.util.ArrayList;

public class WordWrapping {

	ArrayList<String> wordsList;
	String strAux;

	public String[] wrap(String strAux, int rowLength) {

		wordsList = new ArrayList<String>();
		strAux = strAux.trim(); // remove first and last spaces
		String wordAux = ""; // creates and assigns new word

		while (strAux.length() != 0) {

			if (strAux.length() <= rowLength) {
				wordAux = strAux; // generates last word
			} else {
				wordAux = strAux.substring(0, rowLength);
				// if the string continue with a character after word
				if (strAux.charAt(rowLength) != ' ') {
					// find last space in word for cut
					int spaceIndex = wordAux.lastIndexOf(' ');
					// found
					if (spaceIndex != -1) {
						wordAux = strAux.substring(0, spaceIndex);
					} else {
						wordAux = strAux.substring(0, rowLength);
					}
				} else {
					wordAux = strAux.substring(0, rowLength);
				}
			}

			wordAux = wordAux.trim();
			// remove wordAux from strAux
			strAux = strAux.substring(wordAux.length()).trim();
			// add wordAux to list
			wordsList.add(wordAux);
		}

		return generateStringArray(wordsList);

	}

	// method that generates an array of strings whit the word list, and returns
	// it.
	private String[] generateStringArray(ArrayList<String> arrayList) {
		String[] array = new String[arrayList.size()];
		int count = 0;
		for (String s : arrayList) {
			array[count] = s;
			count++;
		}
		return array;
	}

}
