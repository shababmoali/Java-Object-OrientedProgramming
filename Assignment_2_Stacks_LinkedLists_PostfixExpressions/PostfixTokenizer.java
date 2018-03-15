/*
* Name: <Shabab Ali>
* Date: <Feb 08 2018>
* Filename: <PostfixTokenizer.java>
* Details: <CSC115\Assn2\PostfixTokenizer.java>: A Java program (verified compiler - JDK8u131) 
    that meets the criteria for developing a custom postfix expression tokenizer using
	a reference-based Stack class to process operators and parentheses and a custom singly linked-list
	to store the postfix expression.
	Learning outcomes: • Create a simple reference-based Stack.
					   • create a postfix expression from an infix expression and
					   • Both throw and catch exceptions in Java.
					   • Gain some experience with the Object-Oriented design concepts: data
						 abstraction, information hiding, and encapsulation.
*/



public class PostfixTokenizer implements Tokenizer {


  // Operator object op helps identify and compare operators.
  // For details on the Operator objects, refer to the Operator.java class file.
  private Operator op = new Operator();
  
  // StringStack object opStack helps parse operators and parentheses from operands.
  // For details on the StringStack objects, refer to the StringStack.java class file (a custom stack based on a linked-list).
  private StringStack opStack = new StringStack();
  
  
  /********  START PRIVATE DATA FIELDS AND HELPER METHODS FOR SINGLY LINKED_LIST DATA STRUCTURE TO STORE POSTFIX EXPRESSION   ********/ 
 
  // Linked-list data structure stores the postfix String tokens,
  // each node.item contains a single token for a postfix expression.
  // For details on the Node objects, refer to the Node.java class file.
  Node postfixExphead;
  Node postfixExptail;
    
  // Tokenizer field that can keep track of the postfix expression token index
  Node currTokenIndex;
  
  
  // postfixExpAppend(String s) Appends a String token to the tail  
  // of a refference based singly linked-list postfix expression
  private void postfixExpAppend(String s) {
	
	if (postfixExphead == null && postfixExptail == null) {
		Node n = new Node(s);
		postfixExphead = n;
		postfixExptail = n;
		currTokenIndex = postfixExphead;
	} else {
		Node n = new Node(s);
		postfixExptail.next = n;
		postfixExptail = n;
	}
	
  } //end postfixExpAppend(String s)


  // postfixExpLength() determines the length (# of tokens) in the postfix expression 
  // iterates through the reference based linked list
  private int postfixExpLength() {
	
	int count = 0;
	for (Node curr=postfixExphead; curr!=null; curr=curr.next) {
		count++;
	}
	return count;
	
  } //end postfixExpLength()


  // maxOperand() iterates through the reference based linked list
  // and determines the largest token (# of chars) in the postfix expression
  private int maxOperand() {
	
	int max = 0;
	for (Node curr=postfixExphead; curr!=null; curr=curr.next) {
		if (curr.item.length() > max) {
			max = curr.item.length();
		}
	}
	return max;
	
  } //end maxOperand()

  /********  END PRIVATE DATA FIELDS AND HELPER METHODS FOR SINGLY LINKED_LIST DATA STRUCTURE TO STORE POSTFIX EXPRESSION   ********/ 

  

	// constructor public PostfixTokenizer(OperatorTokenizer infixTokens) Creates a new postfix order Tokenizer object
	// from an infix Tokenizer object parameter. The postfix expression is stored in a singly linked-list data structure.
	// If all the non-operators and non-parenthesis are valid operands, 
	// the result will be a valid postfix arithmetic expression, 
	// with only operands and operators -- i.e. no parenthesis.
	// For details on the infix tokenizer parameter, refer to the OperatorTokenizer file.
	public PostfixTokenizer(OperatorTokenizer infixTokens) throws IllegalExpressionException {

	
		// Generate postfix expression by reading infix tokens and placing them
		// in proper order by utilizing an algorithm that sorts operators and parentheses
		// through an operator stack 
		while (infixTokens.hasNext()) {
	
			String inToken = infixTokens.next();
	
			//CASE 1: Token is an open parenthesis ("("):
			if ( inToken.length() == 1 && inToken.equals("(") ) {  
		
				opStack.push(inToken);
	
			//CASE 2: Token is a close parenthesis (")"):
			} else if ( inToken.length() == 1 && inToken.equals(")") ) {
		
				// If operator stack is not empty,
				// remove operators in the operator stack and append to the postfix expression 
				// until an open parenthesis ("(") is encountered at the top of the stack
				while ( !opStack.isEmpty() && !opStack.peek().equals("(") ) {
					postfixExpAppend(opStack.pop());
				} // end while
		
				// remove the open parenthesis at the top of the operator stack
				// Note: if there is no open parenthesis in the empty operator stack, 
				//       the infix input expression must be invalid
				if ( !opStack.isEmpty() && opStack.peek().equals("(") ) {
					opStack.pop();
				} else { //opStack.isEmpty is true;
					// throw an IllegalExpressionException for mismatched parentheses
					throw new IllegalExpressionException("Mismatched parentheses: No matching open \"(\" parenthesis");
				}
	
			//CASE 3: Token is an operator: process the operator stack elements/operators 
			//        in order of greater precedence 
			} else if ( inToken.length() == 1 && op.isOperator(inToken) ) {
		
				// ie if the operator stack has other elements/operators which are higher or equal precedence
				// than the infix token, pop higher and equal operators from operator stack (upto an open parenthesis)
				// and append to the postfix expression
				while ( !opStack.isEmpty() && 
						!opStack.peek().equals("(") && 
						op.comparePrecedence(inToken, opStack.peek()) >= 0 ) {

							postfixExpAppend(opStack.pop());

				}
				// push the current lower precedence infix operator token onto the operator stack
				opStack.push(inToken);

			// CASE 4: Token is an operand: directly append the operand to the postfix expression
			} else { 
			
				postfixExpAppend(inToken);
		
			}	
		
		} //end infixTokens reading


		// Pop off the remaining operators in the operator stack and append them
		// to the postfix expression
		while ( !opStack.isEmpty() ) {
			
			// if any open parenthesis are encountered - the infix expression input must be invalid
			if ( opStack.peek().equals("(") ) {
				//thrown an IllegalExpressionException for mismatched parentheses
				throw new IllegalExpressionException("Mismatched parentheses: Too many open \"(\" parenthesis");
			} 
			postfixExpAppend(opStack.pop());
			
		
		} //end while - empty operator stack


	} //end PostfixTokenizer object constructor
	
	
	
	/*********  START TOKENIZER REQUIRED METHODS  *********/ 
 
 
	// reset() Sets the iterator start position for the first item in the list.
	public void reset() {
		currTokenIndex = postfixExphead;
	} //end reset()

	
	// numTokens() Returns the number of tokens in the list.
	public int numTokens() {
		return  postfixExpLength();
	} //end numTokens()
	
	
	// toString()Returns the postfix expresssion - 
	// The format is a list of tokens on a single line, delimited by a single space.
	public String toString() {

		StringBuilder sb = new StringBuilder(postfixExpLength()*maxOperand());
		for (Node curr=postfixExphead; curr!=null; curr=curr.next) {
			sb.append(curr.item);
			if (curr.next != null) {
				sb.append(" ");
			}
		}
		return sb.toString();
		
	} //end toString()

	
	/********  END TOKENIZER REQUIRED METHODS  **********/



	/************  START ITERATOR REQUIRED METHODS  ************/

	
	// hasNext() Returns false when currTokenIndex has iterated through the entire
	// linked-list.
	public boolean hasNext() {
		return currTokenIndex != null;
	} //end hasNext()

	
	// next() Returns the node.item at currTokenIndex. 
	public String next() {
		
		if (!hasNext()) {
			throw new StackException("No more tokens");
		}
		Node result = currTokenIndex;
		currTokenIndex = currTokenIndex.next;
		
		return result.item; 
	
	} //end next()

	
 	// This method is not supported on an immutable list.
	public void remove() {
		throw new UnsupportedOperationException("Tokens may not be removed");
	}

	
	/************  END ITERATOR REQUIRED METHODS  ************/



	// TESTER method: main(String[] args) Used specifically for internal testing
	// during development of the StringStack class. 
	// UNDO BLOCK comments to implement ...
	public static void main(String[] args) {


		String test1 = "3*(4+2)-4*(-6--3)";
		String test2 = "x^y/(5*z)+10";

		// a bad expression, too many open parenthesis...
		String test3 = "(3)+2*(6-10^3";
		
		// a bad expression, too many closed parenthesis...
		String test4 = "(4))-5+6";
		
		// even worse expression:
		String test5 = "3-hello?(bbb/*=\")";
		
		// Debug expressions:
		String test6 = "3+1-6";
		String test7 = "3*(4+3)/3";

		// Tokenize infix expressions:
		OperatorTokenizer infix1 = new OperatorTokenizer(test1);
		OperatorTokenizer infix2 = new OperatorTokenizer(test2);
		OperatorTokenizer infix3 = new OperatorTokenizer(test3);
		OperatorTokenizer infix4 = new OperatorTokenizer(test4);
		OperatorTokenizer infix5 = new OperatorTokenizer(test5);
		OperatorTokenizer infix6 = new OperatorTokenizer(test6);
		OperatorTokenizer infix7 = new OperatorTokenizer(test7);
		
		
		// Check infix tokens:
		System.out.println("The print outs:");
		System.out.println(infix1);
		System.out.println(infix2);
		System.out.println(infix3);
		System.out.println(infix4);
		System.out.println(infix5);
		System.out.println(infix6);
		System.out.println(infix7);
		
		
		// Create Postfix token objects, using infix tokens as parameters
		
		System.out.println("\n Postfix Tokens:");
		PostfixTokenizer p1 = new PostfixTokenizer(infix1);
		System.out.println(p1);
		
		
		PostfixTokenizer p2 = new PostfixTokenizer(infix2);
		System.out.println(p2);
		
		
		// Debug expressions:
		PostfixTokenizer p6 = new PostfixTokenizer(infix6);
		System.out.println(p6);
		
		PostfixTokenizer p7 = new PostfixTokenizer(infix7);
		System.out.println(p7);

		
		System.out.println("\ntoo many open parentheses:");
		try {
		PostfixTokenizer p3 = new PostfixTokenizer(infix3);
		System.out.println(p3);
		} catch (IllegalExpressionException iee) {
		System.out.println(iee.getMessage());
		}
		
		
		System.out.println("\ntoo many close parentheses:");
		try {
		PostfixTokenizer p4 = new PostfixTokenizer(infix4);
		System.out.println(p4);
		} catch (IllegalExpressionException iee) {
		System.out.println(iee.getMessage());
		}
		
		
		System.out.println("\nBad Expression:");
		try {
		PostfixTokenizer p5 = new PostfixTokenizer(infix5);
		System.out.println(p5);
		} catch (IllegalExpressionException iee) {
		System.out.println(iee.getMessage());
		}
		
		
		// Assignment Example:
		System.out.println("\nAssignment Example:");
		String asString = "3*(4+-2)";
		OperatorTokenizer asInfix = new OperatorTokenizer(asString);
		PostfixTokenizer postfix = new PostfixTokenizer(asInfix);
		System.out.print("as infix tokens: ");
		System.out.println(asInfix);
		System.out.println("By individual postfix tokens:");
		
		while(postfix.hasNext()) {
			System.out.println("next token: " + postfix.next());
		}


	} //end main(String[] args)


} //end class PostfixTokenizer
