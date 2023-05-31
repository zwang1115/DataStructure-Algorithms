package Tree.SegmentTree.LeetCode;

public class _304RangeSumQuery2D {

    /**
     * Time: O(m * n)
     * Space: O(m * n)
     */
    private int[][] sum;
    public _304RangeSumQuery2D(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int iMin = Math.min(row1, row2);
        int iMax = Math.max(row1, row2);
        int jMin = Math.min(col1, col2);
        int jMax = Math.max(col1, col2);
        return sum[iMax + 1][jMax + 1] - sum[iMax + 1][jMin] - sum[iMin][jMax + 1] + sum[iMin][jMin];
    }
}
