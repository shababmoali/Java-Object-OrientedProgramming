public class Operator {

	/** The addition operator : + */
	public static final char PLUS = '+';
	/** The subtraction operator : - */
	public static final char MINUS = '-';
	/** The multiplication operator : * */
	public static final char TIMES = '*';
	/** The division operator : / */
	public static final char DIVIDE = '/';
	/** The power operator : ^ */
	public static final char POWER = '^';

	// these assume an ordering of ^(*/)(+-)
	private static int[] precValues = {4,3,2};

	/**
	 * @param op input.
	 * @return True if the input is a valid operator.
	 */
	public static boolean isOperator(char op) {
		switch(op) {
			case MINUS:
			case PLUS:
			case DIVIDE:
			case TIMES:
			case POWER:
				return true;
		}
		return false;
	}

	/**
	 * @param op input.
	 * @return True if input is a single character string that represents a valid operator.
	 */
	public static boolean isOperator(String op) {
		if (op.length() == 1) {
			return isOperator(op.charAt(0));
		} else {
			return false;
		}
	}

	/**
	 * Evaluates an arithmetic expression in the order (operand1)(operator)(operand2).
	 * @param operand1 The first operand, which must be a valid number.
	 * @param operand2 The second operand, which must be a valid number.
	 * @param operator The operator.
	 * @return The result when applying the operator to the two operands.
	 * 	Note that the operator POWER requires that operand2, the exponent, be a non-negative integer.
	 * @throws IllegalExpressionException if the exponent is negative or is non-zero beyond the decimal point,
	 *  or if operator is not a valid operator.
	 */
	public static double evaluate(double operand1, double operand2, char operator) {
		switch(operator) {
			case PLUS:
				return operand1+operand2;
			case MINUS:
				return operand1-operand2;
			case TIMES:
				return operand1*operand2;
			case DIVIDE:
				return operand1/operand2;
			case POWER:
				int exponent = (int)operand2;
				if (operand2-exponent > 0.00000001 || exponent < 0) {
					throw new IllegalExpressionException("exponent cannot be less than 0 or a non-integer");
				}
				double result = 1;
				for (int k=1; k<=exponent; k++) {
					result *= operand1;
				}
				return result;
			default:
				throw new IllegalExpressionException("Unknown operator: "+operator);
		}	
	}

	/**
	 * Evaluates an arithmetic expression in the order (operand1)(operator)(operand2).
	 * @param operand1 The first operand, which must be a valid number.
	 * @param operand2 The second operand, which must be a valid number.
	 * @param operator The operator as a single character string object.
	 * @return The result when applying the operator to the two operands.
	 * 	Note that the operator POWER requires that operand2, the exponent, be a non-negative integer.
	 * @throws IllegalExpressionException if the exponent is negative or is non-zero beyond the decimal point,
	 *  or if operator is not a valid operator.
	 */
	public static double evaluate(double operand1, double operand2, String operator) {
		if (operator.length() > 1) {
			throw new IllegalExpressionException("Unknown operator: "+operator);
		}
		return evaluate(operand1,operand2,operator.charAt(0));
	}
				
	/*
 	 * helper method.
	 * returns a number value, where operators of higher precedence 
	 * have higher numbers.
	 * throws IllegalArgumentException if not a valid operator.
	 */
	private static int getPrecedence(char op) {
		int index = -1;
		switch(op) {
			case MINUS:
			case PLUS:
				index++;
			case DIVIDE:
			case TIMES:
				index++;
			case POWER:
				index++;
				return precValues[index];
			default:
				throw new IllegalArgumentException("Not a valid arithmetic operator");
		}
	}

	/* Compares the precedence of two operators.
	 * @param op1 An operator
	 * @param op2 The operator to compare it with.
	 * @return 
	 *		<ul><li>0 if both operators have the same precedence.</li>
	 *		<li>A number less than 0 if op1 has higher precedence.</li>
	 *		<li>A number greater than 0 if op2 has higher precendence.</li>
	 *		</ul>
	 * @throws IllegalExpressionException if either operator is not valid.
	 */
	public static int comparePrecedence(char op1, char op2) {
		if (isOperator(op1) && isOperator(op2)) {
			int first = getPrecedence(op1);
			int second = getPrecedence(op2);
			return second-first;
		} else {
			throw new IllegalArgumentException("One or both operators are not valid");
		}
	}

	/* Compares the precedence of two operators.
	 * @param op1 An operator
	 * @param op2 The operator to compare it with.
	 * @return 
	 *		<ul><li>0 if both operators have the same precedence.</li>
	 *		<li>A number less than 0 if op1 has higher precedence.</li>
	 *		<li>A number greater than 0 if op2 has higher precendence.</li>
	 *		</ul>
	 * @throws IllegalExpressionException if either operator is not valid.
	 */
	public static int comparePrecedence(String op1, String op2) {
		if (op1.length() > 0 && op2.length() > 0) {
			return comparePrecedence(op1.charAt(0),op2.charAt(0));
		} else {
			throw new IllegalArgumentException("operators have only one character");
		}
	}

	/**
	 * Used for internal testing.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		if (isOperator('+') && isOperator("*") && isOperator("^")) {
			System.out.println("OKAY 1");
		} else {
			System.out.println("MISTAKE 1");
		}
		if (isOperator("h") || isOperator("+-")) {
			System.out.println("MISTAKE 2");
		} else {
			System.out.println("OKAY 2");
		}
		System.out.println("Precedence for "+POWER+" is "+getPrecedence(POWER));
		System.out.println("Precedence for "+TIMES+" is "+getPrecedence(TIMES));
		System.out.println("Precendence for "+DIVIDE+" is "+getPrecedence(DIVIDE));
		if (comparePrecedence(POWER,TIMES) < 0) {
			System.out.println(POWER+" comes before "+TIMES);
		} else {
			System.out.println(TIMES+" comes before "+POWER);
		}
		if (comparePrecedence(TIMES,DIVIDE) == 0) {
			System.out.println(TIMES+" and "+DIVIDE+" have equivalent precedence");
		} else {
			System.out.println(TIMES+" and "+DIVIDE+" have different precedence");
		}
		// some basic arithmetic:
		System.out.println("2+3="+evaluate(2.0,3.0,PLUS));
		System.out.println("12/4="+evaluate(12.0,4.0,DIVIDE));
		System.out.println("2^4="+evaluate(2.0,4.0,POWER));
		try {
			evaluate(2,-4,POWER);
		} catch (IllegalExpressionException e) {
			System.out.println("correctly catches a negative power");
		}
		try {
			evaluate(2.0,3.5,POWER);
		} catch (IllegalExpressionException e) {
			System.out.println("correctly catches a non-integer power");
		}
	}
}
