package ArrayList.LeetCode;

import java.util.Arrays;

public class _2593SumSmaller {

    /**
     * Time: O(n^2)
     * Space: O(1)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < target) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
