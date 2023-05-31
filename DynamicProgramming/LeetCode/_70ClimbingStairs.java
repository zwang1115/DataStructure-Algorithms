package DynamicProgramming.LeetCode;

public class _70ClimbingStairs {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int oneStep = 1;
        int twoStep = 1;
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = res;
        }
        return res;
    }
}
