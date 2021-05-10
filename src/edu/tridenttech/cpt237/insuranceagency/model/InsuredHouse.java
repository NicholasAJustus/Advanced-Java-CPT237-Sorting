//Modified by Nicholas Justus
//Modified on 4/5/2021
package edu.tridenttech.cpt237.insuranceagency.model;

public class InsuredHouse extends House implements Insurable {

	private static final String type = "House";
	private double rate;

	public InsuredHouse(String style, double baseBuilderCost, int squareFeet, int numBedrooms, int numBaths, double rate) {
		super(style, baseBuilderCost, squareFeet, numBedrooms, numBaths);
		this.rate = rate;
	}
	
	public String getName() {
		String name = String.format("%d/%d/%d %s (%d sqft)", getNumBedrooms(), getNumBaths(), getNumHalfBaths(), getStyle(), getSquareFeet());
		return name;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public double getRate() {
		return rate;
	}

	@Override
	public int compareTo(Insurable o) {
		int relationship = this.getName().compareTo(o.getName());
		return relationship;
	}
}