package Medium;

/* Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree. */

public class LC230_KthSmallestElementInBST {

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
	
	private static int count;
    
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        return find(root,k);
    }
    
    private static int find(TreeNode root,int k){
        if(root == null)
            return -1;
        int left = find(root.left,k);
        if(left != -1)  return left;
        if(++count == k)
            return root.val;
        int right = find(root.right,k);
        if(right != -1) return right;
        return -1;
    }
    
	public static void main(String[] args) {
		System.out.println("Kth smallest element in a BST");
	}

}
