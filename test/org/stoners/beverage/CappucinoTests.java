package org.stoners.beverage;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.stoners.beverage.model.Coffee;
import org.stoners.beverage.model.CoffeeType;
import org.stoners.beverage.model.Size;
import org.stoners.beverage.util.Choices;

public class CappucinoTests {

	Coffee cappucino;
	
	@Before
	public void setUp() {
		cappucino = new Coffee(CoffeeType.CAPPUCINO);
	}
	
	@Test
	public void cappucino_size_largeOnly() {
		List<Size> sizes = Choices.getSizes(cappucino);
		
		assertEquals(1, sizes.size());
		assertEquals(Size.LARGE, sizes.get(0));
	}
	
	@Test
	public void cappucino_whipped_trueOnly() {
		assertFalse(Choices.isWhippedSelectable(cappucino));
		assertTrue(Choices.getWhippedDefault(cappucino));
	}
	
	@Test
	public void cappucino_foamy_onlyOneWithFoamy() {
		for (CoffeeType each : CoffeeType.values()) {
			Coffee coffee = new Coffee(each);

			if (coffee.getType() == CoffeeType.CAPPUCINO) {
				assertTrue(Choices.isFoamySelectable(coffee));
			} else {
				assertFalse(Choices.isFoamySelectable(coffee));
				assertFalse(Choices.getFoamyDefault(cappucino));
			}
		}
	}
}
