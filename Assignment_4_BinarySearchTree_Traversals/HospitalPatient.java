/**
 * HospitalPatient.java
 * @author B. Bultena
 * 
 * For use with Assignment #4, UVic CSC115 (Spring 2018)
 * University of Victoria.
 */

/**
 * Class HospitalPatient is a data structure that represents the record (information)
 * about an admitted patient in the hospital.
 * The information in this record is used by many of the non-medical departments in the hospital,
 * so it is limited.
 * Medical history, pharamacological information, diagnoses, etc, are not included.
 * Mainly information that a department, such as the Admissions Department is kept in the record.
 * The unique identification of any hospital patient is a concatenation of their last name,
 * immediately followed by an underscore, and then a uniquely generated number.
 */

	public class HospitalPatient {
		private static long admissionNumber;
		private String id;
		private String lastName;
		private String firstName;
		private SimpleDate admitDate;
		private char ward;
		private int roomNumber;

	/*
 	 * Creates a new Hospital patient record.
	 * @param admitDate The day the patient is officially admitted to hospital
	 * @param lastname The patient's last name.
	 * @param firstname The patient's first name.
	 * @param ward Each hospital ward is designated as an uppercase letter.
	 * @param roomNumber The 3-digit room number, first digit relates to the floor level.
	 */
	public HospitalPatient(SimpleDate admitDate, String lastName, String firstName, char ward, int roomNumber) {
		this.admitDate = admitDate;
		this.lastName = lastName;
		this.firstName = firstName;
		this.ward = ward;
		this.roomNumber = roomNumber;
		id = lastName+"_"+admissionNumber++;
	}

	/**
	 * @return A formatted string representing all the information about the patient.
	 */
	public String toString () {
		return getLocation()+"\tadmitted: "+admitDate+"\tid: "+id;
	}

	/**
	 * @return The unique id of the patient.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return The patient's last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return The patient's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @return a formatted string of the patient's full name and their current location in the hospital.
	 */
	public String getLocation() {
		return lastName+","+firstName+":\t"+ward+roomNumber;
	}

	/**
	 * Determines if two patients have identical id numbers, which in this case, means that they are the same.
	 * @param other The patient to compare to this patient.
	 * @return true if the id numbers are identical.
	 */
	public boolean equals(HospitalPatient other) {
		return id == other.id;
	}

	/**
	 * Determines the lexicographic order of the ids of two patients.
	 * @param other The patient to compare to this patient.
	 * @return if &lt;0 then this patient is earlier in a sequence,
	 *			if &gt;0 then this patient is later in a sequence,
	 *			if = 0, then this patient and the other patient are equivalent.
	 */
	public int compareTo(HospitalPatient other) {
		return id.compareTo(other.id);
	}

	/**
	 * Updates the new location for a patient who has been moved into a new room.
	 * @param ward The single letter representing the ward.
	 * @param roomNumber The 3-digit room number.
	 */
	public void move(char ward, int roomNumber) {
		this.ward = ward;
		this.roomNumber = roomNumber;
	}

	/**
	 * Used for internal testing.
	 * @param args Not used in this class.
	 */
	public static void main(String[] args) {
		HospitalPatient p1 = new HospitalPatient(new SimpleDate(2018,3,9),"Duck","Donald",'B',420);
		HospitalPatient p2 = new HospitalPatient(new SimpleDate(2018,3,7),"Mouse","Minnie",'D',333);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p1.getId());
		System.out.println(p1.getLastName());
		System.out.println(p1.getFirstName());
		System.out.println(p1.getLocation());
		p1.move('F',104);
		System.out.println(p1);
		if (!p1.equals(p2)) {
			System.out.println("not the same patient");
		}
		int cmp = p1.compareTo(p2);
		if (cmp < 0) {
			System.out.println(p1.getId()+" comes before "+p2.getId());
		} else  if (cmp > 0){
			System.out.println(p2.getId()+" comes before "+p1.getId());
		} else {
			System.out.println("something is wrong");
		}
	}
			
}
			
