package DynamicProgramming.LeetCode;

public class _188BestTimeToBuyAndSellStockIV {

    /**
     * Time: O(k * n)
     * Space:O(k * n)
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return helper(prices);
        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int temp_max = -prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + temp_max);
                temp_max = Math.max(temp_max, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }

    private int helper(int[] prices) {
        int len = prices.length;
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
