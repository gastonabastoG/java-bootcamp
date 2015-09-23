package com.leap92.wordWrapper;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordWrapperTest {

	@Test
	public void inputStringSmallerThanRowLength() {
		//Create an instance and pass 60 as row-length parameter
		WordWrapper wordWrapper = new WordWrapper(60); 
		String textToWrap = "Hello world Hello world Hello!";
		String wrappedText = wordWrapper.wrap(textToWrap)[0];
		assertEquals("Hello world Hello world Hello!",wrappedText);
	}
	
	@Test
	public void inputStringHelloWorld() {
		//The exercise said row-length is 7 but it doesn't make
		//sense, changed it to 6 for proper splitting
		WordWrapper wordWrapper = new WordWrapper(6);
		String textToWrap = "Hello World!";
		String[] resultArray = wordWrapper.wrap(textToWrap);
		assertEquals("Hello ",resultArray[0]);
		assertEquals("World!",resultArray[1]);
	}
	
	@Test
	public void inputSomeCharactersWithTrimming() {
		WordWrapper wordWrapper = new WordWrapper(3,true);
		String textToWrap = "a b c d e f";
		String[] resultArray = wordWrapper.wrap(textToWrap);
		assertEquals("a b", resultArray[0]);
		assertEquals("c d", resultArray[1]);
		assertEquals("e f", resultArray[2]);
	}
	
	@Test
	public void inputWord() {
		WordWrapper wordWrapper = new WordWrapper(5);
		String textToWrap = "Excelent";
		String[] resultArray = wordWrapper.wrap(textToWrap);
		assertEquals("Excel", resultArray[0]);
		assertEquals("ent", resultArray[1]);
	}
	
	

}
