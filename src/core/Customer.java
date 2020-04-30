package core;

import java.util.ArrayList;
import java.util.List;

import core.Movie.PriceCode;

public class Customer {

	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();
	
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		StringBuffer result = new StringBuffer("Rental record for " + getName() + "\n");
		for (Rental each : rentals) {
			double thisAmount = 0;
			
			//determine amounts for each line
			switch (each.getMovie().getPriceCode()) {
			case REGULAR:
				thisAmount += 2;
				if (each.getDaysRented() > 2)
					thisAmount += (each.getDaysRented() - 2) * 1.5;
				break;
			case NEW_RELEASE:
				thisAmount += each.getDaysRented() * 3;
				break;
			case CHILDRENS:
				thisAmount += 1.5;
				if (each.getDaysRented() > 3)
					thisAmount += (each.getDaysRented() - 3) * 1.5;
				break;
			}

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((each.getMovie().getPriceCode() == PriceCode.NEW_RELEASE) &&
				each.getDaysRented() > 1) frequentRenterPoints++;
			
			//show figures for this rental
			result.append("\t" + each.getMovie().getTitle() + "\t" +
					String.valueOf(thisAmount) + "\n");
			totalAmount += thisAmount;
		}
		//add footer lines
		result.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
		result.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
		return result.toString();
	}

}
