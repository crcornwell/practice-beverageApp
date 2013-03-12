package org.stoners.beverage;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.stoners.beverage.model.Coffee;
import org.stoners.beverage.model.CoffeeType;
import org.stoners.beverage.model.RoastLevel;
import org.stoners.beverage.model.Size;
import org.stoners.beverage.util.Choices;

public class MochaTests {

	Coffee mocha;
	
	@Before
	public void setUp() {
		mocha = new Coffee(CoffeeType.MOCHA);
	}
	
	@After
	public void tearDown() {

	}
	
	@Test
	public void mocha_size_largeOnly() {
		List<Size> sizes = Choices.getSizes(mocha);
		
		assertEquals(1, sizes.size());
		assertEquals(Size.LARGE, sizes.get(0));
	}
	
	@Test
	public void mocha_roast_darkOnly() {
		List<RoastLevel> roasts = Choices.getRoastLevels(mocha);
		
		assertEquals(1, roasts.size());
		assertEquals(RoastLevel.DARK, roasts.get(0));
	}
	
	@Test
	public void mocha_caffeine_decafAndFullOnly() {
		// TODO
	}
}
