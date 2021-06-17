package Medium;

import java.util.ArrayDeque;

/* Given the root of a binary tree, return the sum of values of its deepest leaves. */

public class LC1302_DeepestLeavesSum {

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
	
	public int deepestLeavesSum(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int sum = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for(int i=0;i<size;i++){
                TreeNode element = queue.pop();
                sum += element.val;
                if(element.left != null) queue.add(element.left);
                if(element.right != null) queue.add(element.right);
            }
        }
        return sum;
    }
	
	public static void main(String[] args) {
		System.out.println("Deepest Leaves Sum");
	}

}
