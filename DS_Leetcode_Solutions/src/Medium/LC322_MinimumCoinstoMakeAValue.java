package Medium;

public class LC322_MinimumCoinstoMakeAValue {

	//Auxiliary Space - O(n*amount)
	public static int coinChange(int coins[],int amount) {
		int n = coins.length;
        int dp[][] = new int[amount+1][n+1];
        for(int i=0;i<=n;i++)
            dp[0][i] = 0;
        for(int i=0;i<=amount;i++)
            dp[i][0] = Integer.MAX_VALUE;
        for(int i=1;i<=amount;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i][j-1];
                if(i >= coins[j-1] && dp[i-coins[j-1]][j] != Integer.MAX_VALUE)
                    dp[i][j] = Math.min(dp[i][j],dp[i-coins[j-1]][j]+1);
            }
        }
        return dp[amount][n] == Integer.MAX_VALUE ? -1 : dp[amount][n];
	}
	
	//Efficient - Auxiliary Space O(amount)
	public static int coinChangeEfficient(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i >= coins[j] && dp[i-coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i-coins[j]]+1,dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
	
	public static void main(String[] args) {
		int coins[] = {1,2,5};
		System.out.println(coinChangeEfficient(coins,11));
	}

}
