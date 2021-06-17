package Medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* Given the root of a binary tree, return the right side view of the tree. */ 

public class LC199_BinaryTreeRightView {

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
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            result.add(queue.peekLast().val);
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
