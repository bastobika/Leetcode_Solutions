package Medium;

import java.util.ArrayDeque;

public class LC1609_EvenOddTree {

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
	
	public boolean isEvenOddTree(TreeNode root) {
        if(root == null)
            return true;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            int prev = level%2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                TreeNode element = queue.poll();
                if(level%2 == 0 && (element.val%2 == 0 || element.val <= prev)) 
                    return false;
                else if(level%2 != 0 && (element.val%2 != 0 || element.val >= prev))   
                    return false;
                prev = element.val;
                if(element.left != null) queue.add(element.left);
                if(element.right != null) queue.add(element.right);
            }
            level++;
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println("Even odd tree");
	}

}
