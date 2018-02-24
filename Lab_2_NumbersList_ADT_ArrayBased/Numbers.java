/*
* Name: <Shabab Ali>
* Date: <Jan 15 2018>
* Filename: <Numbers.java>
* Details: <CSC115\Lab2\Numbers.java>: A Java program (verified compiler - JDK8u131) 
    that meets the criteria for developing a custom Java Numbers List ADT implementation
	using an int[] array data structure:
*/

import java.util.*;


public class Numbers {


  private static final int INIT_COLLECTION_SIZE = 10; //initial collection size

  private int[] collectionArr; // collection array of list items 
  private int capacity; // collection array length 
  private int numItems; // index marker for filled spots (number of Items) in the collection array


	// default Numbers() constructor
	// intializes an array of list items with default size INIT_COLLECTION_SIZE.
	public Numbers() {
	
	    this.collectionArr = new int[INIT_COLLECTION_SIZE]; 
	    this.capacity = collectionArr.length;
	    this.numItems = 0;	
    
	} //end constructor



	// add(int num) adds a new number to the collection array attribute
	// in a Numbers object.
    public void add(int num) {
		// case: collection array is not filled to capacity 
		if (numItems < capacity) {
			collectionArr[numItems] = num;
			numItems++;	 
		// case: collection array is filled to capacity -
		//       double collection array length and add new integer
		} else {
			collectarrayDoubleCapacity();
			collectionArr[numItems] = num;
			numItems++;	  
	    }

	} //end add(int num) method



	// collectarrayDoubleCapacity() doubles the collection array length
	// ie double the capacity attribute in a Numbers object
	private void collectarrayDoubleCapacity() {
	
		int[] temp = new int[capacity*2];
			for (int i=0; i<capacity; i++) {
				temp[i] = collectionArr[i];
			}
		
		collectionArr = temp;
		capacity = collectionArr.length; 
	
	/*	
	Alternative Implementation using Java helper methods:
		int[] temp = this.collectionArr.clone();
		this.capacity *= 2;
		this.collectionArr = new int[this.capacity];
		this.collectionArr = Arrays.copyOf(temp, this.capacity);	
	*/	
	
		
	} //end collectarrayDoubleCapacity() method 
	
	
	
	// remove(int num) removes the first instance of the number found 
	// in the collection array attribute of a Numbers object.
    public void remove(int num) {
		
		int removeMarker = 0;
		boolean toRemove = false;
		
		for (int i=0; i<numItems && toRemove == false; i++) {
			removeMarker++;
			if (num == collectionArr[i]) {
				removeMarker = i;
				toRemove = true;
			}
		}
		// remove number from the collection array and shift remaining elements left to fill gap
		replaceShiftLeft(removeMarker);
		numItems--;
    
	} //end remove(int num) method
  
  
	// private method replaceShiftLeft(int start) shifts the array contents one index left to replace the
	// the start element parameter. This start element is typically an element being removed from the Numbers list, called by remove().
	private void replaceShiftLeft(int start) {
		
		for (int i=start; i<numItems-1; i++) {
			collectionArr[i] = collectionArr[i+1];
		}
		
	} //end remove(int num) method
  
  
  
	// public String toString() prints a Numbers object's list contents to the console.  	
    public String toString() {
		
		// Initialize, giving an estimate of the number of characters.
		StringBuffer sb = new StringBuffer(100);
		sb.append("{");
		for(int i=0; i<numItems; i++) {
		sb.append(collectionArr[i]);
			if (i != numItems-1) {
				sb.append(",");
			}
		}
		sb.append("}");
		
		return sb.toString();
    
	} //end toString() method
	
	
	
	// method static void main(String[] args) used as a unit test.
	// @param args Not used.	
	public static void main(String[] args) { 
	  
		Numbers test = new Numbers();
		System.out.println(test);
	  
		test.add(5);
		System.out.println(test);	  
		test.add(5);
		System.out.println(test);
		test.add(4);
		System.out.println(test);
		
		//serious test add 
		Numbers testAdd = new Numbers();
		for (int i=0; i<25; i++) {
			testAdd.add(i);
			System.out.println(testAdd);
		}
		System.out.println("array capacity:" + testAdd.capacity);
		System.out.println("content size:" + testAdd.numItems);
		
		//serious test remove
		testAdd.remove(17);
		System.out.println(testAdd);
		System.out.println("array capacity:" + testAdd.capacity);
	    System.out.println("content size:" + testAdd.numItems);
		
    } //end method static void main(String[] args) unit test
	
	
} //end Numbers

