package Hard;

/* Given an unsorted integer array nums, find the smallest missing positive integer.
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
*/

public class LC41_FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
        int n = nums.length + 1;
        for(int i=0;i<nums.length;i++)
            if(nums[i] <= 0 || nums[i] >= n)
                nums[i] = 0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i]%n;
            if(num != 0){  
                nums[num-1] += num*n;
                nums[i] -= num; 
            }           
        }
        for(int i=0;i<nums.length;i++)
            if(nums[i] == 0)
                return i+1;
        return n;
    }
	
	public static void main(String[] args) {
		int arr[] = {3,4,-1,1};
		System.out.println(firstMissingPositive(arr));
	}

}
