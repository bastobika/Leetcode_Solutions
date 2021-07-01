package Medium;

/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 *  Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken 
 *  into on the same night.Given an integer array nums representing the amount of money of each house, 
 *  return the maximum amount of money you can rob tonight without alerting the police.
*/

public class LC213_HouseRobber {

	public static int rob(int[] nums) {
        int dp[][] = new int[2][nums.length+1];
        dp[0][0] = 0; dp[1][0] = 0; dp[0][1] = nums[0];dp[1][1] = 0;
        for(int i=2;i<=nums.length;i++){
            dp[0][i] = i == nums.length ? Math.max(dp[0][i-1],dp[0][i-2]) 
                        : Math.max(dp[0][i-1],dp[0][i-2]+nums[i-1]);
            dp[1][i] = Math.max(dp[1][i-1],dp[1][i-2]+nums[i-1]);
        }
        return Math.max(dp[1][nums.length],dp[0][nums.length]);
    }
	
	public static void main(String[] args) {
		int arr[] = {2,3,2};
		System.out.println(rob(arr));
	}

}
