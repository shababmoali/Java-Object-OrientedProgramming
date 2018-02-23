/**
 * Memory.java
 * @version 1.0
 * @author Johannes Martin (?1997)
 * @version 1.1
 * @author Bette Bultena (contributed minor changes)
 */

/**
 * Memory maintains the current state of a string.
 */
public class Memory {
	StringBuilder display;

	/**
	 * Creates a Memory object.
	 */
	public Memory() {
		display = new StringBuilder();
	}

	/**
	 * Adds a character to the end of the current expression.
	 * @param c The character.
	 */
	public void addChar( char c ) {
		display.append(c);
	}

	/**
	 * Removes a character from the end of the current expression.
	 * Does nothing if there are no characters.
	*/
	public void removeChar() {
		display.deleteCharAt(display.length()-1);
	}

	/**
	 * Clears the current expression.
	 */
	public void clear() {
		display = new StringBuilder();
	}

	/**
	 * Sets the display value.
	 * @param value A number to display.
	 */
	public void setDisplay( double value ) {
		display = new StringBuilder(""+value);
	}

	/**
	 * Sets the display to the current error message.
	 * Although the string does not have to be an error message,
	 * that is what it is intended for.
	 * @param msg The message.
	 */
	public void setErrorMessage( String msg ) {
		display = new StringBuilder(msg);
	}

	/**
	 * @return The current value in memory.
	 */
	public String getDisplay() {
		return display.toString();
	}
	
	/**
	 * @return the contents of the memory object, as a string.
 	*/
	public String toString() {
		return display.toString();
	}
}

