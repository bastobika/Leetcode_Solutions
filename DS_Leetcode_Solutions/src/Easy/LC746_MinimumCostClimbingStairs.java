package Easy;

/* You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
*/

public class LC746_MinimumCostClimbingStairs {

	public static int minCostClimbingStairs(int[] cost) {        
        int prev2 = cost[0];
        int prev1 = cost[1];
        int curr = 0;
        for(int i=2;i<=cost.length;i++){
            curr = i < cost.length ? cost[i] : 0;
            curr += Math.min(prev1,prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
	
	public static void main(String[] args) {
		int cost[] = {10,15,20};
		System.out.println(minCostClimbingStairs(cost));
	}

}
