public class recExamples {
	public static void main(String[] args) {
		System.out.println(gcd(54,24));
		System.out.println(isPalindrome("racecar"));
		int[] arr = {1,2,3,4,5,6};
		printArr(reverse(arr));
		System.out.println(mult(6,4));
		int[] arr2 = {-1,7,4,21,5,8,-3};
		System.out.println(largestInArr(arr2));

	}
	//base case is if x%y==0 (aka y evenly divides y)
	// note that even if y divides x, one recursive call will occur
	public static int gcd (int x, int y) {
		if(y==0) {
			return x;
		}
		return gcd(y,x%y);
	}
	//base case 1 or 0 letters
	public static boolean isPalindrome(String s) {
		if(s.length()==0 || s.length()==1) {
			return true;
		}
		if(s.charAt(0)==s.charAt(s.length()-1)) {
			return isPalindrome(s.substring(1,s.length()-1));
		}
		return false;
	}
	//helper method because a user doesn't nee to know the specifcs of your reverse method
	public static int[] reverse(int[] arr) {
		return recReverse(0, arr.length-1, arr);
	}
	//private because we don't want a user to directly access it
	//base case is when start is equal to, or has passed, end
	//recall start and end are just keeping track of the part of he array we currently 'care' about
	private static int[] recReverse(int start,int end, int[] arr) {
		if(end <= start) {
			return arr;
		}
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		return recReverse(start+1, end-1, arr);

	}
	//just for display/debugging
	//would reccommend including something lie this in any program you write that uses arrays
	//replace the print statements with buffer appends and you've got an array toString
	public static void printArr(int[] arr) {
		for(int i=0;i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	//base case is when either is 0
	//mathematically speaking, we only need to check b for the recursion to work
	//we just check a to avoid pointless recursive calls
	public static int mult(int a, int b) {
		if(a==0 || b==0) {
			return 0;
		}
		return a + mult(a,b-1);
	}
  //another helper method so users needn't know specifics
	public static int largestInArr(int[] arr) {
		return recLargest(0,arr.length-1, arr);
	}
  //base case is one element
	//find middle
	//recurse on either side of the array (will keep splitting until it is indidividual elements)
	//return the bigger half (each call)
	//try a box trace to fully understand what's going on here
	private static int recLargest(int first, int last, int[] arr) {
		if(first==last) {
			return arr[first];
		}
		int mid = (first + last)/2;
		int firstHalf = recLargest(first, mid, arr);
		int secondHalf = recLargest(mid+1, last, arr);
		if(firstHalf > secondHalf) {
			return firstHalf;
		}
		else {
			return secondHalf;
		}
	}
}
