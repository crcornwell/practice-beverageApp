
package org.stoners.beverage.model;

import java.util.ArrayList;
import java.util.List;


public class Mocha extends Coffee {
	
	public Mocha() {
		this.type = CoffeeType.MOCHA;
	}

	@Override
	public List<Size> getAvailableSizes() {
		List<Size> sizes = new ArrayList<>();
		sizes.add(Size.LARGE);
		return sizes;
	}
	
	@Override
	public List<RoastLevel> getAvailableRoastLevels() {
		List<RoastLevel> roastLevels = new ArrayList<>();
		roastLevels.add(RoastLevel.DARK);
		return roastLevels;
	}
}