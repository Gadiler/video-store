package core;

public class Rental {

	private Movie movie;
	private int daysRented;
	
	public Rental(Movie movie, int datsRented) {
		this.movie = movie;
		this.daysRented = datsRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public int getDaysRented() {
		return daysRented;
	}
}
