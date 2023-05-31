package ArrayList.LeetCode;

import java.util.TreeSet;

public class _363MaxSumOfRectangleNoLargerThanK {

    /**
     * Time : O[min(m,n)^2 * max(m,n) * log(max(m,n))]
     * Space: O(max(m,n))
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for (int left = 0; left < n; left++) {
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                for (int i = 0; i < m; i++) {
                    sums[i] += matrix[i][right];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cur = 0;
                for (int sum : sums) {
                    cur += sum;
                    Integer num = set.ceiling(cur - k);
                    if (num != null) {
                        res = Math.max(res, cur - num);
                    }
                    set.add(cur);
                }
            }
        }
        return res;
    }
}
