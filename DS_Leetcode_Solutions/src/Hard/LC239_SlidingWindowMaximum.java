package Hard;

import java.util.ArrayDeque;

/* You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * Return the max sliding window.
*/

public class LC239_SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        int max = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
            max = Math.max(max,nums[i]);
        }
        int result[] = new int[nums.length-k+1];
        result[0] = max;
        int t = 1;
        for(int i=k;i<nums.length;i++){
            if(deque.peekFirst() <= i-k)
                deque.pollFirst();
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offerLast(i);
            result[t++] = nums[deque.peekFirst()];
        }
        return result;
    }
	
	public static void main(String[] args) {
		int nums[] = {1,3,-1,-3,5,3,6,7};
		System.out.println(maxSlidingWindow(nums,3));
	}

}
