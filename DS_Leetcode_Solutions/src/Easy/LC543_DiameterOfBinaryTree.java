package Easy;

import Medium.LC102_LevelOrderTraversal.TreeNode;

/* Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
*/

public class LC543_DiameterOfBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
	 	TreeNode(int val) { this.val = val; }
	 	TreeNode(int val, TreeNode left, TreeNode right) {
	 		this.val = val;
	 		this.left = left;
	 		this.right = right;
	 	}
	}
	
	private static int maxDiameter;
    
    public int diameterOfBinaryTree(TreeNode root) {
        this.maxDiameter = 0;
        findHeight(root);
        return this.maxDiameter-1;
    }
    
    private int findHeight(TreeNode root){
        if(root == null)
            return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        this.maxDiameter = Math.max(this.maxDiameter,leftHeight + rightHeight + 1);
        return Math.max(leftHeight,rightHeight) + 1;
    }
    
	public static void main(String[] args) {
		System.out.println("Diameter of Binary Tree");
	}

}
