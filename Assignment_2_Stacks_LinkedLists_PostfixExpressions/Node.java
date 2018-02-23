/*
 * A hidden class used specifically for a linked
 * list that shares the same working directory.
 * Not publicly available.
 */
class Node {
	String item;
	Node next;

	Node(String item, Node next) {
		this.item = item;
		this.next = next;
	}

	Node(String item) {
		this(item,null);
	}

	Node() {
		this(null);
	}

	/* For those programmers who prefer gets and sets instead of the direct access
	 * to the data fields in this non-public class...
	 */
	String getItem() {
		return item;
	}
	void setItem(String update) {
		item = update;
	}
	Node getNext() {
		return next;	
	}
	void setNext(Node update) {
		next = update;
	}
}
