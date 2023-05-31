package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _60Permutation {

    /**
     * Time: O(n^2)
     * Space: O(n)
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(i);
        }

        int[] fact = new int[n];
        fact[0] = 1;

        for(int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }
        k = k - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k %= fact[i - 1];
            sb.append(res.get(index));
            res.remove(index);
        }
        return sb.toString();
    }
}
