/*
* Name: <Shabab Ali>
* Date: <Jan 9 2018>
* Filename: <Sample.java>
* Details: <CSC115\Lab1\Sample.java>: A Java program (verified compiler - JDK8u131) 
    that meets the criteria for developing:
		A single file which compiles as a Java file, and contains at least 2 constructors, 
		2 data fields, a toString method and a main method.
*/


public class Sample {

	  
  public static void main(String[] args) {
	
	// Instantiate 2 new Person objects utilizing 2 different constructors.
	// Use class method toString() to validate new Person objects.
	Person newMan1 = new Person();
    Person newWoman1 = new Person("Julie Gartman", 25);
	System.out.println();
	System.out.println(newMan1.toString());
	System.out.println(newWoman1.toString());
	
	// Test setter class method setName():
	System.out.println("\nUpdate Details:"); 
	newMan1.setName("Shabab Ali");
	newMan1.setAge(25);
	System.out.println(newMan1.toString());
	
	// Test getter class method getAge():
	System.out.println(newMan1.getAge());
	
  } //end method main(String[] args)

  
} //end Program Sample


/*
* The class Person contains name and age attributes for
* Person objects, and class methods (behaviours) for setting the attributes and
* getting Person object details. 
*/
  class Person {
	  
    private String name;
    private int age;

      // constructor 1
	  public Person() {
        this.name = "John Doe";
        this.age = 0;
      }
  
	  // constructor 2
	  public Person(String name, int age) {
        this.name = name;
        this.age = age;
	  }
	
	  // name setter
	  public void setName(String name) {
	    this.name = name;
	  }
	
	  // age setter
	  public void setAge(int age) {
	    this.age = age;
	  }
	
	  // name getter
	  public String getName() {
	    return this.name;
	  }
	
	  // age getter
	  public int getAge() {
	    return this.age;
	  }
	
	  // get Person object details
	  public String toString() {
	    return ("Person's name is " + name + ", age: " + age);  
	  }

  } // end class Person
