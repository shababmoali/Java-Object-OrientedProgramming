/**
 * IllegalExpressionException indicates that an arithmetic expression
 * cannot be properly evaluated for any reason.
 */
public class IllegalExpressionException extends RuntimeException {

	/**
	 * Creates an exception related to an error in an arithmetic
	 * expression.
	 * @param msg Some information about the cause of the exception.
	 * The message can be one of the following:
	 *	<ul>
	 * <li>Mismatched parens</li>
	 * <li>Operand is not a number.</li>
	 * <li>Too many operands.</li>
	 * <li>Too few operands.</li>
	 * </ul>
	 */
	public IllegalExpressionException(String msg) {
		super(msg);
	}

	/**
	 * Creates an exception related to an error in an arithmetic
	 * expression.
	 */
	public IllegalExpressionException() {
		super();
	}
}
