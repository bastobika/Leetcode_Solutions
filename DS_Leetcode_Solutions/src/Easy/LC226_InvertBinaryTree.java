package Easy;

/* Given the root of a binary tree, invert the tree, and return its root. */

public class LC226_InvertBinaryTree {

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
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
	
	public static void main(String[] args) {
		System.out.println("Invert Binary Tree");
	}
	
}
