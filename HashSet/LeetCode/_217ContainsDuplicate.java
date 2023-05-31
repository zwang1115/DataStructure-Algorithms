package HashSet.LeetCode;

import java.util.HashSet;

public class _217ContainsDuplicate {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
