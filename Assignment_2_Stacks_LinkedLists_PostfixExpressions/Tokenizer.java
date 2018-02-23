import java.util.Iterator;

/**
 * Tokenizer is an immutable list of String elements that can be accessed
 * in order.
 */
public interface Tokenizer extends Iterator<String> {

	/**
	 * Provides a string representation of the all the elements in
	 * the list, from first to last.
	 * @return The formatted string.
	 */
	public String toString();

	/**
	 * Sets the iterator start position for the first item in the list.
	 */
	public void reset();

	/**
	 * @return The number of tokens in the list.
	 */
	public int numTokens();
}

	
