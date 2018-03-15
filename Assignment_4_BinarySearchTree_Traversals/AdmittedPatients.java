
public class AdmittedPatients {

  private TreeNode root;
  private int numPatients;
  
  
  //CONSTRUCTORS:
  
  public AdmittedPatients(HospitalPatient item, AdmittedPatients leftTree, AdmittedPatients rightTree) {
	
	if (leftTree != null && rightTree != null) {
		root = new TreeNode(item, leftTree.root, rightTree.root);
	} else if (leftTree != null) {
		root = new TreeNode(item, leftTree.root, null);
	} else if (rightTree != null) {
		root = new TreeNode(item, null, rightTree.root);
	} else {
		root = new TreeNode(item);
	}
	numPatients = 1 + leftTree.numPatients + rightTree.numPatients;
  
  } //end AdmittedPatients()
  
  
  public AdmittedPatients(HospitalPatient item) {
	  
	  root = new TreeNode(item);
	  numPatients = 1;
	  
  } //end AdmittedPatients() - no children arguments
  
  
  public AdmittedPatients() {
	  
  } //end AdmittedPatients() - default
  
  

	//CLASS METHODS:
	
	
	
	// admit() - Enters the record of an admitted patient into the current 
	// BinarySearchTree data structure (AdmittedPatients object), maintaining the ordering of the tree. 
	// Previous records in the tree are not moved from their position. 
	// The ordering is determined by the compareTo() method of the HospitalPatient class.
	// Parameters: patient - The patient that has been admitted.
	public void admit(HospitalPatient patient) {}



	// getPatientInfo() - Retrieves the information about a patient, given an id number. 
	// The patient's record remains in its current location in the tree.
	// Parameters: id - The id of the patient.
	// Returns: The complete record of that patient or null if the patient is not in hospital.
	public HospitalPatient getPatientInfo(String id)


	
	// discharge() - Removes a patient's record from the BinarySearchTree. 
	// If the record is not there, nothing changes. 
	// If the record is in a node with no children, then that node is removed from the tree. 
	// If the record is in a node with one child, then that child replaces the removed node in the tree (it becomes the child of the removed node's parent).
	// If the record is in a node with two children, the the tree is adjusted as described on page 609 of the textbook. 
	// Essentially, it is replaced by it's inorder successor.
	// Parameters: patient - The patient record to remove.
	public void discharge(HospitalPatient patient)

	// printLocations()
	
public void printLocations()
Prints out a list of patient locations in alphabetical order, one entry per line. Formatting is defined by the getLocation method of HospitalPatient.
  
  
  
	
	public static main(String[] args) {
		
		
	} //end main()
	
	
	
	
	
	
	
	
	
	
} //end class AdmittedPatients