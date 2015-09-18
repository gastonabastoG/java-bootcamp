package mf.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import mf.java.WordWrapping;

public class WordWrapingTest {

	WordWrapping ww;
	String[] case0 = {};
	String[] case1 = { "CA", "P" };
	String[] case2 = { "ABCDEFGHIJKLMNOPQ" };
	String[] case3 = { "A B", "C D", "E F" };
	String[] case4 = { "Excel", "lent" };
	String[] case5 = { "Hello", "World!" };

	@Before
	public void setUp() {
		ww = new WordWrapping();
	}

	@Test
	public void test() {
		assertArrayEquals(case0, ww.wrap("                 ", 10));
		assertArrayEquals(case1, ww.wrap("     CA  P         ", 3));
		assertArrayEquals(case2, ww.wrap("ABCDEFGHIJKLMNOPQ", 30));
		assertArrayEquals(case3, ww.wrap("A B C D E F", 3));
		assertArrayEquals(case4, ww.wrap("Excellent", 5));
		assertArrayEquals(case5, ww.wrap("Hello World!", 7));
	}

}
