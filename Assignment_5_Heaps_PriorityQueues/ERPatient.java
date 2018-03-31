/**
 * ERPatient.java
 * @author B. Bultena
 *
 * For use with Assignment #5, UVic CSC115 (Spring 2018)
 * University of Victoria.
 */
/**
 * Class ERPatient represents the record of a patient presenting to an Emergency room.
 * Patients are assessed and registered by the triage nurse, who determines
 * their level or priority for detailed assessment and treatment in the Emergency Room.
 */
public class ERPatient implements Comparable<ERPatient> {

	private static int admissionNumber = 0;
	private int orderStamp;
	private String id;
	private String lastName;
	private String firstName;
	private int priorityNum;

	protected final static String[] categories = {"Life-threatening","Major fracture","Acute","Chronic","Ambulatory"};
	
	/**
 	 * Creates an ER record for the registered patient.
 	 * @param lastName The patient's last name.
	 * @param firstName The patient's first and subsequent names.
	 * @param triageCategory: This is the category given by the triage nurse after a preliminary assessment based on the patient's complaint and some vital signs.
	 *	The categories used, in order of priority are:
	 * 	<dl>
 	 * 	<dt>Life-threatening</dt><dd>Needs to be treated immediately.</dd>
	 * 	<dt>Major fracture</dt><dd>Needs splinting, support and possible surgery.</dd>
	 * 	<dt>Acute</dt><dd>Symptoms that indicate an unknown and unfamiliar medical condition.</dd>
	 *		<dt>Chronic</dt><dd>Symptoms appear related to an exacerbation of a known condition.</dd>
	 *		<dt>Ambulatory</dt><dd>Does not need a bed; condition will not worsen with some waiting.</dd>
	 *		</dl>
	 */
	public ERPatient(String lastName, String firstName, String triageCategory) {
		this.lastName = lastName;
		this.firstName = firstName;
		orderStamp = admissionNumber++;
		id = lastName+"_"+orderStamp++;
		priorityNum = verify_triageCategory(triageCategory);
		
	}

	private int verify_triageCategory(String triageCategory) {
		for (int i=0; i<categories.length; i++) {
			if (triageCategory.toUpperCase().equals(categories[i].toUpperCase())) {
				return i+1;
			}
		}
		throw new NoSuchCategoryException(categories());
	}

	private static String categories() {
		StringBuilder sb = new StringBuilder(10*categories.length);
		sb.append("Acceptable category list:\n\t");
		for (String s: categories) {
			sb.append(s+", ");
		}
		// the categories are never empty
		// remove the last comma and space
		sb.delete(sb.length()-2,sb.length());
		return sb.toString();
	}
				
	/**
	 * Decides which patient has the highest priority level for admission to the 
	 * Emergency room.
	 * Priority is determined first by the triage category, and then by the length of time waiting.
	 * @param other The patient record being compared to this patient record.
	 * @return a number &lt;0 indicates that this patient has higher priority.
	 * 	A number &gt;0 indicates that the other patient has higher priority.
	 * 	If 0, then the two records belong to the same patient.
	 *	@throws NullPointerException if other is null.
 	 */
	public int compareTo(ERPatient other) {
		if (other == null) {
			throw new NullPointerException("Cannot compare ERPatient to a null object");
		}
		int triageOrder = priorityNum - other.priorityNum;
		if (triageOrder == 0) {
			triageOrder = orderStamp - other.orderStamp;
		}
		return triageOrder;
	}

	/**
 	 * Equality of patient records is determined by id, which indicates that the records
	 * belong to the same person. 
	 * @param other The patient record to compare.
 	 * @return true if the records are for the same patient; false otherwise.
	 */
	public boolean equals(ERPatient other) {
		return id.equals(other.id);
	}

	/**
	 * @return The id number of this patient.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return The priority level assigned the patient.  Lower numbers have higher priority.
	 */
	public int getPriorityNum() {
		return priorityNum;
	}

	/**
	 * @return The actual triage category that was assigned the patient.
	 */
	public String getTriageCategory() {
		return categories[priorityNum-1];
	}

	/**
	 * @return The patient record information.
	 */
	public String toString() {
		return lastName+", "+firstName+": order number: "+orderStamp+", triage category: "
			+getTriageCategory();
	}

	/**
	 * Used as an internal tester.
	 * @param args Not used.
	 */
	public static void main(String[] args) {
		String[] lastnames = {"Knuth","Gosling","Hopper","Borg","Lovelace","Ritchie","Chomsky"};
		String[] firstnames = {"Donald","James","Grace","Anita","Ada","Dennis","Noam"};
		ERPatient[] patients = new ERPatient[lastnames.length];
		for (int i=0; i<lastnames.length; i++) {
			patients[i] = new ERPatient(lastnames[i],firstnames[i],
				ERPatient.categories[i%ERPatient.categories.length]);
		}
		ERPatient test = new ERPatient("Gosling","James",ERPatient.categories[1]);
		test.id = test.lastName+"_1";
		System.out.println("toString: "+test);
		System.out.println("getId: "+test.getId());
		System.out.println("getTriageCategory: "+test.getTriageCategory());
		System.out.println("getPriorityNum: "+test.getPriorityNum());
		// since the id numbers are set by the order of creation, 
		// this should not return true
		if (test.equals(patients[1])) {
			System.out.println("equals does not work with different ids ");
		} else {
			System.out.println("Problem #1");
		}
		// set the id to get the equality
		test.id = test.lastName+"_"+patients[1].id;
		test.orderStamp = patients[1].orderStamp;
		if (test.equals(patients[1])) {
			System.out.println("equals works when ids are the same");
		} else {
			System.out.println("Problem #2");
		}
		for (int i=0; i<patients.length; i++){
			if (test.compareTo(patients[i]) < 0) {
				System.out.println(test+" comes before "+patients[i]);
			} else if (test.compareTo(patients[i]) == 0) {
				System.out.println(test+" is equivalent to "+patients[i]);
			} else {
				System.out.println(test+" comes after "+patients[i]);
			}
		}
		System.out.println("All done");
	}
}

	

