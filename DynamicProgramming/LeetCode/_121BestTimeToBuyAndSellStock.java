package DynamicProgramming.LeetCode;

public class _121BestTimeToBuyAndSellStock {

    /**
     * Time: O(n)
     * Space:O(1)
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}
