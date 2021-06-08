package Medium;

import Easy.LC700_SearchInBST.TreeNode;

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
