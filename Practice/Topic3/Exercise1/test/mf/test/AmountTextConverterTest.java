package mf.test;

import static org.junit.Assert.*;
import org.junit.*;
import mf.java.AmountTextConverter;

public class AmountTextConverterTest {

	private AmountTextConverter x;

	@Before
	public void setUp() {
		x = new AmountTextConverter();
	}

	@Test
	public void test() {
		// text converting
		assertEquals("zero", x.convert(0));
		assertEquals("two and 30/100 dollars", x.convert(2.3));
		assertEquals("eleven and 32/100 dollars", x.convert(11.32));
		assertEquals("one hundred ten and 00/100 dollars", x.convert(110));
		assertEquals("seven hundred twenty three and 06/100 dollars", x.convert(723.06));
		assertEquals("one thousand six hundred thirty two and 00/100 dollars", x.convert(1632));
	}

}
