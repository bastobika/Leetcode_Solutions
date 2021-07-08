package Medium;

import java.util.ArrayList;
import java.util.List;

/* Given two binary search trees root1 and root2. Return a list containing all the integers from both trees sorted in ascending order.*/

public class LC1305_AllElementsInTwoBSTs {

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
	
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> tree1 = preOrder(root1);
        ArrayList<Integer> tree2 = preOrder(root2);
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0; int j = 0;
        while(i < tree1.size() && j < tree2.size()){
            if(tree1.get(i) > tree2.get(j)){
                result.add(tree2.get(j));
                j++;
            }else if(tree1.get(i) < tree2.get(j)){
                result.add(tree1.get(i));
                i++;
            }else{
                result.add(tree2.get(j));
                j++;
                result.add(tree1.get(i));
                i++;
            }
        }
        while(i < tree1.size()){
            result.add(tree1.get(i));
            i++;
        }
        while(j < tree2.size()){
            result.add(tree2.get(j));
            j++;
        }
        return result;
    }
    
    private ArrayList<Integer> preOrder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null)
            return result;
        result.addAll(preOrder(root.left));
        result.add(root.val);
        result.addAll(preOrder(root.right));
        return result;
    }
    
	public static void main(String[] args) {
		System.out.println("All elements of two BSTs");
	}

}
