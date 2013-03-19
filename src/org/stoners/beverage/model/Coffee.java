package org.stoners.beverage.model;

import org.stoners.beverage.util.StringHelper;

public class Coffee extends Beverage {

	boolean caffeinated;
	int espressoShotCount;
	int sugarPacketCount;
	CreamerInfo creamerInfo;
	CoffeeType type;
	boolean foamy;
	boolean whipped;
	boolean containsEspresso;
	RoastLevel roastLevel;

	public Coffee() {
		// reference types, unlike primitive types, can be null, so it's good
		// to give them default values to avoid 'null-checking hell' later.
		// see setters, toString()
		this.type = CoffeeType.UNSPECIFIED;
		this.creamerInfo = new CreamerInfo();
		this.roastLevel = RoastLevel.UNSPECIFIED;
	}

	public Coffee(CoffeeType type) {
		this.type = type;
	}

	// simple example of overriding an inherited method.  all objects inherit toString() from Object,
	// which all classes implicitly extend, directly or ultimately.
	@Override
	public String toString() {
		// type can never be null because of default value, private field, and setter replacing nulls.
		// at least two null checks avoided, and possibly dozens more thru-out app
		String coffeeStr = type.toString().toLowerCase();
		coffeeStr = StringHelper.addArticle(coffeeStr);
		String roastStr = roastLevel.toString().toLowerCase() + "-roasted";
		String sugarStr = "";
		if (sugarPacketCount > 0) {
			sugarStr = "with " + sugarPacketCount + " packet(s) of sugar";
		}
		String caffeineStr = caffeinated ? "" : "decaf";
		String espressoStr = containsEspresso ? "and " + espressoShotCount + " shots of espresso" : "";
		String foamyStr = foamy ? "foamy" : "";
		String whippedStr = whipped ? "whipped" : "";
		String creamerStr = creamerInfo.getAmountInML() > 0 ? creamerInfo.getAmountInML() + "mL of " + creamerInfo.getType().toString() : "";
		
		// discards "" strings by default
		return StringHelper.commaDelimit(coffeeStr, caffeineStr, roastStr, foamyStr, whippedStr, sugarStr, creamerStr, espressoStr);
	}

	public boolean isCaffeinated() {
		return caffeinated;
	}

	public void setCaffeinated(boolean caffeinated) {
		this.caffeinated = caffeinated;
	}

	public int getEspressoShotCount() {
		return espressoShotCount;
	}

	public void setEspressoShotCount(int espressoShotCount) {
		this.espressoShotCount = espressoShotCount;
	}

	public int getSugarPacketCount() {
		return sugarPacketCount;
	}

	public void setSugarPacketCount(int sugarPacketCount) {
		this.sugarPacketCount = sugarPacketCount;
	}

	public CreamerInfo getCreamerInfo() {
		return creamerInfo;
	}

	public void setCreamerInfo(CreamerInfo creamerInfo) {
		this.creamerInfo = creamerInfo != null ? creamerInfo : new CreamerInfo();
	}

	public CoffeeType getType() {
		return type;
	}

	public void setType(CoffeeType type) {
		this.type = type != null ? type : CoffeeType.UNSPECIFIED;
	}

	public boolean isFoamy() {
		return foamy;
	}

	public void setFoamy(boolean foamy) {
		this.foamy = foamy;
	}

	public boolean isWhipped() {
		return whipped;
	}

	public void setWhipped(boolean whipped) {
		this.whipped = whipped;
	}

	public boolean hasEspresso() {
		return containsEspresso;
	}

	public void setHasEspresso(boolean containsEspresso) {
		this.containsEspresso = containsEspresso;
	}

	public RoastLevel getRoastLevel() {
		return roastLevel;
	}

	public void setRoastLevel(RoastLevel roastLevel) {
		this.roastLevel = roastLevel;
	}
}