package Easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* Given the root of a binary tree, return the average value of the nodes on each level in the form of an array. */

public class LC637_AverageOfLevelsInBinaryTree {

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
	
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<Double>();
        if(root == null)
            return result;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            double sum = 0;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode element = queue.poll();
                sum += element.val;
                if(element.left != null)    queue.add(element.left);
                if(element.right != null)    queue.add(element.right);
            }
            result.add(sum/size);
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println("Average of each levels in Binary Tree");
	}

}
