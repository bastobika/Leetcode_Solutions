package Easy;

import java.util.ArrayList;
import java.util.List;

/* Given the root of a binary tree, return the inorder traversal of its nodes' values. */

public class LC94_BinaryTreeInorderTraversal {

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
	

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println("Inorder traversal of Binary Tree");
	}

}
