package Medium;

import java.util.ArrayDeque;

/* Given the root of a binary tree, return the leftmost value in the last row of the tree. */

public class LC513_FindBottomLeftTreeValue {

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
	
	public int findBottomLeftValue(TreeNode root) {
        if(root == null)
            return root.val;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int result = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            result = queue.peek().val;
            for(int i=0;i<size;i++){
                TreeNode element = queue.poll();
                if(element.left != null)    queue.add(element.left);
                if(element.right != null)   queue.add(element.right);
            }
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println("Right View of Binary Tree");
	}

}
