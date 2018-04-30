
/*
* Name: <Shabab Ali>
* Date: <Apr 8 2018>
* Filename: <EmergencyTriage.java>
* Details: <CSC115\Assn5\EmergencyTriage.java>: A Java program (verified compiler - JDK8u131) 
			that meets the criteria for developing an Emergency Triage system. 
			This is basically a priority queue for Emergency patient records. 
			Records are released out of the queue once the patient is released
			from triage. This program uses a heap data structure (implemented in this
			assignment) as its main data field.
*/



// This is the beginning of the source code to help you get started.
// DO NOT CHANGE the following:

public class EmergencyTriage {

  private Heap<ERPatient> waiting;

  /**
  * Constructor - The empty EmergencyTriage is initialized.
  */
  public EmergencyTriage() {
	waiting = new Heap<>();
  }

// END DO NOT CHANGE



	//public void register():
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



	//public ERPatient admitToER():
	// Removes the highest priority patient from triage to enter the Emergency Room.
	// Returns: The record of the patient that is moving into the Emergency Room.
	public ERPatient admitToER() {
		
		if ( !waiting.isEmpty() ) {
			ERPatient removeFromTriage = waiting.getRootItem();
			return removeFromTriage;
		} 
		return null;
		
	} //end ERPatient admitToER()



	//public ERPatient whoIsNext():
	// Retrieves the record of the patient who currently has the highest priority. 
	// The patient's record remains in the queue.
	// Returns: The record of the patient.
	public ERPatient whoIsNext() {
		
		if ( !waiting.isEmpty() ) {
			ERPatient nextPatient = waiting.peekAtRootItem();
			return nextPatient;
		}
		return null;
		
	} //end ERPatient whoIsNext()



	//public int numberOfPatientsWaiting():
	// Returns: The number of patients who have been registered into triage, 
	// but not yet admitted to the Emergency Room.
	public int numberOfPatientsWaiting() {
		
		return waiting.size();
		
	} //end int numberOfPatientsWaiting()



	//main(String[] args):
	// Used as an internal tester.
	// Parameters: args - Not used.
	// Uses toString() class method in Heap.java.
	public static void main(String[] args) {

		EmergencyTriage test = new EmergencyTriage();

		// Test number of patients waiting:
		System.out.println("Number of Patients Waiting: " + test.numberOfPatientsWaiting());


		// Test whoIsNext() on empty heap:
		System.out.println("\nTest whoIsNext() on empty heap:");
		try {
			System.out.println("\nWho is Next: " + test.whoIsNext().toString());
		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}


		// Test admittoER() on empty heap:
		System.out.println("\nTest admittoER() on empty heap:");
		try {
			System.out.println("\nAdmit to ER: " + test.admitToER().toString());
		} catch (NullPointerException npe) {
			System.out.println(npe.getMessage());
		}


		// Test register() Patients:
		test.register("Doyle", "Mike", ERPatient.categories[0]);
		test.register("Sanyo", "Takeshi", ERPatient.categories[2]);
		test.register("Nakomoto", "Satoshi", ERPatient.categories[1]);
		test.register("Ng", "Vinny", ERPatient.categories[3]);
		test.register("Paul", "Noah", ERPatient.categories[0]);
		test.register("Paul", "Dan", ERPatient.categories[0]);
		test.register("Paul", "Ian", ERPatient.categories[0]);
		test.register("Paul", "Sally", ERPatient.categories[0]);
		test.register("Paul", "Mary", ERPatient.categories[0]);
		test.register("Tyson", "Mike", ERPatient.categories[2]);

		System.out.println("\nEmergency Triage Priority Queue: " + test.waiting.toString());
		System.out.println("Number of Patients Waiting: " + test.numberOfPatientsWaiting());


		// Test admitToER()
		System.out.println("\nAdmit to ER: " + test.admitToER().toString());
		System.out.println("\nEmergency Triage Priority Queue: " + test.waiting.toString());
		System.out.println("Number of Patients Waiting: " + test.numberOfPatientsWaiting());


		// Test whoisNext():
		System.out.println("\nWho is Next: " + test.whoIsNext().toString());
		System.out.println("\nEmergency Triage Priority Queue: " + test.waiting.toString());
		System.out.println("Number of Patients Waiting: " + test.numberOfPatientsWaiting());

	} //end main(String[] args)



} //end class EmergencyTriage