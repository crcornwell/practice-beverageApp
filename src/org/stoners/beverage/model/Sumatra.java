package org.stoners.beverage.model;

import java.util.ArrayList;
import java.util.List;

public class Sumatra extends Coffee {
	
	public Sumatra() {
		this.type = CoffeeType.SUMATRA;
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