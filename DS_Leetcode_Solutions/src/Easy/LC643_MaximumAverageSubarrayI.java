package Easy;

/* You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. 
 * Any answer with a calculation error less than 10-5 will be accepted.
 */

public class LC643_MaximumAverageSubarrayI {

	public static double findMaxAverage(int[] nums, int k) {
        double sum = 0.0;
        for(int i=0;i<k;i++)
            sum += nums[i];
        double maxAvg = sum/k;
        for(int i=k;i<nums.length;i++){
            sum = sum - nums[i-k] + nums[i];
            maxAvg = Math.max(maxAvg,sum/k);
        }
        return maxAvg;
    }
	
	public static void main(String[] args) {
		int arr[] = {1,12,-5,-6,50,3};
		System.out.println(findMaxAverage(arr,4));
	}

}
