package Medium;

/* Construct BST from preorder traversal */

public class LC1008_BSTFromPreorderTraversal {

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
	
	private static int index;
	
    public TreeNode bstFromPreorder(int[] preorder) {
        index = -1;
        return construct(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    private TreeNode construct(int[] preorder,int begin,int end){
        index++;
        if(index >= preorder.length || preorder[index] <= begin || preorder[index] >= end){
            index--;
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        root.left = construct(preorder,begin,root.val);
        root.right = construct(preorder,root.val,end);
        return root;
    }
    
	public static void main(String[] args) {
		System.out.println("Construct BST from preorder traversal");
	}

}
