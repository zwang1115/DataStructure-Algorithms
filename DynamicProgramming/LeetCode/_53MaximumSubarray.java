package DynamicProgramming.LeetCode;

public class _53MaximumSubarray {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum = Math.max(0, curSum) + nums[i];
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
