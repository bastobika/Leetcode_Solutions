package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 */

public class LC40_CombinationSum {

	public List<List<Integer>> combinationSum2(int[] A, int target) {
        Arrays.sort(A);
        return findSum(A,target,0,new ArrayList<Integer>());
    }
    
    static private List<List<Integer>> findSum(int[] A,int target,int index,ArrayList<Integer> curr){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(target < 0)
            return result;
        if(target == 0){
            result.add(new ArrayList(curr));
            return result;
        }
        int prev = 0;
        for(int i=index;i<A.length;i++){
            if(prev != A[i]){
                curr.add(A[i]);
                prev = A[i];
                result.addAll(findSum(A,target-A[i],i+1,curr));
                curr.remove(curr.size()-1);
            }
        }
        return result;
    }
    
	public static void main(String[] args) {
		System.out.println("Unique combinations leading to given sum");
	}

}
