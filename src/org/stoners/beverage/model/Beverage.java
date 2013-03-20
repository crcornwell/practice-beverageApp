package org.stoners.beverage.model;

public class Beverage extends Product {

	Size size = Size.UNSPECIFIED;
	
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = (size != null ? size : Size.UNSPECIFIED);
	}
	public List<Size> getAvailableSizes() {
		List<Size> sizes = new ArrayList<>(Arrays.asList(Size.values));
		return sizes;
	}
}
