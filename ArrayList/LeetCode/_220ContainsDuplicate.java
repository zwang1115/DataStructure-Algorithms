package ArrayList.LeetCode;

import java.util.TreeSet;

public class _220ContainsDuplicate {

    /**
     * Time: O(nlogk)
     * Space: O(k)
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff < 1 || valueDiff < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = set.ceiling((long)nums[i] - valueDiff);
            Long floor = set.floor((long)nums[i] + valueDiff);
            if (floor != null && floor >= nums[i]
                    || ceil != null && ceil <= nums[i]) {
                return true;
            }
            set.add((long)nums[i]);
            if (i >= indexDiff) {
                set.remove((long)nums[i - indexDiff]);
            }
        }
        return false;
    }
}
