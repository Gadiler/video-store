package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import core.Customer;
import core.Movie;
import core.Rental;

public class CustomerStatementTests {

	@Test
	public void statementTest1() {
		Customer bilbo = createCustomer();
		StringBuffer expectedResult = new StringBuffer();
		expectedResult.append("Rental record for Bilbo Baggins\n");
		expectedResult.append("\tThe Godfather\t5.0\n");
		expectedResult.append("\tAmelie from Montmartre\t2.0\n");
		expectedResult.append("\tLa Vita e Bella\t5.0\n");
		expectedResult.append("\tLord of the Rings\t1.5\n");
		expectedResult.append("\tThe Ring\t6.0\n");
		expectedResult.append("Amount owed is 19.5\n");
		expectedResult.append("You earned 6 frequent renter points");

		assertEquals(expectedResult.toString(), bilbo.statement());
	}

	private Customer createCustomer() {
		Customer bilbo = new Customer("Bilbo Baggins");
		Movie m1 = Movie.createRegularMovie("The Godfather");
		Rental r1 = new Rental(m1,4);
		bilbo.addRental(r1);
		Movie m2 = Movie.createRegularMovie("Amelie from Montmartre");
		Rental r2 = new Rental(m2,2);
		bilbo.addRental(r2);
		Movie m3 = Movie.createRegularMovie("La Vita e Bella");
		Rental r3 = new Rental(m3,4);
		bilbo.addRental(r3);
		Movie m4 = Movie.createChildrensMovie("Lord of the Rings");
		Rental r4 = new Rental(m4,2);
		bilbo.addRental(r4);
		Movie m5 = Movie.createNewReleaseMovie("The Ring");
		Rental r5 = new Rental(m5,2);
		bilbo.addRental(r5);
		return bilbo;
	}
}
