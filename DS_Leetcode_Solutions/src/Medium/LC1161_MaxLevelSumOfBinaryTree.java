package Medium;

import java.util.ArrayDeque;

/* Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
*/

public class LC1161_MaxLevelSumOfBinaryTree {

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
	
	public int maxLevelSum(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int sum = 0, maxSum = Integer.MIN_VALUE, curr = 0, level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            curr++;
            for(int i=0;i<size;i++){
                TreeNode element = queue.pop();
                sum += element.val;
                if(element.left != null) queue.add(element.left);
                if(element.right != null) queue.add(element.right);
            }
            if(sum > maxSum){
                maxSum = sum;
                level = curr;
            }
        }
        return level;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
