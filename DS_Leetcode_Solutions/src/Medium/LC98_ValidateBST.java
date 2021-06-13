package Medium;

/* Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * 			1. The left subtree of a node contains only nodes with keys less than the node's key.
 * 			2. The right subtree of a node contains only nodes with keys greater than the node's key.
 * 			3. Both the left and right subtrees must also be binary search trees.
 */

public class LC98_ValidateBST {

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
	
	private TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        boolean left = isValidBST(root.left);
        if(this.prev != null && root.val <= this.prev.val)
            return false;
        this.prev = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
    
    public boolean isValidBSTSecondApproach(TreeNode root) {
        return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    private boolean validate(TreeNode root,long low,long high){
        if(root == null)
            return true;
        return root.val > low && root.val < high 
                && validate(root.left,low,root.val) && validate(root.right,root.val,high);
    }
	public static void main(String[] args) {
		System.out.println("Validate BST");
	}

}
