package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _39CombinationSum {

    /**
     * Time: O(2^n * n)
     * Space: O(2^n * n)
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
