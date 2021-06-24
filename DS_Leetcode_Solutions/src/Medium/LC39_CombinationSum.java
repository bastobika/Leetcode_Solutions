package Medium;

import java.util.ArrayList;
import java.util.List;

/* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers 
 * sum to target. You may return the combinations in any order.The same number may be chosen from candidates an unlimited number of times. 
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
*/

public class LC39_CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return findSum(candidates,target,0,new ArrayList<Integer>());
    }
    
    private List<List<Integer>> findSum(int candidates[],int target,int index,ArrayList<Integer> curr){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(target < 0)
            return result;
        if(target == 0){
            result.add(new ArrayList(curr));
            return result;
        }
        for(int i=index;i<candidates.length;i++){
            curr.add(candidates[i]);
            result.addAll(findSum(candidates,target-candidates[i],i,curr));
            curr.remove(curr.size()-1);
        }
        return result;
    }
    
	public static void main(String[] args) {
		System.out.println("Unique combinations leading to given sum");
	}

}
