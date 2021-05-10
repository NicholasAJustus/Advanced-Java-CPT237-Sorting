//Modified by Nicholas Justus
//Modified on 4/5/2021
package edu.tridenttech.cpt237.insuranceagency;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import edu.tridenttech.cpt237.insuranceagency.model.Agency;
import edu.tridenttech.cpt237.insuranceagency.model.Insurable;

public class InsuranceManager {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		Agency agency = new Agency("insuredItems.txt");
		String menu =
				"N) Sort by Name\n" +
				"V) Sort by Value\n" +
				"T) Sort by Type\n" +
				"C) Sort by Cost\n" +
				"Q) Quit";
		String validInput = "NVTCQ";

		char userInput = getValidatedSelection(menu, validInput);

		while (userInput != 'Q') {
			List<Insurable> itemList = new ArrayList<Insurable>(agency.getInsuredItems()); 
			switch (userInput) {
				case 'N': {
					Collections.sort(itemList);
				} break;
				case 'V': {
					Collections.sort(itemList, new Comparator<Insurable>() {
						@Override
						public int compare(Insurable o1, Insurable o2) {
							int relationship = (int) (o1.getValue() - o2.getValue());
							return relationship;
						}});
				} break;
				case 'T': {
					Collections.sort(itemList, (o1, o2) -> o1.getType().compareToIgnoreCase(o2.getType()));
				} break;
				case 'C': {
					Comparator<Insurable> costComparer = Agency.getCostComparer();
					Collections.sort(itemList, costComparer);
				} break;
			}

			printList(agency, itemList);


			userInput = getValidatedSelection(menu, "NVTCQ");
		}
		System.out.println("DONE");
	}

	private static char getValidatedSelection(String prompt, String allowedChars) {
		char selected = getMenuSelection(prompt);
		while (allowedChars.indexOf(selected) < 0) {
			System.out.printf("%c is not a valid selection; please input a valid character.%n", selected);
			selected = getMenuSelection(prompt);
		}
		return selected;
	}
	
	private static char getMenuSelection(String prompt) {
		System.out.println(prompt);
		String response = input.nextLine();
		while (response.length() == 0 ) {
			System.out.println("Please input a value");
			System.out.println(prompt);
			response = input.nextLine();
		}
		return Character.toUpperCase(response.charAt(0));
	}

	private static void printList(Agency agency, List<Insurable> list) {
		System.out.printf("%-11s%-30s%15s%10s%n", "Type", "Name", "Value", "Cost");
		for (Insurable item : list) {
			System.out.printf("%-11s%-30s%15.2f%10.2f%n", item.getType(), item.getName(), item.getValue(), agency.getInsuranceCost(item));
		}
	}
}