package edu.tridenttech.cpt237.insuranceagency.model;

public class Automobile {
	private final String make;
	private final String model;
	private final int year;
	private double value;
	
	public Automobile(String make, String model, int year, double value) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.value = value;
	}
	
	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public double getValue() {
		return value;
	}

}
