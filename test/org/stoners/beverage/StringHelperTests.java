package org.stoners.beverage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.stoners.beverage.util.StringHelper;

public class StringHelperTests {

	@Test
	public void commaDelimit_discardsBlanks() {
		String result = StringHelper.commaDelimit("one", "two", "", "three");
		
		assertEquals("one, two, three", result);
	}
	
	@Test
	public void addArticle_preservesCapitalization() {
		String uncapitalized = StringHelper.addArticle("latte");
		String capitalized = StringHelper.addArticle("Orange juice");

		assertEquals("a latte", uncapitalized);
		assertEquals("An orange juice", capitalized);
	}
}
