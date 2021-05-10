//Modified by Nicholas Justus
//Modified on 4/5/2021
package edu.tridenttech.cpt237.insuranceagency.model;

public class InsuredAutomobile extends Automobile implements Insurable {
	
	private static final String type = "Automobile";
	private double rate;

	public InsuredAutomobile(String make, String model, int year, double value, double rate) {
		super(make, model, year, value);
		this.rate = rate;
	}
	
	public String getName() {
		return String.format("%d %s %s", getYear(), getMake(), getModel());
	}

	@Override
	public int compareTo(Insurable o) {
		int relationship = this.getName().compareTo(o.getName());
		return relationship;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public double getRate() {
		return rate;
	}
}
