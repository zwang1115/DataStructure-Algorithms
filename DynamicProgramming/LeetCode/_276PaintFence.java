package DynamicProgramming.LeetCode;

public class _276PaintFence {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param n
     * @param k
     * @return
     *
     * 1 2 3
     * different color compared to previous one : (k - 1) * total
     * same color compared to previous one: 2 & 3 same = 2 & 1 different
     *
     */
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int sameColor = 0, diffColor = k, total = k;
        for (int i = 2; i <= n; i++) {
            sameColor = diffColor;
            diffColor = (k - 1) * total;
            total = diffColor + sameColor;
        }
        return total;
    }
}
