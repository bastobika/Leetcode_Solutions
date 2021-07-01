package Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values. (i.e., from left to right, level by level from leaf to root). */

public class LC107_LevelOrderTraversal {

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
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        queue.add(root);
        while(!queue.isEmpty()){            
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode element = queue.poll();
                level.add(element.val);
                if(element.left != null) queue.add(element.left);
                if(element.right != null) queue.add(element.right);
            }
            result.add(level);
        }
        for(int i=0;i<result.size()/2;i++){
            List<Integer> temp = result.get(i);
            result.set(i,result.get(result.size()-1-i));
            result.set(result.size()-1-i,temp);
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println("Reverse Level Order Traversal");
	}

}
