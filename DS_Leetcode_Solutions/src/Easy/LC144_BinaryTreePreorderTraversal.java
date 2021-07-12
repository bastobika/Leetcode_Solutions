package Easy;

import java.util.ArrayList;
import java.util.List;

/* Given the root of a binary tree, return the preorder traversal of its nodes' values. */

public class LC144_BinaryTreePreorderTraversal {

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
	
	public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println("Preorder traversal of Binary Tree");
	}

}
