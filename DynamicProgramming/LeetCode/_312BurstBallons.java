package DynamicProgramming.LeetCode;

public class _312BurstBallons {

    /**
     * Time: O(n^3)
     * Space: O(n^2)
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return maxCoins(1, n, arr, dp);
    }

    private int maxCoins(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], maxCoins(i, x - 1, nums, dp) + nums[i - 1] * nums[x] * nums[j + 1]
                    + maxCoins(x + 1, j, nums, dp));
        }
        return dp[i][j];
    }
}
