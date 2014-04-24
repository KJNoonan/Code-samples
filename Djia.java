/**
 * @author Kevin Noonan 
 * An object class that holds the information for the Dowe
 * Jones Industrial Average, such as the day, the opening average, and
 * the closing average. Supports functions to return each of these
 * memebers, a compareTo implementaion and a ToString.
 * 
 * @param Date
 *            , opening, closing
 */
public class Djia implements Comparable<Djia> {
	private String date;
	private double open;
	private double close;

	/**
	 * Constructor - initializes the Djia with the variables suplied
	 * 
	 * @param String
	 *            for the date, double for the opening average, and double for
	 *            the closing
	 * */
	public Djia(String date, double opening, double closing) {
		this.date = date;
		open = opening;
		close = closing;
	}

	/**
	 * @returns the date member
	 * */
	public String date() {
		return date;
	}

	/**
	 * @returns the opening average
	 * */
	public double opening() {
		return open;
	}

	/**
	 * @returns the closing average
	 * */
	public double closing() {
		return close;
	}

	/**
	 * @returns a formated string built with the three members*/
	@Override
	public String toString() {
		return String.format("%11S %11.2f %11.2f", date, open, close);
	}

	/**
	 * @param Djia object that is created by this class object
	 * @returns -1 if the object is less than the other DjiaItem
	 * @returns 1 if the object is greater than the other DjiaItem
	 * @returns 0 if the object is equal than the other DjiaItem*/
	@Override
	public int compareTo(Djia djiaItem) {
		if (this.close < djiaItem.close) {
			return -1;
		} else if (this.close > djiaItem.close) {
			return 1;
		} else {
			return 0;
		}
	}

}