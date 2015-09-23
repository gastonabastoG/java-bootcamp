package com.leap92.wordWrapper;

public class WordWrapper {
	
	private int rowLength;
	private String[] wordRows;
	private boolean withTrimming;

	public WordWrapper(int rowLength) {
		this.rowLength = rowLength;
	}

	public WordWrapper(int rowLength, boolean withTrimming) {
		this.rowLength = rowLength;
		this.withTrimming = withTrimming;
	}

	public String[] wrap(String textToWrap) {
		if (rowLength>=textToWrap.length()) { //if row length is longer than text
			wordRows = new String[1]; //instantiate the array with only 1 space
			wordRows[0] = textToWrap; //fill it with the full text
			return wordRows; //return row array
		}
		else if (withTrimming == true) {
			//Calculates the number of rows
			int rowNumber = (int) Math.ceil((double)textToWrap.length()/rowLength);
			wordRows = new String[rowNumber]; // instantiates the word array with rowNumber size
			String next = textToWrap; // temp String variable to store remaining String
			for (int i = 0; i < rowNumber - 1; i++) { // for each row in the word array
				wordRows[i] = next.substring(0, rowLength); //store first n characters
				next = next.substring(rowLength).trim(); //store remaining characters in temp variable trimming the spaces 
			}
			return wordRows;
		}
		else {
			return wordRows = textToWrap.split("(?<=\\G.{" + rowLength + "})");
		}
	}

}
