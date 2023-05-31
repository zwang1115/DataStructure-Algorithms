package ArrayList.LeetCode;

import java.util.HashMap;

public class _137SingleNumberII {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
