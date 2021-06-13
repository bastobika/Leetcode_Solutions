package Easy;

/*You are given an array prices where prices[i] is the price of a given stock on the i-th day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */

public class LC121_BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            profit = Math.max(0,profit + prices[i] - prices[i-1]);
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
	
	public static void main(String[] args) {
		int prices[] = {7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}

}
