package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _216CombinationSumIII {

    /**
     * Time: O(2^n * n)
     * Space: O(2^n * n)
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (k < 0 || n < 0) {
            return;
        }
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
