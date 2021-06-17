package Easy;

/* You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/

public class LC70_ClimbingStairs {

	public static int climbStairs(int n) {
        if(n == 0 || n == 1)
            return 1;
        int prev2 = 1;
        int prev1 = 1;
        int curr = 0;
        for(int i=2;i<=n;i++){
            curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
	
	public static void main(String[] args) {
		System.out.println(climbStairs(6));
	}

}
