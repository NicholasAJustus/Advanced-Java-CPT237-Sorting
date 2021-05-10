//Modified by Nicholas Justus
//Modified on 4/5/2021
package edu.tridenttech.cpt237.insuranceagency.model;

public class InsuredJewelry extends Jewelry implements Insurable {
	
	private static final String type = "Jewelry";
	double rate;
	
	public InsuredJewelry(String typeOfPiece, String primaryMaterial, String secondaryMaterial, double appraisedValue, double rate) {
		super(typeOfPiece, primaryMaterial, secondaryMaterial, appraisedValue);
		this.rate = rate;
	}
	
	public String getName() {
		return String.format("%s %s", getPrimaryMaterial(), getTypeOfPiece());
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
	public double getValue() {
		return getAppraisedValue();
	}

	@Override
	public double getRate() {
		return rate;
	}

}
