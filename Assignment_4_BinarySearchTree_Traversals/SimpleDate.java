/**
 * SimpleDate.java
 * @author B. Bultena
 *
 * For use with Assignment #4, UVic CSC115 (Spring 2018)
 * University of Victoria.
 */

/**
 * Class SimpleDate is a very simple version of a day in a Gregorian Calender.
 * It is limited to a year after 1999, and does not include time.
 * It has no capability to do any date arithmetic, and does not check leap years.
 */
public class SimpleDate {
	private int year = 2018;
	private int month = 1;
	private int day = 1;

	private static final int[] daysInMonth = {31,29,31,30,31,30,31,31,30,31,30,31};


	/**
	 * Creates a SimpleDate.
	 * @param year The year (from 1999 to the current year).
	 * @param month The month (from 1 to 12).
	 * @param day The day of the month.
	 * @throws RuntimeException if any of the parameters are out of bounds.
 	 */
	public SimpleDate(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}

	/**
	 * Creates a default date of January 1, 2018.
	 */
	public SimpleDate() {
		// keeps the defaults
	}

	/**
	 * Sets the year.
	 * @param year The year (from 1999 to the current year).
	 * @throws RuntimeException if the year is not valid.
	 */
	public void setYear(int year) {
		if (year < 1999 || year > 2018) {
			throw new RuntimeException("not a valid year");
		}
		this.year = year;
	}

	/**
	 * Sets the month.
	 * @param month The month (from 1 to 12).
	 * @throws RuntimeException if the month is not valid.
	 */
	public void setMonth(int month) {
		if (month < 1 || month > 12) {
			throw new RuntimeException("not a valid month");
		}
		this.month = month;
	}

	/**
	 * Sets the day.
	 * @param day The day of the month.
	 * @throws RuntimeException if the day is not valid.
	 */
	public void setDay(int day) {
		if (day < 1 || day > daysInMonth[month-1]) {
			throw new RuntimeException("not a valid day");
		}
	}

	/**
	 * @return A formatted string of the day in yyyy/mm/dd format.
	 */
	public String toString() {
		return year+"/"+month+"/"+day;
	}
}
		
		
