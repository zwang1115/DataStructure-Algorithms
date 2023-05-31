package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _401BinaryWatch {

    /**
     * Time: Not sure
     * Space: O(n)
     * @param turnedOn
     * @return
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[] {8, 4, 2, 1};
        int[] nums2 = new int[] {32, 16, 8, 4, 2, 1};
        for (int i = 0; i <= turnedOn; i++) {
            List<Integer> list1 = generate(nums1, i);
            List<Integer> list2 = generate(nums2, turnedOn - i);
            for (int num1 : list1) {
                if (num1 >= 12) continue;
                for (int num2 : list2) {
                    if (num2 >= 60) continue;
                    res.add(num1 + ":" +( num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generate(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        helper(res, nums, count, 0, 0);
        return res;
    }

    private void helper(List<Integer> res, int[] nums, int count, int start, int sum) {
        if (count == 0) {
            res.add(sum);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            helper(res, nums, count -1, i + 1, sum + nums[i]);
        }
    }
}
