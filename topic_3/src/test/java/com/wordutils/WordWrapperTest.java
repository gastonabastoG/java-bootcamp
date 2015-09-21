package com.wordutils;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordWrapperTest {

	@Test
	public void testWordWrapper1() {
		assertEquals("should be equal", new WordWrapper().wrap("should be equal", 60));
	}

	@Test
	public void testWordWrapper2() {
		String separator = System.lineSeparator();
		assertEquals("Hello" + separator + "World!", new WordWrapper().wrap("Hello World!", 7));
	}

	@Test
	public void testWordWrapper3() {
		String separator = System.lineSeparator();
		assertEquals("a b" + separator + "c d" + separator + "e f", new WordWrapper().wrap("a b c d e f", 3));
	}

	@Test
	public void testWordWrapper4() {
		String separator = System.lineSeparator();
		assertEquals("Excel" + separator + "ent", new WordWrapper().wrap("Excelent", 5));
	}

}
