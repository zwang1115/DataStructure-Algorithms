package Backtracking.LeetCode;

public class _52NQueensII {


    /**
     * Time: O(n!)
     * Space: O(n)
     */
    int res = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        helper(0, cols, d1, d2, n);
        return res;
    }

    private void helper(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int index1 = col - row + n;
            int index2 = col + row;
            if (cols[col] || d1[index1] || d2[index2]) continue;
            cols[col] = true; d1[index1] = true; d2[index2] = true;
            helper(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[index1] = false; d2[index2] = false;
        }
    }
}
