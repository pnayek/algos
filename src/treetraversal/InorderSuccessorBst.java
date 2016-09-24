package treetraversal;

import java.util.Stack;

public class InorderSuccessorBst {
	/*
	 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
	 * Note: If the given node has no in-order successor in the tree, return null.
	 * 
	 * Leetcode #285, Medium
	 * Facebook, Microsoft, Pocket Gems
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// O(lg n), O(lg n)
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) return null;
		if (p.right != null) {
			// successor is the leftmost child of the right subtree
			// which is also the minimum element in the right subtree
			return minimum(p.right);
		}
		else {
			// search for node starting at root
			// if node is a right child, then it has no successor
			// if node is a left child, then its parent is its successor
			TreeNode parent = parent(root, p);
			TreeNode n = p;
			while (parent != null && parent.right == n) {
				n = parent;
				parent = parent(root, n);
			}
			return parent;
		}
	}

	private TreeNode minimum(TreeNode root) {
		if (root == null) return null;
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}

	private TreeNode parent(TreeNode root, TreeNode p) {
		if (root == null || p == null || root == p) return null;
		while (root != null) {
			if (p.val < root.val) {
				if (root.left == p) return root;
				root = root.left;
			}
			else {
				if (root.right == p) return root;
				root = root.right;
			}
		}
		return null;
	}
	
	// O(lg n), O(lg n)
	public TreeNode inorderSuccessorStack(TreeNode root, TreeNode p) {
        // leftmost child of right tree if that exists
        if (p == null) return null;
        TreeNode q = p.right;
        if (q != null) {
            TreeNode r = q.left;
            while (r != null) {
                q = r;
                r = r.left;
            }
            return q;
        }
        else {
            if (root == null || root == p) return null;
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode m = stack.peek();
                if (p.val < m.val) {
                    TreeNode n = m.left;
                    // if p is the left child
                    // then parent of p is its successor
                    if (n == p) return m;
                    stack.push(n);
                }
                else {
                    TreeNode n = m.right;
                    if (n == p) {
                        // pop till popped node becomes the left child
                        while (!stack.isEmpty() && m.left != n) {
                            n = m;
                            m = stack.pop();
                        }
                        return m.left == n ? m : null;
                    }
                    stack.push(n);
                }
            }
            return null;
        }
    }
}
