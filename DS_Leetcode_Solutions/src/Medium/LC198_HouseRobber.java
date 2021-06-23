package Medium;

/* You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses 
 * have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, 
 * return the maximum amount of money you can rob tonight without alerting the police.
*/

public class LC198_HouseRobber {

	public static int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = nums[0];
        int curr = nums[0];
        for(int i=2;i<=nums.length;i++){
            curr = Math.max(nums[i-1] + prev2,prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
	
	public static void main(String[] args) {
		int nums[] = {3,6,2,1,8};
		System.out.println(rob(nums));
	}

}
