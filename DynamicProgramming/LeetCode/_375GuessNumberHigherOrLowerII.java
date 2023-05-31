package DynamicProgramming.LeetCode;

public class _375GuessNumberHigherOrLowerII {

    /**
     * Time: O(n^3)
     * Space: O(n^2)
     */

    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return getMoneyAmount(1, n);
    }

    private int getMoneyAmount(int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int x = i; x <= j; x++) {
            res = Math.min(res, x + Math.max(getMoneyAmount(i, x - 1), getMoneyAmount(x + 1, j)));
        }
        dp[i][j] = res;
        return res;
    }
}
