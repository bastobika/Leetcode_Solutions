package Easy;

/* Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence (i.e. subarray). 
 * The subsequence must be strictly increasing.
 * A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 
 * and for each l <= i < r, nums[i] < nums[i + 1].
*/

public class LC674_LongestContinuousIncreasingSubsequence {

	public static int findLengthOfLCIS(int[] nums) {
        int longest = 1;
        int curr = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1])
                curr++;
            else{
                longest = Math.max(curr,longest);
                curr = 1;
            }
        }
        longest = Math.max(curr,longest);
        return longest;
    }
	
	public static void main(String[] args) {
		int arr[] = {4,3,5,9,8,2,3,6,7,8};
		System.out.println(findLengthOfLCIS(arr));
	}

}
