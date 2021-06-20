package Easy;

public class LC724_FindPivotIndex {

	public static int pivotIndex(int[] nums) {
        int sum = 0;
        for(int i=0;i<nums.length;i++)
            sum += nums[i];
        int leftSum = 0;
        for(int i=0;i<nums.length;i++){
            if(sum - leftSum - nums[i] == leftSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int nums[] = {1,7,3,6,5,6};
		System.out.println(pivotIndex(nums));
	}

}
