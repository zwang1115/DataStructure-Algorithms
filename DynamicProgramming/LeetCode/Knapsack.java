package DynamicProgramming.LeetCode;

public class Knapsack {

    public int knapsack(int[] weight, int[] value, int n, int c) {
        int[][] dp = new int[n][c + 1];

        for (int i = 0; i <= c; i++) {
            dp[0][i] = (i >= weight[0]) ? value[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
                }
            }
        }
        return dp[n - 1][c];
    }


    public int knapsack2(int[] weight, int[] value, int n, int c) {
        int[][] dp = new int[2][c + 1];

        for (int i = 0; i <= c; i++) {
            dp[0][i] = (i >= weight[0]) ? value[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                if (j < weight[i]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                } else {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], value[i] + dp[(i - 1) % 2][j - weight[i]]);
                }
            }
        }
        return dp[(n - 1) % 2][c];
    }


    //Optimized
    public int knapsack3(int[] weight, int[] value, int n, int c) {
        int[] dp = new int[c + 1];

        for (int i = 0; i <= c; i++) {
            dp[i] = (i > weight[0]) ? value[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = c; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
        }
        return dp[c];
    }
}
