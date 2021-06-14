package Medium;

/* You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
 * 			1.Create a root node whose value is the maximum value in nums.
 * 			2. Recursively build the left subtree on the subarray prefix to the left of the maximum value.
 *			3. Recursively build the right subtree on the subarray suffix to the right of the maximum value.
 *	Return the maximum binary tree built from nums.
 */

public class LC654_MaximumBinaryTree {

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
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructTree(nums,0,nums.length-1);
    }
    
    private TreeNode constructTree(int[] nums,int begin,int end){
        if(begin > end)
            return null;
        int index = begin;
        for(int i=begin+1;i<=end;i++)
            index = nums[index] < nums[i] ? i : index;
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructTree(nums,begin,index-1);
        root.right = constructTree(nums,index+1,end);
        return root;
    }
    
	public static void main(String[] args) {
		System.out.println("Maximum Binary Tree");
	}

}
