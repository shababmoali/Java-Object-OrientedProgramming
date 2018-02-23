/*
* Name: <Shabab Ali>
* Date: <Feb 08 2018>
* Filename: <StringStack.java>
* Details: <CSC115\Assn2\StringStack.java>: A Java program (verified compiler - JDK8u131) 
    that meets the criteria for developing a custom reference-based Stack class using a custom Node class.
	Learning outcomes: • Create a simple reference-based Stack.
					   • Both throw and catch exceptions in Java.
					   • Gain some experience with the Object-Oriented design concepts: data
						 abstraction, information hiding, and encapsulation.
*/



public class StringStack {
	
  
  private Node top;


	// constructor 
	// Initializes a stack that has no elements.
	public StringStack() {}
	
	
	
	// boolean isEmpty() Returns true if the stack is empty, false if not.
	public boolean isEmpty() {
		return (top == null);
	} //end isEmpty()

	
	
	// push(String s) Inserts an element onto the top of the stack.
	// Parameters: s - The element.
	public void push(String s) {
		top = new Node(s,top);
	} //end push(String s)

	

	// String pop() Removes the top element from the stack, and
	// Returns: The top element.
	// Throws: StackException - if the stack is already empty.
	public String pop() throws StackException {
	
		if (!isEmpty()) {
			
			Node result = top;
			top = top.next;
			return result.item;
		
		} else {
		
			throw new StackException("StackException on pop: empty stack");
			// return null
		}		
		
	} //end pop()


	
	// String peek() Accesses the top element of the stack, without removing it, and
	// Returns: The top element.
	// Throws: StackException - if the stack is empty.
	public String peek() throws StackException {
		
		if (!isEmpty()) {
			
			return top.item;
			
		} else {
			
			throw new StackException("StackException on peek: empty stack");
			//return null;			
		}

	} //end peek() 


	
	// popAll() Empties all the elements from the stack.
	public void popAll() {
		top = null;
	} //end popAll()

	
	
	// TESTER method: main(String[] args) Used specifically for internal testing
	// during development of the StringStack class. 
	// UNDO BLOCK comments to implement ...
	public static void main(String[] args) {
/*

		StringStack stack = new StringStack();
	
		// push() and pop() elements
		stack.push("foo");
		System.out.println("push()");
		System.out.println(stack.peek());
		stack.push("bar");
		System.out.println("push()");
		System.out.println(stack.peek());
		stack.push("baz");
		System.out.println("push()");
		System.out.println(stack.peek());
		stack.push("boo");
		System.out.println("push()");
		System.out.println(stack.peek());
		stack.pop();
		System.out.println("pop()");
		System.out.println(stack.peek());
	
		// Check popall() on stack:
		System.out.println("Empty? " + stack.isEmpty() + " execute popall()...");
		stack.popAll();
		System.out.println("Empty? " + stack.isEmpty());
		
		// Check StackException pop() on empty stack
		//stack.pop();
		
		// Comment out previous step to check StackException peek()
		stack.push("foo");
		System.out.println("Pushed \'foo\': " + stack.peek());
		
		// Check StackException peek() on empty stack:
		System.out.println("Pop \'foo\': ");
		stack.pop();
		stack.peek();

*/	
	} //end main(String[] args)
	
	
} //end class StringStack