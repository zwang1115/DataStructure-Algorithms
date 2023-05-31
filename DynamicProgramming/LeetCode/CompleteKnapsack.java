package DynamicProgramming.LeetCode;

public class CompleteKnapsack {

    public int CompleteKnapsack(int[] weight, int[] value, int n, int c) {
        int[][] dp = new int[n][c + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i]]);
                }
            }
        }
        return dp[n][c];
    }

    public int CompleteKnapsack2(int[] weight, int[] value, int n, int c) {
        int[] dp = new int[c + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = c; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
        }
        return dp[c];
    }

    public int CompleteKnapsack3(int[] weight, int[] value, int n, int c) {
        int[] dp = new int[c + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = weight[i]; j <= c; j++) {
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
        }
        return dp[c];
    }
}
