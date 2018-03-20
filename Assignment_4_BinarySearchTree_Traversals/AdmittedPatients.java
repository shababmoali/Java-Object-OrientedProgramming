

public class AdmittedPatients {

  TreeNode root;
  int numPatients;
  
  
  //CONSTRUCTORS:
  
  public AdmittedPatients(HospitalPatient item, AdmittedPatients leftTree, AdmittedPatients rightTree) {
	
	if ( leftTree != null && rightTree != null ) {
		this.root = new TreeNode(item, leftTree.root, rightTree.root);
	} else if (leftTree != null) {
		this.root = new TreeNode(item, leftTree.root, null);
	} else if ( rightTree != null ) {
		this.root = new TreeNode(item, null, rightTree.root);
	} else {
		//
		this.root = new TreeNode(item);
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
	public void admit(HospitalPatient patient) {
		
		this.root = insertItem(this.root, patient);
		this.numPatients++;
		
	}
	
	private TreeNode insertItem(TreeNode tNode, HospitalPatient patient) {
		
		// BASE CASE: 
		// A null position is found for a new Tree/subTree in the binary search tree.
		// Note - A binary tree at every tree node is essentially a tree of subtrees...
		if ( tNode == null ) {
			// position of insertion found; create a new node
			tNode = new TreeNode(patient);
			return tNode;
		}		
		// RECURSIVE CASE:
		// search for the insertion position:
		HospitalPatient tNodeHPItem = tNode.item;
		int cmp = patient.compareTo(tNodeHPItem);
		
		// if the patient is lower, recur down the left subtree
		if ( cmp < 0 ) {
			tNode.left = insertItem(tNode.left, patient);
		// else if the patient is higher, recur down the right subtree
		// ie ( cmp > 0 )
		} else {
			tNode.right = insertItem(tNode.right, patient);
		}
		// return the (unchanged) node pointer 
		return tNode;
		
	} //end TreeNode insertItem()



	// getPatientInfo() - Retrieves the information about a patient, given an id number. 
	// The patient's record remains in its current location in the tree.
	// Parameters: id - The id of the patient.
	// Returns: The complete record of that patient or null if the patient is not in hospital.
	public HospitalPatient getPatientInfo(String id) {
		
		return retrieveItem(this.root, id);	
		
	} //end HospitalPatient getPatientInfo()

	private HospitalPatient retrieveItem(TreeNode tNode, String id) {

		// BASE CASE: 
		// A null position is found for a new subTree in the binary search tree.
		// Note - A binary tree at every node is essentially a tree of subtrees...
		if ( tNode == null ) {
			return null;
		}
		
		HospitalPatient searchResult;
		HospitalPatient tNodeHPItem = tNode.item;
		
		// BASE CASE: 
		// A TreeNode with matching patient id is found,
		// retrieve the HospitalPatient object from the item field in the respective TreeNode
		if ( id.equals(tNodeHPItem.getId()) ) {
			searchResult = tNodeHPItem;
		// RECURSIVE CASE: 
		// search for the matching HospitalPatient TreeNode item field:
		
		// if the patient is lower, recur down the left subtree
		} else if ( id.compareTo(tNodeHPItem.getId()) < 0 ) {
			searchResult = retrieveItem(tNode.left, id);
		// else if the patient is higher, recur down the right subtree
		// ie ( id.compareTo(tNodeHPItem.getId()) > 0 )
		} else {
			searchResult = retrieveItem(tNode.right, id);
		}
		
		return searchResult;
	
	} //end HospitalPatient retrieveItem()


	
	// discharge() - Removes a patient's record from the BinarySearchTree. 
	// If the record is not there, nothing changes. 
	// If the record is in a node with no children, 
	//  then that node is removed from the tree. 
	// If the record is in a node with one child, 
	//  then that child replaces the removed node in the tree (it becomes the child of the removed node's parent).
	// If the record is in a node with two children, 
	//	then the the tree is adjusted as described on page 609 of the textbook. 
	// Essentially, it is replaced by it's inorder successor.
	// Parameters: patient - The patient record to remove.
	public void discharge(HospitalPatient patient) {
		
		this.root = deleteItem(this.root, patient);
	
	}
	
	private TreeNode deleteItem(TreeNode tNode, HospitalPatient patient) {
		
		// BASE CASE:
		if ( tNode == null )
			return tNode;
		
		// RECURSIVE CASE:
		// recursively search for the deletion position:
		HospitalPatient tNodeHPItem = tNode.item;
		int cmp = patient.compareTo(tNodeHPItem);
	
		if ( cmp < 0 ) {
			tNode.left = deleteItem(tNode.left, patient);
		} else if ( cmp > 0 ) {
			tNode.right = deleteItem(tNode.right, patient);
		// else, the subTree Node tNode item (HospitalPatient object) 
		// is the same as the patient query. Therefore, this is the tNode to be deleted 
		} else {
			
			// node with only one child or no child
			if ( tNode.left == null )
				return tNode.right;
			else if ( tNode.right == null )
				return tNode.left;
			
			// node with two children: Get the inorder successor 
			// (smallest in the right subtree)
			tNode.item = minRightSuccessor(tNode.right);
			
			// delete the inorder successor
			tNode.right = deleteItem(tNode.right, tNode.item);
				
		}
			
		return tNode;
		
	}
	
	private HospitalPatient minRightSuccessor(TreeNode tNode) {
		
		HospitalPatient minVal = tNode.item;
		while (tNode.left != null) {
			minVal = tNode.left.item;
			tNode = tNode.left;
		}
		return minVal;
		
	} 
	



	// printLocations()
	// Prints out a list of patient locations in alphabetical order, one entry per line. 
	// Formatting is defined by the getLocation method of HospitalPatient.
	public void printLocations() {
		
		printInorder(this.root);
		
	}
	
	private void printInorder(TreeNode tNode) {
		
		// BASE CASE: 
		// If subTree is empty, do not recursive call on that empty tree 
		// recursive in order printing encounters null and returns to control flow stack:
		if ( tNode == null ) {
			return;
		}
		// RECURSIVE CASE:
		/* first recur on left child */
        printInorder(tNode.left);
 
        /* then print the data of the node ie TreeNode.item*/
        System.out.println(tNode.item.getLocation());
 
        /* now recur on right child */
        printInorder(tNode.right);
		
	}
  
  
  
	
	public static void main(String[] args) {
		
		// construct AdmittedPatients object:
		AdmittedPatients adm = new AdmittedPatients();
		
		HospitalPatient p1 = new HospitalPatient(new SimpleDate(2018,2,27),"Duck","Donald",'C',123);
		HospitalPatient p2 = new HospitalPatient(new SimpleDate(2018,1,15),"Mouse","Minnie",'B',307);
		HospitalPatient p3 = new HospitalPatient(new SimpleDate(2018,3,1),"Dog","Goofie",'A',422);
		HospitalPatient p4 = new HospitalPatient(new SimpleDate(2017,12,25),"Newman","Alfred",'X',111);
		HospitalPatient p5 = new HospitalPatient(new SimpleDate(2017,12,25),"Zu","Andy",'X',111);
		HospitalPatient p6 = new HospitalPatient(new SimpleDate(2017,12,25),"Nole","Chuck",'X',111);
		HospitalPatient p7 = new HospitalPatient(new SimpleDate(2017,12,25),"Denver","Joe",'X',111);
		
		adm.admit(p1);
		adm.admit(p4);
		adm.admit(p3);
		adm.admit(p2);
		adm.admit(p6);
		adm.admit(p5);
		adm.admit(p7);
		
		// test TreeNode and subTree:
		System.out.println(adm.root.toString() + "\n");
		
		// test in-order traversal and printLocations():
		System.out.println("PrintLocations()/In-order binary search tree traversal: \n");
		adm.printLocations();
		
		// test retrieve a non-existant patient:
		System.out.println("\ngetPatientInfo()/binary search tree SEARCH: \n");

		System.out.print("Testing non-existant patient id - 'Goofy_2' : ");
		System.out.println(adm.getPatientInfo("Goofy_2"));
		// test retrieve divergent subTree:
		System.out.println(adm.getPatientInfo("Mouse_1"));
		// test retrieve leaf:
		System.out.println(adm.getPatientInfo("Zu_4"));
		// test retrieve left side:
		System.out.println(adm.getPatientInfo("Dog_2"));
		// test retrieve right side:
		System.out.println(adm.getPatientInfo("Newman_3"));
		// test retrieve right side:
		System.out.println(adm.getPatientInfo("Duck_0"));
		
		
		// delete a leaf:
		adm.discharge(p5);
		
		// delete a subTree node with two children:
		//adm.discharge(p4);
		
		
		
		
		
		// View the BinarrySearchTree data structure through the ViewableTree class,
		// which renders a tree in a resizable window.
		ViewableTree dbt = new ViewableTree(adm);
		dbt.showFrame();
		
	} //end main()
	
	
	

} //end class AdmittedPatients