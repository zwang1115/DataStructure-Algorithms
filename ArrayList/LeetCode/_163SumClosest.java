package ArrayList.LeetCode;

import java.util.Arrays;
public class _163SumClosest {

    /**
     * Time: O(n^2)
     * Space: O(1)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[i] + nums[high];
                if (sum < target) {
                    low++;
                } else if (sum > target) {
                    high--;
                } else {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}
