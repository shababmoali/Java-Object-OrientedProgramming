/**
 * EmergencyTriage.java
 * Provided the necessary information here,
 * making sure to delete these lines.
 */

// This is the beginning of the source code to help you get started.
// Do not change the following:

public class EmergencyTriage {
  
  private Heap<ERPatient> waiting;

  /**
  * Constructor - The empty EmergencyTriage is initialized.
  */
  public EmergencyTriage() {
	waiting = new Heap<>();
  }
  
// end do not change  
  
	//register():
	// A patient is registed at triage. The triage nurse creates a record for the patient,
	// and the patient is then added to the triage queue.
	// Parameters: lastName - The patient's last name.
	// firstName - The patient's first and subsequent names.
	// triageCategory - The triage category assigned to the patient by the triage nurse.
	public void register(String lastName,
                     String firstName,
                     String triageCategory) {
		
		ERPatient newRecord = new ERPatient(lastName, firstName, triageCategory);
		waiting.insert(newRecord);
						 
						 
	
	} //end register()
	

	
	//admitToER():
	// Removes the highest priority patient from triage to enter the Emergency Room.
	// Returns: The record of the patient that is moving into the Emergency Room.
	public ERPatient admitToER() {
		
		if ( !waiting.isEmpty() ) {
			ERPatient removeFromTriage = waiting.getRootItem();
			return removeFromTriage;
		} 
		return null;
		
	} //end ERPatient admitToER()


	
	//whoIsNext():
	// Retrieves the record of the patient who currently has the highest priority. 
	// The patient's record remains in the queue.
	// Returns: The record of the patient.
	public ERPatient whoIsNext() {
		
		if ( !waiting.isEmpty() ) {
			ERPatient next = waiting.getRootItem();
			waiting.insert(next);
			return next;
		}
		return null;
		
	} //end ERPatient whoIsNext()


	
	//numberOfPatientsWaiting():
	// Returns: The number of patients who have been registered into triage, 
	// but not yet admitted to the Emergency Room.
	public int numberOfPatientsWaiting() {
		
		return waiting.size();
		
	} //end int numberOfPatientsWaiting()
	
	

	
	//main():
	// Used as an internal tester.
	// Parameters: args - Not used.
	public static void main(String[] args) {
		
		EmergencyTriage test = new EmergencyTriage();
		
		// Test number of patients waiting:
		System.out.println("Number of Patients Waiting: " + test.numberOfPatientsWaiting());
		
		// Test admittoER() and whoIsNext() on empty heap:
		System.out.println("\nTest admittoER() and whoIsNext() on empty heap:");
		try {
			System.out.println("\nAdmit to ER: " + test.admitToER().toString());
			System.out.println("\nWho is Next: " + test.whoIsNext().toString());
		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}

		
		// Test register() Patients:
		test.register("Doyle", "Mike", ERPatient.categories[0]);
		test.register("Sanyo", "Takeshi", ERPatient.categories[2]);
		test.register("Nakomoto", "Satoshi", ERPatient.categories[1]);
		test.register("Ng", "Vinny", ERPatient.categories[3]);
		test.register("Ali", "Imran", ERPatient.categories[0]);
		
		System.out.println("\nEmergency Triage Priority Queue: " + test.waiting.toString());
		System.out.println("Number of Patients Waiting: " + test.numberOfPatientsWaiting());
		
		
		// Test admitToER()
		
		
		
		
		
		
		// Test whoisNext():
		System.out.println("\nWho is Next: " + test.whoIsNext().toString());
		System.out.println("\nEmergency Triage Priority Queue: " + test.waiting.toString());
		System.out.println("Number of Patients Waiting: " + test.numberOfPatientsWaiting());
	} //end main(String[] args)

	
		
	
} //end class EmergencyTriage