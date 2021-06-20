package Medium;

import java.util.PriorityQueue;

/* Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/

public class LC215_KthLargestElementInAnArray {

	public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++){
            if(pq.size() == k && pq.peek() < nums[i])
                pq.poll();
            if(pq.size() < k)
                pq.add(nums[i]);
        }
        return pq.peek();
    }
	
	public static void main(String[] args) {
		int arr[] = {4,3,1,8,5,2,9};
		System.out.println(findKthLargest(arr,3));
	}

}
