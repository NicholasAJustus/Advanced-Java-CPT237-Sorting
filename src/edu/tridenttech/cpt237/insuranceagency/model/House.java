package edu.tridenttech.cpt237.insuranceagency.model;

public class House {
	private static final double BED_UPCOST = 40.0;
	private static final double BATH_UPCOST = 30.0;
	private static final double HALF_BATH_UPCOST = 15.0;

	private final String style;
	private double baseBuilderCost;
	private int numBedrooms;
	private int numBaths;
	private int numHalfBaths;
	private int squareFeet;

	public House(String style, double baseBuilderCost, int squareFeet, int numBedrooms, int numBaths) {
	    this(style, baseBuilderCost, squareFeet, numBedrooms, numBaths, 0);
	}

	public House(String style, double baseBuilderCost, int squareFeet, int numBedrooms, int numBaths, int numHalfBaths) {
		this.style = style;
		this.baseBuilderCost = baseBuilderCost;
		this.numBedrooms = numBedrooms;
		this.numBaths = numBaths;
		this.squareFeet = squareFeet;
		this.numHalfBaths = numHalfBaths;
	}

	public double getValue() {
		double value = baseBuilderCost * squareFeet;
		value += (numBedrooms * BED_UPCOST) * baseBuilderCost;
		value +=  (numBaths * BATH_UPCOST) * baseBuilderCost;
		value +=  (numHalfBaths * HALF_BATH_UPCOST) * baseBuilderCost;
		return value;
	}

	public double getBaseBuilderCost() {
		return baseBuilderCost;
	}

	public void setBaseBuilderCost(double baseBuilderCost) {
		this.baseBuilderCost = baseBuilderCost;
	}

	public int getNumBedrooms() {
		return numBedrooms;
	}

	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
	}

	public int getNumBaths() {
		return numBaths;
	}

	public void setNumBaths(int numBaths) {
		this.numBaths = numBaths;
	}

	public int getNumHalfBaths() {
		return numHalfBaths;
	}

	public void setNumHalfBaths(int numHalfBaths) {
		this.numHalfBaths = numHalfBaths;
	}

	public int getSquareFeet() {
		return squareFeet;
	}

	public void setSquareFeet(int squareFeet) {
		this.squareFeet = squareFeet;
	}

	public String getStyle() {
		return style;
	}
}
