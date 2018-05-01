
/*
* Name: <Shabab Ali>
* Date: <Apr 8 2018>
* Filename: <Heap.java>
* Details: <CSC115\Assn5\Heaps.java>: A Java program (verified compiler - JDK8u131) 
			that meets the criteria for implementing for a standard heap data structure that
			contains generic objects which implement the Comparable interface. Using
			generics allows us to re-use this program for a variety of systems and
			elements, while ensuring that elements implement Comparable allows the
			heap to use the method compareTo to determine the ordering property of the
			elements.
			NOTE: The heap implementation slightly deviates from a convential heap,
				  as there was mistake in the assignment specifications 
				  (getRootItem() and removeItem() were mixed).
				  In this version, the getRootItem() removes the root element in the heap,
				  and a custom method peekAtRootItem() returns the root element in the heap,
				  without modifying the heap. 
*/



import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

// This is the beginning of the source code to help you get started.
// DO NOT CHANGE the following:

public class Heap<E extends Comparable<E>> {

  private ArrayList<E> heap;
  private int size;
  private static final int CAPACITY = 100;

  /**
  * Constructor - Creates an empty heap.
  */
  public Heap() {
	heap = new ArrayList<E>(CAPACITY);
	for (int i=0; i<CAPACITY; i++) {
	    heap.add(null);
	}
  }

// END DO NOT CHANGE

	// Complete the rest below:
	
	// NOTE: The heap class utilizes an array data structure and avoids using 
	//		 array index 0. Therefore, the root heapNode starts at index 1, and left and right
	//		 child heapNodes follow the formula: parent*2 and parent*2+1, respectively. 
	//		 The parent heapNode for both children is at child/2.
	
	// NOTE: Furthermore, this heap class implements a MIN-HEAP.
	
	
	// PRIVATE HELPER METHODS: 
	
	
	  // INDEX ACCESSOR INT METHODS: for navigating indexes up/down the tree
	  
	  //int getParentIndex(): 
	  // Returns: the parent index position of a child index argument.
	  private int getParentIndex(int childIndex) { 
		  return childIndex / 2; 
	  }
	
	  //int getLeftChildIndex(): 
	  // Returns: the left child index position of a parent index argument.
	  private int getLeftChildIndex(int parentIndex) { 
		  return parentIndex * 2; 
	  }
	
	  //int getRightChildIndex(): 
	  // Returns: the right child index position of a parent index argument.
	  private int getRightChildIndex(int parentIndex) { 
		  return (parentIndex * 2) + 1; 
	  }
	
	  // INDEX EXISTS BOOLEAN METHODS: for navigating indexes up/down the tree
	  
	  //boolean hasParent():
	  // Returns: true if a parent heap Node exists, given a child argument. 
	  private boolean hasParent(int childIndex) { 
		  return childIndex > 1; 
	  }
	
	  //boolean hasLeft():
	  // Returns: true if a left child heap Node exists, given a parent argument. 
	  private boolean hasLeftChild(int parentIndex) { 
		  return getLeftChildIndex(parentIndex) <= size;  
	  }
	
	  //boolean hasRight():
	  // Returns: true if a right child heap Node exists, given a parent argument. 
	  private boolean hasRightChild(int parentIndex) {
		  return getRightChildIndex(parentIndex) <= size;
	  }
	
	  // END ACCESSOR AND EXISTS METHODS: for navigating indexes up/down the tree // 
	
	
	  // HEAP NODE EVALUATOR ( childIsHigherPriority() ) AND MODIFIER ( swap ):

	  //swap():
	  // Swaps the heapNodes in the array at given index positions.
	  // Parameters: first - int Index a, second - int Index b.
	  private void swap(int a, int b) {
		  
		  E temp = heap.get(a);
		  heap.set(a, heap.get(b));
		  heap.set(b, temp);
	  
	  } //end swap()


	  //boolean childIsHigherPriority():
	  // compares a child item to parent item. 
	  // Parameters: first - int childIndex, second - int parentIndex.
	  // Returns: true, if child heapNode is min (higher priority) than the cognate parent heapNode. 
	  private boolean childIsHigherPriority(int childIndex, int parentIndex) {
		  return heap.get(childIndex).compareTo( heap.get(parentIndex) ) < 0;		
	  }

	// END HEAP NODE EVALUATOR ( childIsHigherPriority() ) AND MODIFIER ( swap ) //


	// END PRIVATE HELPER METHODS //



	// CLASS METHODS: 


	//public boolean isEmpty(): 
	// Returns: true if the heap is empty.
	public boolean isEmpty() {
		
		if ( size == 0 ) {
			return true;
		}
		return false;
			
	} //end boolean isEmpty()



	//public int size():
	// Returns: The number of elements in the heap.
	public int size() {
		
		return size;
	
	} //end int size()



	//public void insert():
	// Adds an element to the heap, placing it into the only correct position.
	// Parameters: element - The element to insert.
	public void insert(E element) {
		
		//if ( size == CAPACITY - 1) {
		//	heap.ensureCapacity(size + 1);
		//}
		heap.add(++size, element);
		bubbleUp();
		
	} //end insert()
	
	
	  //private void bubbleUp():
	  // Private heapify method called in insert().
	  // bubbleUp() heapify method rearranges the heap upon insertion of a new leaf node.
	  // A higher priority (min) heapNode will bubble up and percolate towards the root,
	  // if its parent heapNode is lesser priority (less min).
	  private void bubbleUp() {
		
		  int index = size; //initial child heapNode position
		  while ( hasParent(index) && 
				  childIsHigherPriority( index, getParentIndex(index) ) ) {
					
			  swap( index, getParentIndex(index) );
			  index /= 2; //new child position
			
		  } //end while iteration child heap Node percolate up
		
	  } //end bubbleUp()



	//public E peekAtRootItem():
	// DOES NOT REMOVE!!! the element that is currently at the root (or top) of the heap.
	// Returns: The element at the root (or top) of the heap.
	// Throws: NoSuchElementException - if the heap is empty.
	public E peekAtRootItem() throws NoSuchElementException {
		
		if ( size == 0 ) throw new NoSuchElementException();
		
		return heap.get(1);
	
	} //end E peekAtRootItem()
	
	
	
	//public E getRootItem():
	// Removes the element that is currently at the root (or top) of the heap.
	// Returns: The element.
	// Throws: NoSuchElementException - if the heap is empty.
	public E getRootItem() throws NoSuchElementException {
		
		if ( size == 0 ) throw new NoSuchElementException();
		
		E item = heap.get(1);
		heap.set( 1, heap.get(size--) );
		bubbleDown();
		
		return item;
	
	} //end E getRootItem()
	
	
	  //private void bubbleDown():
	  // bubbleDown() heapify method rearranges the heap upon removal of a root node.
	  // Subsequent to the root heapNode being replaced by the furthest most child leaf.
	  // The new root heapNode will bubble down the order of priority,
	  // while it encounters higher priority children along the minimum/ higher priority path.
	  private void bubbleDown() {
		
		  int index = 1;
		  // keep bubbling down from root to sort heap nodes,
		  // while left children exist:
		  while ( hasLeftChild(index) ) {
			
			  // establish which sub tree heap node has the min (more higher priority) child
			  // and bubble down the path of the smaller child:
			  int minChildIndex = getLeftChildIndex(index);
			  if ( hasRightChild(index) && childIsHigherPriority( getRightChildIndex(index), minChildIndex ) ) {
				  minChildIndex = getRightChildIndex(index);
			  }
			  // if min child has minimum higher priority over the parent,
			  // then swap the heap nodes,
			  // else, ordering is fine, end bubble down (return from function).
			  if ( childIsHigherPriority( minChildIndex, index) ) {
				  swap(minChildIndex, index);
			  } else {
				  return;
			  }
			  // evaluate the heap Node with respect to the new index position:
			  index = minChildIndex;
			
			
		  } //end bubble down while loop
		
	  } //end bubbleDown()
	
	
	
	//public String toString():
	// Returns: String Printout of the heap array data structure contents.
	// tester method:
	public String toString() {
		
		StringBuilder sb = new StringBuilder(); 
		for (int i=1; i<=size; i++) {
			sb.append("\n" + heap.get(i));
			//if ( i != size ) {
			//	sb.append(" ");
			//}
		}
		
		return sb.toString();
		
	} //end String toString()



	// public main(String[] args): 
	// Used for internal testing only.
	// Parameter: String[] args is not used.
	public static void main(String[] args) {
		
		Heap<Integer> test = new Heap<Integer>();
		
		//Test NoSuchElementException handling in getRootItem():
		System.out.println("\nRemove on Empty heap: ");
		try {
			System.out.println(test.getRootItem());
		}catch (NoSuchElementException nse) {
			System.out.println(nse.getMessage());
		}
		
		// Test isEmpty():
		System.out.println("\nHeap Status Empty: " + test.isEmpty());
		
		// Test insert and rearrange heap via bubbleUp():
		test.insert(5);
		test.insert(67);
		test.insert(13);
		System.out.println("\nHeap: " + test.toString());
		System.out.println("\nHeap Status Empty: " + test.isEmpty());
		test.insert(22);
		System.out.println("\nInsert '22': " + test.toString());
		test.insert(28);
		System.out.println("\nInsert '28': " + test.toString());
		test.insert(3);
		System.out.println("\nInsert  '3': " + test.toString());
		test.insert(54);
		System.out.println("\nInsert '54': " + test.toString());
		test.insert(3);
		System.out.println("\nInsert '54': " + test.toString());
		// Test size():
		System.out.println("Heap Size: " + test.size());


		// Test peek at root - NO HEAP REARRANGEMENT AND NO ROOT REMOVAL:
		System.out.println();
		System.out.println("Peek root: " + test.peekAtRootItem() +
							": " + test.toString());
		System.out.println("Heap Size: " + test.size());


		// Test remove root and rearrange heap via bubbleDown():
		System.out.println();
		System.out.println("Remove root '" + test.getRootItem() +
							"': " + test.toString());
		System.out.println("Heap Size: " + test.size());


		// Test isEmpty() and remove root and rearrange heap via bubbleDown():
		while( !test.isEmpty() ) {
			
			System.out.println();
			System.out.println("Remove root '" + test.getRootItem() +
							"': " + test.toString());
			System.out.println("Heap Size: " + test.size());
		
		}


		// Test NoSuchElementException handling in peekAtRootItem():
		System.out.println("\nPeek at Empty Heap:");
		try {
			System.out.println(test.peekAtRootItem());
		}catch (NoSuchElementException nse) {
			System.out.println(nse.getMessage());
		}


		// Test NoSuchElementException handling in getRootItem():
		System.out.println("\nRemove on Empty Heap:");
		try {
			System.out.println(test.getRootItem());
		}catch (NoSuchElementException nse) {
			System.out.println(nse.getMessage());
		}


		// Test capacity handling:
		System.out.println();
		Integer count = 1;
		for (int i=0; i<110; i++) {
			test.insert(count);
			count++;
		}
		System.out.println("Insert '110 sequential elements': " + test.toString());
		System.out.println("Heap Size: " + test.size());
		
	} //end main()



} //end class Heap<E extends Comparable<E>>