package Easy;

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
