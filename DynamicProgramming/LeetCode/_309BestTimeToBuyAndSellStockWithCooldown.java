package DynamicProgramming.LeetCode;

public class _309BestTimeToBuyAndSellStockWithCooldown {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int sell = 0, prevSell = 0;
        int buy = Integer.MIN_VALUE, prevBuy = 0;

        for (int price : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - price, prevBuy);
            prevSell = sell;
            sell = Math.max(sell, price + prevBuy);
        }
        return sell;
    }
}
