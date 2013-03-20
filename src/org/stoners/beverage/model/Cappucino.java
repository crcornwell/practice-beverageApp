
package org.stoners.beverage.model;

import java.util.List;
import java.util.ArrayList;

public class Cappucino extends Coffee {
	
	public Cappucino() {
		this.type = CoffeeType.CAPPUCINO;
		this.whipped = true;
	}
	
	@Override
	public List<RoastLevel> getAvailableRoastLevels() {
		List<RoastLevel> roasts = new ArrayList<>();
		roasts.add(RoastLevel.DARK);
		return roasts;
	}
	
	@Override
	public boolean getAvailableFoamy() {
		return true;
	}
	
	@Override
	public boolean getAvailableWhipped() {
		return false;
	}
}