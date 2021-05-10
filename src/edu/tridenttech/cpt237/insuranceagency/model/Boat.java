package edu.tridenttech.cpt237.insuranceagency.model;

public class Boat {
	private final int length;
	private final String builder;
	private final int year;
	private double value;
	public Boat(String builder, int length, int year, double value) {
		this.length = length;
		this.builder = builder;
		this.value = value;
		this.year = year;
	}

	public double getValue() {
		return value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public int getLength() {
		return length;
	}
	
	public String getBuilder() {
		return builder;
	}
	
	public int getYear() {
		return year;
	}

}
