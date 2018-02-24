// Final Solution by Anna Sollazo (CSC115 Lab TA)

public class Numbers {
 int[] collection;
 private int numItems; // this variable keeps track of the actual number of things a user has inserted which is NOT the same as the length of the array used to represent the collection
 
 public Numbers() {
  collection = new int[10];
  numItems=0;
 }
	
 public void add(int num) {
	 // case where it is full - need to deal with resizing and copying
	 if(numItems==collection.length) {
		 copyAndResize();	 
	 }
	 // when you reach this point you definitly have space because a) you did in the first place or b) you just resized your array
	 collection[numItems] = num;
	 numItems++;
 }
 /*
 * looks for target item
 * once it finds it, in shifts everything after it one to the left
 * doing so 'deletes' the item by overwriting it
 * don't forget to decrement your numItems!
 */
 public void remove(int num) {
	 for(int i=0; i<numItems; i++) {
		 if(collection[i]==num) {
			 shiftLeft(i);
			 numItems--;
			 break;
		 }
	 }
 }
	
 /*
 * this is an alternative way to do remove by 'swapping' rather than shifting
 * it only works because we don's care about order in this collection
 * it 'deletes' the item by overwriting it with the current last value in the collection
 * don't forget to decrement numItems
 */
 public void altRemove(int num) {
	 for(int i=0;i< numItems; i++) {
		 if(collection[i]==num) {
			 collection[i]= collection[numItems-1];
			 numItems--;
			 break;
		 }
	 }
 }
	
 /*
 * This to string method uses string buffer to avoid repeated concatenation
 * This could be an issue if you have a super long list
 * You could be cleverer than I have been and base the parameter off of the number of things in your list * their probable size + the required # of spaes for braces andd commas
 * Or you can just use concatenation
 * There are many ways to address this fencepost problem
 * This method handles it by prepending a space and comma whenever it is NOT the first item in the list
 */
 public String toString() {
	 StringBuffer sb =new StringBuffer(100);
	 sb.append("{");
	 for(int i=0;i< numItems; i++) {
		 if(i!=0) {
			 sb.append(", ");
		 }
		 sb.append(collection[i]);
	 }
	 sb.append("}");
	 return sb.toString();
 }
	
 /*
 * helper method fore add
 * it makes a new array that is double the length of the old
 * copies the data of the old
 * then chages references so that the class array variable points to the new (larger) array
 */
 private void copyAndResize() {
	 int[] newArr = new int[collection.length*2];
	 for(int i=0;i< collection.length; i++) {
		 newArr[i]= collection[i];
	 }
	 collection= newArr;
 }
	
 // helper method for remove 
 private void shiftLeft(int index) {
	 for (int i=index; i< numItems-1 ;i++) {
		 collection[i] = collection[i+1];
	 }
 }
	
 // for testing
 public static void main(String[] args) {
	 Numbers coll = new Numbers();
	 System.out.println(coll);
	 coll.add(4);
	 coll.add(-5);
	 System.out.println(coll);
	 for(int i=2; i<20; i+=2 ) {
		 coll.add(i);
	 }
	 System.out.println(coll);
	 coll.remove(4);
	 System.out.println(coll);
	 coll.altRemove(10);
	 System.out.println(coll);
 }
	
}