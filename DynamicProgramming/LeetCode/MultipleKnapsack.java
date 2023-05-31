package DynamicProgramming.LeetCode;

public class MultipleKnapsack {

    public int MultipleKnapsack(int[] weight, int[] value, int[] nums, int c, int n) {
        int[] dp = new int[c + 1];

        for (int i = 0; i < n; i++) {
            for (int j = c; j >= weight[i]; j--) {
                for (int k = 0; k <= nums[i]; k++) {
                    if (j - k * weight[i] >= 0) {
                        dp[j] = Math.max(dp[j], k * value[i] + dp[j - k * weight[i]]);
                    }
                }
            }
        }
        return dp[c];
    }
}
