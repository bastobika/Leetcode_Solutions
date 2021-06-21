package Medium;

/* The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
 * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
*/


public class LC337_HouseRobber {

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
	
	public int rob(TreeNode root) {
        int arr[] = findMax(root);
        return Math.max(arr[0],arr[1]);
    }
    
    private int[] findMax(TreeNode root){
        int arr[] = new int[2];
        if(root == null)
            return arr;
        int[] left = findMax(root.left);
        int[] right = findMax(root.right);
        arr[0] = root.val + left[1] + right[1];
        arr[1] = Math.max(Math.max(left[0]+right[0],left[1]+right[0]),
                          Math.max(right[1]+left[0],right[1]+left[1]));
        return arr;
    }
    
	public static void main(String[] args) {
		System.out.println("House Robber");
	}

}
