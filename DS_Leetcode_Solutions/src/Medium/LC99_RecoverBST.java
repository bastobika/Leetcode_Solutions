package Medium;

/* You are given the root of a binary search tree (BST), where exactly two nodes of the tree were swapped by mistake. 
 * Recover the tree without changing its structure.
*/

public class LC99_RecoverBST {
	
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

	private static TreeNode one;
    private static TreeNode two; 
    private static TreeNode prev;
    
    public void recoverTree(TreeNode root) {
        one = null;
        two = null;
        prev = null;
        findFaults(root);
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }
    
    private void findFaults(TreeNode root){        
        if(root == null)
            return;
        findFaults(root.left);
        if(prev != null && prev.val > root.val){
            two = root;
            one = one == null ? prev : one;
        }
        prev = root;
        findFaults(root.right);
    }
    
	public static void main(String[] args) {
		System.out.println("Fix faulty nodes of BST");
	}

}
