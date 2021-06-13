package Easy;

/* Given an array nums of non-negative integers, return an array consisting of all the even elements of nums, followed by all the odd elements of nums.
 * You may return any answer array that satisfies this condition.
 */

public class LC905_SortArrayByParity {

	public static int[] sortArrayByParity(int[] nums) {
        int begin = -1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2 == 0){
                int temp = nums[i];
                nums[i] = nums[++begin];
                nums[begin] = temp;
            }
        }
        return nums;
    }
	
	public static void main(String[] args) {
		int arr[] = {3,4,2,1};
		System.out.println(sortArrayByParity(arr));
	}

}
