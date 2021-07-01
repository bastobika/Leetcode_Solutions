package Medium;

import java.util.Arrays;

/* It is a sweltering summer day, and a boy wants to buy some ice cream bars.
 * At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. 
 * The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 
 * Return the maximum number of ice cream bars the boy can buy with coins coins.
 * Note: The boy can buy the ice cream bars in any order.
*/

public class LC1833_MaximumIceCreamBars {

	public static int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int result = 0;
        int i = 0;
        while(i < costs.length && coins >= costs[i]){
            result++;
            coins -= costs[i];
            i++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		int arr[] = {4,6,1,6,4,2};
		System.out.println(maxIceCream(arr,15));
	}

}
