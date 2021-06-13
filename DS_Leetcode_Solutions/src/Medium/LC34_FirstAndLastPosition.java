package Medium;

/* Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class LC34_FirstAndLastPosition {
	
	public static int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = findBegin(nums,target);
        result[1] = result[0] == -1 ? -1 : findEnd(nums,target,result[0]);
        return result;
    }
    
    private static int findBegin(int[] nums,int target){
        int begin = 0;
        int end = nums.length-1;
        int mid = 0;
        while(begin <= end){
            mid = (begin+end)/2;
            if(nums[mid] == target){
                if(mid > 0 && nums[mid-1] == target)
                    end = mid-1;
                else
                    return mid;
            }
            else if(nums[mid] > target)
                end = mid-1;
            else if(nums[mid] < target)
                begin = mid+1;
        }
        return -1;
    }
    
    private static int findEnd(int[] nums,int target,int begin){
        int end = nums.length-1;
        int mid = 0;
        while(begin <= end){
            mid = (begin+end)/2;
            if(nums[mid] == target){
                if(mid < end && nums[mid+1] == target)
                    begin = mid+1;
                else
                    return mid;
            }
            else if(nums[mid] > target)
                end = mid-1;
            else if(nums[mid] < target)
                begin = mid+1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	int arr[] = {2,5,5,5,8,9};
    	System.out.println(searchRange(arr,5));
    }
}
