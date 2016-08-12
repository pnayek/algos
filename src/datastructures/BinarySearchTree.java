package datastructures;

public class BinarySearchTree {

	public BinaryTreeNode root;
	
	public BinarySearchTree() {
	}
	
	public BinarySearchTree(BinaryTreeNode root) {
		this.root = root;
	}
	
	public void insert(int val) {
		BinaryTreeNode node = new BinaryTreeNode(val);
		if (root == null) {
			root = node;
			return;
		}
		BinaryTreeNode n = root;
		while (true) {
			if (val <= n.val) {
				// insert node in the left subtree
				if (n.left == null) {
					n.left = node;
					return;
				}
				else {
					n = n.left;
				}
			}
			else {
				// insert node in the right subtree
				if (n.right == null) {
					n.right = node;
					return;
				}
				else {
					n = n.right;
				}
			}
		}
	}
}
