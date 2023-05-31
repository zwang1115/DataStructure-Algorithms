package DynamicProgramming.LeetCode;

import java.util.Arrays;

public class _300LongestIncreasingSubsequence {


    /**
     * Quick Select
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int [] tails = new int [nums.length];
        int size = 0;
        for (int num : nums) {
            int i = 0;
            int j = size;
            while ( i != j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) {
                    i = mid + 1;
                }
                else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == size) {
                size++;
            }

        }
        return size;
    }

    /**
     * Dynamic programming
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
