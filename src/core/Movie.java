package core;

public class Movie {
	public enum PriceCode {REGULAR, CHILDRENS, NEW_RELEASE};
	PriceCode priceCode;
	private String title;
	
	private Movie(String title, PriceCode priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public static Movie createRegularMovie(String title) {
		return new Movie(title, PriceCode.REGULAR);
	}

	public static Movie createChildrensMovie(String title) {
		return new Movie(title, PriceCode.CHILDRENS);
	}

	public static Movie createNewReleaseMovie(String title) {
		return new Movie(title, PriceCode.NEW_RELEASE);
	}

	public PriceCode getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(PriceCode priceCode) {
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}
}
