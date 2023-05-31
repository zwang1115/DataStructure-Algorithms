package String.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _163MissingRanges {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        long next = lower;

        for (int i = 0; i < nums.length; i++) {
            if (next == nums[i]) {
                next++;
                continue;
            }
            res.add(Arrays.asList((int)next, nums[i] - 1));
            next = (long)nums[i] + 1;
        }
        if (next <= upper) {
            res.add(Arrays.asList((int)next, upper));
        }
        return res;
    }
}
