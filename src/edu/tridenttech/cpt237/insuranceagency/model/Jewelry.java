package edu.tridenttech.cpt237.insuranceagency.model;

public class Jewelry {
	private final String typeOfPiece;
	private final String primaryMaterial;
	private final String secondaryMaterial;
	private double appraisedValue;
	
	public Jewelry(String typeOfPiece, String primaryMaterial, String secondaryMaterial, double appraisedValue) {
		this.typeOfPiece = typeOfPiece;
		this.primaryMaterial = primaryMaterial;
		this.secondaryMaterial = secondaryMaterial;
		this.appraisedValue = appraisedValue;
	}

	public double getAppraisedValue() {
		return appraisedValue;
	}
	public void setAppraisedValue(double appraisedValue) {
		this.appraisedValue = appraisedValue;
	}
	public String getTypeOfPiece() {
		return typeOfPiece;
	}
	public String getPrimaryMaterial() {
		return primaryMaterial;
	}
	public String getSecondaryMaterial() {
		return secondaryMaterial;
	}

}
