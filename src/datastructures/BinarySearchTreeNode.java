package datastructures;

public class BinarySearchTreeNode extends BinaryTreeNode {
	
	public int val;
	public BinarySearchTreeNode left;
	public BinarySearchTreeNode right;
	
	public BinarySearchTreeNode(int val) {
		super(val);
		this.val = val;
	}

	public static BinarySearchTreeNode insert(BinarySearchTreeNode root, int val) {
		BinarySearchTreeNode node = new BinarySearchTreeNode(val);
		if (root == null) {
			root = node;
			return root;
		}
		BinarySearchTreeNode n = root;
		while (true) {
			if (val <= n.val) {
				// insert node in the left subtree
				if (n.left == null) {
					n.left = node;
					return root;
				}
				else {
					n = n.left;
				}
			}
			else {
				// insert node in the right subtree
				if (n.right == null) {
					n.right = node;
					return root;
				}
				else {
					n = n.right;
				}
			}
		}
	}
	
	public static BinarySearchTreeNode minimum(BinarySearchTreeNode root) {
		if (root == null) return null;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public static BinarySearchTreeNode parent(BinarySearchTreeNode root, BinarySearchTreeNode node) {
		if (root == null || node == null) return null;
		if (root.val == node.val) {
			// then node is root assuming no duplicates
			// parent of root is null
			return null;
		}
		else if (node.val < root.val) {
			// node is in left subtree
			if (root.left == null) {
				return null;
			}
			else if (root.left.val == node.val) {
				return root;
			}
			else {
				return parent(root.left, node);
			}
		}
		else {
			// node is in right subtree
			if (root.right == null) {
				return null;
			}
			else if (root.right.val == node.val) {
				return root;
			}
			else {
				return parent(root.right, node);
			}
		}
 	}
	
	public static BinarySearchTreeNode successor(BinarySearchTreeNode root, BinarySearchTreeNode node) {
		if (root == null || node == null) return null;
		if (node.right != null) {
			// successor is the leftmost child of the right subtree
			// which is also the minimum element in the right subtree
			return minimum(node.right);
		}
		else {
			// search for node starting at root
			// if node is a right child, then it has no successor
			// if node is a left child, then its parent is its successor
			BinarySearchTreeNode parent = parent(root, node);
			BinarySearchTreeNode n = node;
			while (parent != null && parent.right == n) {
				n = parent;
				parent = parent(root, n);
			}
			return parent;
		}
	}
	
	public static void testSuccessor() {
		BinarySearchTreeNode root = new BinarySearchTreeNode(15);
		BinarySearchTreeNode leftTree = new BinarySearchTreeNode(3);
		leftTree.left = new BinarySearchTreeNode(2);
		leftTree.right = new BinarySearchTreeNode(4);
		BinarySearchTreeNode rightTree = new BinarySearchTreeNode(18);
		rightTree.left = new BinarySearchTreeNode(17);
		rightTree.right = new BinarySearchTreeNode(20);
		root.left = leftTree;
		root.right = rightTree;
	
		BinarySearchTreeNode successor = successor(root, root);
		if (successor.val != 17) {
			throw new IllegalStateException("Incorrect result");
		}
		successor = successor(root, leftTree.right);
		if (successor.val != 15) {
			throw new IllegalStateException("Incorrect result");
		}
		successor = successor(root, leftTree.left);
		if (successor.val != 3) {
			throw new IllegalStateException("Incorrect result");
		}
		successor = successor(root, rightTree.left);
		if (successor.val != 18) {
			throw new IllegalStateException("Incorrect result");
		}
		successor = successor(root, rightTree.right);
		if (successor != null) {
			throw new IllegalStateException("Incorrect result");
		}
		
	}
	
	public static void main(String[] args) {
		testSuccessor();
	}
}
