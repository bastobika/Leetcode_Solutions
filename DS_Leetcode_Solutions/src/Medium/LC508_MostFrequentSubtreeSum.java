package Medium;

import java.util.HashMap;
import java.util.Map;

public class LC508_MostFrequentSubtreeSum {

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
	
	private static int count;
    private static int max;
    
    public static int[] findFrequentTreeSum(TreeNode root) {
        count = 0;
        max = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        calculateSum(root,map);
        int result[] = new int[count];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
            if(max == entry.getValue()){
                result[i] = entry.getKey();
                i++;
            }
        return result;
    }
    
    private static int calculateSum(TreeNode root,HashMap<Integer,Integer> map){
        if(root == null)
            return 0;
        int sum = root.val + calculateSum(root.left,map) + calculateSum(root.right,map);
        if(map.containsKey(sum))
            map.put(sum,map.get(sum)+1);
        else
            map.put(sum,1);
        count = max < map.get(sum) ? 1 : (max == map.get(sum) ? count+1 : count);
        max = Math.max(max,map.get(sum));
        return sum;
    }
    
	public static void main(String[] args) {
		System.out.println("Most frequent subtree sum");
	}

}
