package ArrayList.LeetCode;

import java.util.HashMap;

public class _1TwoSum {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
