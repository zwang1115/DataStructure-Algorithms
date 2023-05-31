package Bitset.LeetCode;

public class _338CountingBits {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }
}
