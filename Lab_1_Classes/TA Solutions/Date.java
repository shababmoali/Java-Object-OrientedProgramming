// Final Solution by Anna Sollazo (CSC115 Lab TA)

public class Date {
  
  /*
  * These are the object fields
  * If they are private they may not be accessed directly (ie via dot notation) outside of the class
  * Private is usually used for security
  * Year is public to illustrate some differences that a public attribute has from a private one
  */
  private int day;
  private int month;
  int year; //because this field is not specified as private it defaults to public
  
  public Date(int day, int month, int y) {
   this.day=day;
   this.month= month;
   year =y; //because the parameter name does not match the attribute name, 'this' is not required
  }
	
  /*
  * This is what is called a default constructor
  * It is called if no values are specified
  * When you build the class, you decide what it makes sense for the default values to be
  * This default constructor just calls the other one, but it could instead set individual fields as the parametrized one does
  */
  public Date() {
	 this(1,1,1970); //Fun fact - this date is has a significance in the field of CS!
  }
	
  /*
  * These two methods are accessor methods (aka 'getters')
  * They allow us to access private fields outside of the class
  * You'll notice there isn't one for year - it doesn't require one because it is public
  */
  public int getDay() {
	 return this.day;
  }
	
  public int getMonth() {
	 return this.month;
  }
	
  /*
  * These two are what we call 'setters'
  * They exist so that we can change private attributes from outside of the class
  * Again, year doesn't have oe because it is public, meaning it can be directly changed using dot notation
  * Not that we are trusting the user not to enter bogus values (generally we NEVER trust the user)
  * If you were implementing this for real you would want to do things like check that the values are non negative and in a valid range (one that makes sense per what the fields represents)
  */
  public void setDay(int d) {
	  day= d; // again, notice that 'this' is not needed because the attribute and parameter names are different
  }
  
  public void setMonth(int month) {
	  this.month = month;
  }
	
 /*
 * A toString method allows our class to be printed in a human readble way
 * If you try to print an object that doesn't have a toString method, you'll just get a memory location (not helpful in the least!)
 * We use a string buffer (which may look familiar if you come from C)
 * It is essentially an array of chars that we append things too
 * We are using this rather than concatenation because strings are immutable in java
 * That means that when we 'change' one, a whole new String is created to replace it (which wastes space and time)
 * The buffer avoids this waste by giving us a place to contunially add things to before becoming a String
 */
  public String toString() {
	  StringBuffer sb= new StringBuffer(50);
	  sb.append("The date is ");
	  sb.append(day);
	  sb.append("/");
	  sb.append(month);
	  sb.append("/");
	  sb.append(year);
	  return sb.toString();
  }
	
 /*
 * The equals method allows us to compare if two custom objects are equal
 * It takes as a parameter an object of the type defined in the class (in this case, Date)
 * It checks for equality in each of the fields
 * If you don't like the looks of the long statement here, checks can also be done with conditionals
 * Remember that if your fields aren't primitive types you can not use '=='
 */
  public boolean equals(Date d) {
	  return (this.day==d.getDay()) && (this.month==d.getMonth()) && (this.year==d.year);
  }
	
 public static void main(String[] args) {
	 Date d1= new Date(); // uses default contructor
	 Date d2= new Date(1,8,2018);
	 System.out.println(d1);
	 System.out.println(d2);
	 System.out.println(d1.equals(d2));
	 
	 d2.setDay(3);
	 d2.year= 2017; // notice we can just use dot notation because it is public
	 System.out.println(d2);
 }
  
  
}