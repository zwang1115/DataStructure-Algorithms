package Graph.FloodFill;

/**
 * LeetCode 200
 * Medium
 * Time: O(m * n)
 * Space: O(n * m) worst
 */
public class _200NumberOfIslandsDFS {

    int col;
    int row;
    public int numIslands(char[][] grid) {
        int res = 0;
        row = grid.length;
        col = grid[0].length;
        if (grid == null || grid.length == 0) return res;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    floodfill(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void floodfill(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        floodfill(grid, i + 1, j);
        floodfill(grid, i - 1, j);
        floodfill(grid, i, j + 1);
        floodfill(grid, i, j - 1);
    }
}
