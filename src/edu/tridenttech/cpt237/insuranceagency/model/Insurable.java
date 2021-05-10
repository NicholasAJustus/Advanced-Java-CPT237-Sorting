//Modified by Nicholas Justus
//Modified on 4/5/2021
package edu.tridenttech.cpt237.insuranceagency.model;

public interface Insurable extends Comparable<Insurable> {
	String getName();
	String getType();
	double getValue();
	double getRate();
	int compareTo(Insurable insurable);
}