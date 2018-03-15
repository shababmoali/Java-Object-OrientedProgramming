/**
 * TreeNode.java
 * @author B. Bultena
 * 
 * For use with Assignment #4, UVic CSC115 (Spring 2018)
 * University of Victoria.
 */

/**
 * Class TreeNode is a basic node used for reference-based BinaryTree data structures.
 * This specific type of node only takes HospitalPatient objects as its item.
 * It is the node that registers an item's location in a tree.
 * Note that most binary trees are very recursive and generally
 * have no need to have references pointing 'up' the tree.
 * However, if the programmer wishes to access parent nodes,
 * then these references can be set,
 * allowing access from child nodes to parents.
 */
class TreeNode {
	HospitalPatient item;
	TreeNode left;
	TreeNode right;
	// optional reference
	TreeNode parent;

	/**
	 * Creates a tree node.
	 * @param item The element contained within the tree.
	 * @param left The left child reference for this node.
	 * @param right The right child reference for this node.
	 * @param parent The reference for this node.
	 */
	TreeNode(HospitalPatient item, TreeNode left, TreeNode right, TreeNode parent) {
		this.item = item;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	/** 
	 * Creates a tree node that has no children.
	 * @param item The element contained within the tree.
	 * @param left The left child reference for this node.
	 * @param right the right child reference for this node.
	 */
	TreeNode(HospitalPatient item, TreeNode left, TreeNode right) {
		this(item,left,right,null);
	}

	/**
	 * Creates a tree node.
	 * @param item The element contained within the tree.
	 */
	TreeNode(HospitalPatient item) {
		this(item,null,null);
	}

	/**
 	 * Creates a tree node with no elements and no children.
	 */
	TreeNode() {}

/*
	// for testing purposes only
	public String toString() {
		StringBuilder sb = new StringBuilder("TreeNode: item = "+item);
		if (left != null) {
			sb.append(" with left child");
		}
		if (right != null) {
			sb.append(" with right child");
		}
		if (parent != null) {
			sb.append(" with parent");
		}
		return sb.toString();
	}
*/
		
}
