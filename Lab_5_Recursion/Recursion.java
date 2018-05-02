// A few basic recursive algorithms implemented in Java:


public class Recursion {

	
	public static void printStars(int n) {
		
		if (n == 1) {
		// base case; just print one star
			System.out.println("*");
		} else {
		// recursive case; print one more star
			System.out.print("*");
			printStars(n - 1);
		}
	}
	
	
	public static void printStarsb(int n) {
		
		if (n == 0) {
		// base case; just end the line of output
			System.out.println(".");
		} else {
		// recursive case; print one more star
			System.out.print("*");
			printStarsb(n - 1);
		}

	}

	
	public static int factorial(int n) {

		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n-1);
		}

	}


	public static String reverseString(String s) {
		
		if (s.equals("")) {
			return "";
		} else {
			System.out.println((s.substring(1)) + s.charAt(0));
			return reverseString(s.substring(1)) + s.charAt(0);
		}

	}


	public static int recursGCD(int p, int q) {
		
		System.out.println(p + "," + q);
		// base case
		int r = p%q;
		if (r == 0) {
			return q;
		} 
		return recursGCD( q, p%q );

	
	}
	
	
	public static int binarySearch(int anArray[], int first, int last, int value) {
		
		if (first > last) {
			return -1;
		} else {
			
			int index;
			int mid = (first + last)/2;
			
			if (value == anArray[mid]) {
				index = mid;
			} else if (value < anArray[mid]) {
				index = binarySearch(anArray, first, mid-1, value);
			} else {
				index = binarySearch(anArray, mid+1, last, value);
			}
			return index;
		}
	
	}	 
	
	
	public static void main(String[] args) {
		
		printStars(5);
		printStarsb(5);
		
		String s = "bye";
		System.out.println(reverseString(s));
		
		System.out.println(recursGCD(21,15));
		
		int[] A = {2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearch(A, A[0], A[A.length-1], 4));
		
	} //end main (String[] args)
	
	
} //end class Recursion




