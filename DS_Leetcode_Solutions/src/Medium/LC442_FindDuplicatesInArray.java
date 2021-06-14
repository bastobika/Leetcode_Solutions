package Medium;

import java.util.ArrayList;
import java.util.List;

/* Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, 
 * return an array of all the integers that appears twice.
 * You must write an algorithm that runs in O(n) time and uses only constant extra space.
*/

public class LC442_FindDuplicatesInArray {

	//Traversing twice
	public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int mod = nums.length+1;
        for(int i=0;i<nums.length;i++){
            nums[nums[i]%mod-1] += mod;
            nums[i] -= nums[i]%mod;
        }
        for(int i=0;i<nums.length;i++)
            if(nums[i] > mod)
                result.add(i+1);
        return result;
    } 
	
	//Single pass
	public static List<Integer> findDuplicatesEfficient(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if(nums[index-1] < 0)
                result.add(index);
            else
                nums[index-1] = -nums[index-1];
        }
        return result;
    }
	
	public static void main(String[] args) {
		int arr[] = {1,1,2};
		System.out.println(findDuplicatesEfficient(arr));
	}

}
