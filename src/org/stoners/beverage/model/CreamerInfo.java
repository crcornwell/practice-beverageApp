package org.stoners.beverage.model;

public class CreamerInfo {
	CreamerType type = CreamerType.UNSPECIFIED;
	float amountInML;

	public CreamerType getType() {
		return type;
	}
	public void setType(CreamerType type) {
		this.type = type != null ? type : CreamerType.UNSPECIFIED;
	}
	public float getAmountInML() {
		return amountInML;
	}
	public void setAmountInML(float amountInML) {
		this.amountInML = amountInML;
	}
}