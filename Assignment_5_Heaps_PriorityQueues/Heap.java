/**
 * Heap.java
 * Provide the necessary header information here, 
 * making sure to delete these lines.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

// This is the beginning of the source code to help you get started.
// Do not change the following:

public class Heap<E extends Comparable<E>> {

  private ArrayList<E> heap;
  private int size;
  private static final int CAPACITY = 100;

  /**
  * Creates an empty heap.
  */
  public Heap() {
	heap = new ArrayList<E>(CAPACITY);
	for (int i=0; i<CAPACITY; i++) {
	    heap.add(null);
	}
  }  

	
	// Complete the rest below:
	
	// CLASS METHODS: 
	

	
	
	
	// public boolean isEmpty(): 
	// Returns: true if the heap is empty.
	public boolean isEmpty() {
		
		if ( size == 0 ) {
			return true;
		}
		return false;
			
	}



	// public int size():
	// Returns: The number of elements in the heap.
	public int size() {
		return size;
	}



	// public void insert():
	// Adds an element to the heap, placing it into the only correct position.
	// Parameters: element - The element to insert.
	public void insert(E element) {
		
		if ( size > CAPACITY ) {
			heap.ensureCapacity(size + 1);
		}
		heap.set(++size, element);
		bubbleUp();
		
	}
	
	
	// bubbleUp()
	private void bubbleUp() {
		
		int index = size;
		while ( hasParent(index) && 
				isLessPriority( index, getParentIndex(index) ) ) {
					
			swap( index, getParentIndex(index) );
			index /= 2;
			
		}
		
	}
	
	


	// PRIVATE HELPER METHODS: for navigating indexes up/down the tree
	
	// int getParentIndex(): returns the parent index position of a child index argument.
	private int getParentIndex(int childIndex) { 
		return childIndex / 2; 
	}
	
	// int getLeftChildIndex(): returns the left child index position of a parent index argument.
	private int getLeftChildIndex(int parentIndex) { 
		return parentIndex * 2; 
	}
	
	// int getRightChildIndex(): returns the right child index position of a parent index argument.
	private int getRightChildIndex(int parentIndex) { 
		return parentIndex*2 + 1; 
	}
	
	
	
	// boolean hasParent():
	private boolean hasParent(int childIndex) { 
		return childIndex > 1; 
	}
	
	// boolean hasLeft():
	private boolean hasLeftChild(int parentIndex) { 
		return getLeftChildIndex(parentIndex) <= size;  
	}
	
	// boolean hasRight():
	private boolean hasRightChild(int parentIndex) {
		return getRightChildIndex(parentIndex) <= size;
	}
	
	
	// boolean isLessPriority():
	private boolean isLessPriority(int childIndex, int parentIndex) {
		return heap.get(childIndex).compareTo( heap.get(parentIndex) ) < 0;		
	}
	
	
	//swap():
	private void swap(int a, int b) {
		E temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, temp);
	}
	
	

	// public E getRootItem():
	// Removes the element that is currently at the root (or top) of the heap.
	// Returns: The element.
	// Throws: NoSuchElementException - if the heap is empty.
	public E getRootItem() throws NoSuchElementException {
		
		if ( size == 0 ) throw new NoSuchElementException();
		
		E item = heap.get(1);
		heap.set( 1, heap.get(size--) );
		bubbleDown();
		
		return item;
	
	}
	
	private void bubbleDown() {
		
		int index = 1;
		// keep bubbling down from root to sort heap nodes,
		// while left children exist:
		while ( hasLeftChild(index) ) {
			
			// establish which sub tree heap node has the smaller child
			// and bubble down the path of the smaller child:
			int minChildIndex = getLeftChildIndex(index);
			if ( hasRightChild(index) && !isLessPriority( minChildIndex, getRightChildIndex(index)) ) {
				minChildIndex = getRightChildIndex(index);
			}
			// if smaller child is greater priority than parent,
			// then ordering is fine, and end bubble down.
			// else, swap the heap nodes:
			if ( !isLessPriority( minChildIndex, index) ) {
				return;
			} else {
				swap(minChildIndex, index);
			}
			
			index = minChildIndex;
			
			
		} //end while bubble down loop
		
	} //end bubbleDown()
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder(); 
		for (int i=1; i<=size; i++) {
			sb.append(heap.get(i));
			if ( i != size ) {
				sb.append(" ");
			}
		}
		
		return sb.toString();
		
	}
	
	
	
	
	// Used for internal testing only.
	public static void main(String[] args) {
		
		Heap<Integer> test = new Heap<Integer>();
		
		//Test NoSuchElementException handling in getRootItem():
		try {
			System.out.println(test.getRootItem());
		}catch (NoSuchElementException nse) {
			System.out.println(nse.getMessage());
		}
		
		
		
		test.insert(5);
		test.insert(67);
		test.insert(13);
		System.out.println("Heap: " + test.toString());
		test.insert(22);
		System.out.println("Insert '22': " + test.toString());
		test.insert(28);
		System.out.println("Insert '28': " + test.toString());
		test.insert(3);
		System.out.println("Insert  '3': " + test.toString());
		test.insert(54);
		System.out.println("Insert '54': " + test.toString());

		System.out.println("Heap Size: " + test.size());
		
		
		// Test remove root and rearrange heap via bubbleDown():
		System.out.println();
		System.out.println("Remove root '" + test.getRootItem() +
							"': " + test.toString());

		System.out.println("Heap Size: " + test.size());
		
	}
	
	
	
} //end class Heap<E extends Comparable<E>>


