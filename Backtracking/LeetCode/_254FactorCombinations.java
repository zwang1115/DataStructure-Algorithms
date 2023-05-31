package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _254FactorCombinations {


    /**
     * Time: O(n^1.5)
     * Space: O(log(n))
     * @param n
     * @return
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int n, int start) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                helper(res, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
