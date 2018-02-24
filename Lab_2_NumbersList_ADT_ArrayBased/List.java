/**
 * List.java
 * A partially completed basic list interface for CSC115, 
 * The ADT is taken from the textbook for the 201701 version of this course.
 */


/**
 * ADT List is maintained as a linear data structure that contains String objects.
 * Basically a list should hold <i>any</i> element, but for exercise purposes, this one holds String objects.
 * The list is either empty or contains a first item and a last item, which are the same if the list contains only one
 * item.
 */
public interface List {

	/**
	 * @return True if there are no elements in the list, false if there are.
	 */
	public boolean isEmpty();

	/**
	 * @return The number of elements in the list.
	 */
	public int size();

	/**
	 * Adds an element to the end of the list, so it becomes the last item.
	 * After this method is completed, the previous last item is now the second to last.
	 * @param element The String to insert.
	 */
	public void append(String element);

	/**
	 * Adds an element to the front of the list, so it becomes the first item.
	 * After this method is completed, the previous first item is now the second.
	 * @param element The String to insert.
	 */
	public void prepend(String element);

	/**
	 * Returns a string representation of the list of elements in the list, in no particular order.
	 * The format of the string is as follows:
	 * <pre>List: size = [number of items]
	 * \t[firstItem]
	 * \t[more items if they exist in list]
	 * \t[lastItem]
	 * </pre>
	 * For instance, if the list is empty, the result is
	 * <pre>
	 * List: size = 0
	 * </pre>
	 * If the list contains three strings, depending on the actual items, the result looks something like:
	 * <pre>
	 * List: size = 3
	 * 	This is a sentence
	 * 	nonsense	
	 * 	The complete works of Shakespeare
	 * </pre>
	 */
	public String toString();

	/** 
	 * Returns the element at the given index position, where
  	 * the first element is at index 0.
	 * @param index The valid index position between 0 and size()-1 inclusive.
	 * Error checking for bad parameter is not done.
	 * @return A reference to the element at the given index position.
	 */
	public String findAtIndex(int index);
	
	/**
	 * Removes the element from the list that is equivalent to the given parameter.
	 * If the element is not in the list, then nothing changes.
	 * @param string The element equivalence to find.
	 */
	public void remove(String string);

	/**
	 * Adds an element to the list, so that it resides at the
	 * given index position.
	 * @param string The element to insert.
	 * @param indexPos The valid index position (0...size()) of the newly
	 * 	inserted string.
	 *		Note that if indexPos == size() then the new string will become the
	 *		last item in the list.
	 */
	public void insertAtPos(String string, int indexPos);
}