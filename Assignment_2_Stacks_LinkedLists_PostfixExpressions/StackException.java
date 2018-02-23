
/**
 * StackException indicates that a stack operation cannot complete
 * due to the condition of the stack, mostly when trying to access an
 * element on an empty stack.
 */
public class StackException extends RuntimeException {

	/**
	 * Creates an exception related to an action being unable to complete on a stack.
	 * @param msg Some information about the cause of the exception
	 */
	public StackException(String msg) {
		super(msg);
	}

	/**
	 * Creates an exception related to an action being unable to complete on a stack.
	 */
	public StackException() {
		super();
	}
}
