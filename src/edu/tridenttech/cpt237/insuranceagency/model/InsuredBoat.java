//Modified by Nicholas Justus
//Modified on 4/5/2021
package edu.tridenttech.cpt237.insuranceagency.model;

public class InsuredBoat extends Boat implements Insurable {
	
	private static final String type = "Boat";
	private double rate;
	
	public InsuredBoat(String builder, int length, int year, double value, double rate) {
		super(builder, length, year, value);
		this.rate = rate;
	}

	public String getName() {
		return String.format("%d' %d %s", getLength(), getYear(), getBuilder());
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
