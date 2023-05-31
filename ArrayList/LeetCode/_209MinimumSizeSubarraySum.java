package ArrayList.LeetCode;

public class _209MinimumSizeSubarraySum {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= target) {
                res = Math.min(res, i- left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
