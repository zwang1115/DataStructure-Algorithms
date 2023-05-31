package Backtracking.LeetCode;
import java.util.ArrayList;
import java.util.List;
public class _46Permutations {

    /**
     * Time: O(n * n!)
     * Space: O(n!)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

    /**
     * Time: O(n * n!)
     * Space: O(n!)
     * Optimized
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper2(res, nums, 0);
        return res;
    }

    private void helper2(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(new ArrayList<>(list));
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            helper2(res, nums, start +1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
