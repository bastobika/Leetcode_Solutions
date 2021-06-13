package Medium;

/* Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * 			1. Search for a node to remove.
 * 			2. If the node is found, delete the node.
 * Follow up: Can you solve it with time complexity O(height of tree)?
*/
public class LC450_DeleteNodeInABST {

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
	
	//Recursive - Needs extra space
	public TreeNode deleteNodeRecursive(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val > key)
            root.left = deleteNodeRecursive(root.left,key);
        else if(root.val < key)
            root.right = deleteNodeRecursive(root.right,key);
        else{
            if(root.right == null)
                return root.left;
            TreeNode temp = root.left;
            if(temp == null)
                return root.right;
            while(temp.right != null)
                temp = temp.right;
            temp.right = root.right.left;
            root.right.left = root.left;
            root = root.right;
        }
        return root;
    }
	
	//Iterative - No extra space
	public TreeNode deleteNodeIterative(TreeNode root, int key) {
        TreeNode prev = null;
        TreeNode temp = root;
        while(temp != null){
            if(temp.val > key){
                prev = temp;
                temp = temp.left;
            }else if(temp.val < key){
                prev = temp;
                temp = temp.right;
            }else{
                if(prev == null)
                    return deleteRootNode(temp);
                if(prev.left == temp)
                    prev.left = deleteRootNode(temp);
                else
                    prev.right = deleteRootNode(temp);
                break;
            }
        }
        return root;
    }
    
    private TreeNode deleteRootNode(TreeNode root){
        if(root.right == null && root.left == null)
            return null;
        if(root.right == null)
            return root.left;
        if(root.left == null)
            return root.right;
        TreeNode maxLeft = root.left;
        while(maxLeft.right != null)
            maxLeft = maxLeft.right;
        maxLeft.right = root.right.left;
        root.right.left = root.left;
        root = root.right;
        return root;
    }
	
	public static void main(String[] args) {
		System.out.println("Delete a node from BST");
	}

}
