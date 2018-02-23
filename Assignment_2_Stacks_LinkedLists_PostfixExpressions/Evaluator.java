/*
* Name: <Shabab Ali>
* Date: <Feb 08 2018>
* Filename: <Evaluator.java>
* Details: <CSC115\Assn2\Evaluator.java>: A Java program (verified compiler - JDK8u131) 
    that meets the criteria for developing a custom Evaluator class that uses 
	a reference-based Stack to evaluate postfix expressions.
	Learning outcomes: • Create a simple reference-based Stack.
					   • Evaluate postfix expressions.
					   • Both throw and catch exceptions in Java.
					   • Gain some experience with the Object-Oriented design concepts: data
						 abstraction, information hiding, and encapsulation.
*/



public class Evaluator {


	// public static double evaluate(String expression) Solves an arithmetic expression.
	// Parameters: String expression - An arithmetic expression with numbers and the operators defined in the Operator class.
	// Returns: The numeric value of the expression.
	// Throws: IllegalExpressionException - if the expression cannot be solved.
	public static double evaluate(String expression) throws IllegalExpressionException {


		// Operator object op helps identify and compare operators.
		// For details on the Operator objects, refer to the Operator.java class file.
		Operator op = new Operator();


		// StringStack object opStack helps parse operators and parentheses from operands.
		// For details on the StringStack objects, refer to the StringStack.java class file (a custom stack based on a linked-list).
		StringStack evStack = new StringStack();


		// OperatorTokenizer object - Separates the operators and parens from the rest of the infix expression
		// to create a set of String tokens. 
		// For details on the OperatorTokenizer objects, refer to the OperatorTokenizer.java class file.
		OperatorTokenizer infix = new OperatorTokenizer(expression);


		// Postfix Tokenizer object - Accepts an operator tokenizer parameter and generates
		// a cognate postfix Tokenizer object
		// For details on the Tokenizer objects, refer to the PostfixTokenizer.java class file.
		PostfixTokenizer pfix = new PostfixTokenizer(infix);


		while (pfix.hasNext()) {

			String postfixToken = pfix.next();

			// CASE 1: postfix Token is an operand -
			// Determine whether the String token is numeric and push to the evaluator stack 
			if (!op.isOperator(postfixToken)) {

				// evaluate numeric type 
				try {  
					Double.parseDouble(postfixToken);
				// if the String token is not numeric, then catch IllegalExpressionException
				}  catch(NumberFormatException nfe) {  
					throw new IllegalExpressionException("Operands must be integers");  
				} 
				evStack.push(postfixToken);
				
			// CASE 2: postfix Token must be an operator - 
			// evaluate two operands on the evaluator stack
			// and push the result back onto the evaluator stack
			} else {
				
				try {
					// there has to be two operators in the evaluator stack when 
					// an operator is encountered in the postfix expression,
					// otherwise, the postfix expression is illegal  
					if (evStack.isEmpty()) {
						throw new IllegalExpressionException("Too few Operands"); 
					}
					double operand2 = Double.parseDouble(evStack.pop());
					
					if (evStack.isEmpty()) {
						throw new IllegalExpressionException("Too few Operands"); 
					} 
					double operand1 = Double.parseDouble(evStack.pop());
					
					// evaluate and store the result at the top of the evaluator stack
					double stackEvaluation = op.evaluate( operand1, operand2, postfixToken.charAt(0) );
					String resultString = Double.toString(stackEvaluation);
					evStack.push(resultString);	
				// if the postfix expression was illegal by having too few operands, 
				// then catch IllegalExpressionException
				} catch(IllegalExpressionException iee) {
					throw new IllegalExpressionException("Too few operands");
				}
			
			}
		
		} //end while - read postfix tokens
		
		// get final evaluation of the postfix expression from top of stack, 
		// after all tokens have been read.
		double result = Double.parseDouble(evStack.pop()); 
		
		// If there are still values on the stack after evaluating a postfix expression, 
		// then there are too many operands.
		if (!evStack.isEmpty()) {
			throw new IllegalExpressionException("Too many operands");
		}
		
		
		// return the evaluation of the postfix expression 
		return result;
		
	} //end evaluate(String expression)



	// TESTER method: main(String[] args) Used specifically for internal testing
	// during development of the StringStack class. 
	// UNDO BLOCK comments to implement ...
	public static void main(String[] args) {
/*	

		String good = "3*(4+2)-4*(-6--3)";
		String badParens = "((4)";
		String badParens2 = "((4)))";
		String toomanyOperands = "(4+6)12";
		String notEnough = "3--6+2*";
		String poorForm = "3-hello?(bbb/=\")";
		
		
		System.out.println(good);
		System.out.println(evaluate(good));
		
		System.out.println(badParens);
		try {
		evaluate(badParens);
		} catch (IllegalExpressionException iee) {
		System.out.println(iee.getMessage());
		}
		
		System.out.println(badParens2);
		try {
		evaluate(badParens2);
		} catch (IllegalExpressionException iee) {
		System.out.println(iee.getMessage());
		}
		
		System.out.println(toomanyOperands);
		try {
		evaluate(toomanyOperands);
		} catch (IllegalExpressionException iee) {
		System.out.println(iee.getMessage());
		}
		
		System.out.println(notEnough);
		try {
		evaluate(notEnough);
		} catch (IllegalExpressionException iee) {
		System.out.println(iee.getMessage());
		}
		
		System.out.println(poorForm);
		try {
		evaluate(poorForm);
		} catch (IllegalExpressionException iee) {
		System.out.println(iee.getMessage());
		}

*/	
	} //end main(String[] args)


} //end class Evaluator