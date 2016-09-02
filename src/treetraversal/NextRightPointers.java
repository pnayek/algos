package treetraversal;

import java.util.ArrayList;
import java.util.List;

public class NextRightPointers {
	
	/*
	 * 
	 */
	
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		
		TreeLinkNode(int x) {
			val = x;
		}
	}
	
	// O(n), O(n)
	public void connect(TreeLinkNode root) {
        if (root == null) return;
        List<TreeLinkNode> nodes = new ArrayList<TreeLinkNode>();
        nodes.add(null);
        nodes.add(root);
        int i = 1;
        while (true) {
            TreeLinkNode node = nodes.get(i);
            if (node.left != null) nodes.add(node.left);
            if (node.right != null) nodes.add(node.right);
            if ((i & (i + 1)) != 0) {
                TreeLinkNode nextNode = nodes.get(i + 1);
                node.next = nextNode;
            }
            i++;
            if (i == nodes.size()) break;
        }
    }
}
