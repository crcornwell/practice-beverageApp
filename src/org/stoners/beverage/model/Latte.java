package org.stoners.beverage.model;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList; 

public class Latte extends Coffee {
	
	public Latte () {
		this.type = CoffeeType.LATTE;
	}
	
	@Override
	public List<CreamerType> getAvailableCreamer() {
		List<CreamerType> creamerTypes = new ArrayList<>(Arrays.asList(CreamerType.values()));
		creamerTypes.remove(CreamerType.NONE);
		return creamerTypes;
	}
}