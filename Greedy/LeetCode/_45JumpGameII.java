package Greedy.LeetCode;

public class _45JumpGameII {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        int max = 0;
        int curArea = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == curArea) {
                res++;
                curArea = max;
            }
        }
        return res;
    }
}
