package DynamicProgramming.LeetCode;

public class _152MaximumProductSubarray {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        if (nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = max;

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int temp_max = Math.max(cur, Math.max(max * cur, min * cur));
            min = Math.min(cur, Math.min(max * cur, min * cur));
            max = temp_max;
            res = Math.max(max, res);
        }
        return res;
    }
}
