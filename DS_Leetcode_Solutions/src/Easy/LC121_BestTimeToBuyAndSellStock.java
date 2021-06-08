package Easy;

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
