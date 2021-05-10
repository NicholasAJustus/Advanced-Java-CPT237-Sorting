//Modified by Nicholas Justus
//Modified on 4/5/2021
package edu.tridenttech.cpt237.insuranceagency.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Agency {
	private static final double HOUSE_RATE = .0075;
	private static final double AUTOMOBILE_RATE = .045;
	private static final double JEWELRY_RATE = .005;
	private static final double BOAT_RATE = .07;

	private ArrayList<Insurable> insuredItems = new ArrayList<>();
	
	static public class CostComparer implements Comparator<Insurable> {
		@Override
		public int compare(Insurable o1, Insurable o2) {
			int relationship = (int) ((o1.getValue()*o1.getRate()) - (o2.getValue()*o2.getRate()));
			return relationship;
		}
	}

	public Agency(String itemListPath) throws FileNotFoundException {
		loadItems(itemListPath);
	}

	public void loadItems(String path) throws FileNotFoundException {
		Scanner input;
		File file = new File(path);
		input = new Scanner(file);

		while (input.hasNext()) {
			String record = input.nextLine();
			Insurable item = createItemFromRecord(record);
			if (item != null) {
				insuredItems.add(item);
			}
		}
		input.close();
	}

	public double getInsuranceCost(Insurable item) {
		return item.getRate() * item.getValue();
	}

	private Insurable createItemFromRecord(String record) {
		Insurable item = null;
		switch(Character.toUpperCase(record.charAt(0))) {
		case 'A':
			item = createAutomobileFromFields(record);
			break;
		case 'B':
			item = createBoatFromFields(record);
			break;
		case 'H':
			item = createHouseFromFields(record);
			break;
		case 'J':
			item = createJewelryFromFields(record);
			break;
		}
		return item;
	}
	
	private InsuredHouse createHouseFromFields(String record) {
		/* style, cost, sqFt, beds, bath */
		String[] fields = record.split(",");
		String style = fields[1];
		double cost = Double.parseDouble(fields[2]);
		int sqFt = Integer.parseInt(fields[3]);
		int beds = Integer.parseInt(fields[4]);
		int baths = Integer.parseInt(fields[5]);

		return new InsuredHouse(style, cost, sqFt, beds, baths, HOUSE_RATE);
	}
	
	private InsuredAutomobile createAutomobileFromFields(String record) {
		/* make, model, year, value */
		String[] fields = record.split(",");
		String make = fields[1];
		String model = fields[2];
		int year = Integer.parseInt(fields[3]);
		double value = Double.parseDouble(fields[4]);

		return new InsuredAutomobile(make, model, year, value, AUTOMOBILE_RATE);
	}
	
	private InsuredBoat createBoatFromFields(String record) {
		/* builder, length, year, value */
		String[] fields = record.split(",");
		String builder = fields[1];
		int length = Integer.parseInt(fields[2]);
		int year = Integer.parseInt(fields[3]);
		double value = Double.parseDouble(fields[4]);

		return new InsuredBoat(builder, length, year, value, BOAT_RATE);
	}
	
	private InsuredJewelry createJewelryFromFields(String record) {
		/* article, primary material, secondary material, value */
		String[] fields = record.split(",");
		String article = fields[1];
		String primaryMat = fields[2];
		String secondaryMat = fields[3];
		double value = Double.parseDouble(fields[4]);

		return new InsuredJewelry(article, primaryMat, secondaryMat, value, JEWELRY_RATE);
	}
	
	public List<Insurable> getInsuredItems() {
		return Collections.unmodifiableList(insuredItems);
	}

	public static Comparator<Insurable> getCostComparer() {
		return new CostComparer();
	}
	
}
