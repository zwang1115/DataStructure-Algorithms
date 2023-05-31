package DynamicProgramming.LeetCode;

public class _213HouseRobberII {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int low, int high) {
        int prevNo = 0;
        int cur = 0;
        for (int i = low; i <= high; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, cur);
            cur = nums[i] + temp;
        }
        return Math.max(prevNo, cur);
    }
}
