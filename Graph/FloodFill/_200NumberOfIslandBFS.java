package Graph.FloodFill;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 200
 * Medium
 * Time: O(m * n)
 * Space: Not sure
 */
public class _200NumberOfIslandBFS {

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

    private void floodfill(char[][] grid, int x, int y) {
        grid[x][y] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x * col + y);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int i = cur / col;
            int j = cur % col;
            if (i < row - 1 && grid[i + 1][j] == '1') {
                queue.offer((i + 1) * col + j);
                grid[i + 1][j] = '0';
            }
            if (i > 0 && grid[i - 1][j] == '1') {
                queue.offer((i - 1) * col + j);
                grid[i - 1][j] = '0';
            }
            if (j < col - 1 && grid[i][j + 1] == '1') {
                queue.offer(i * col + (j + 1));
                grid[i][j + 1] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1') {
                queue.offer(i * col + j - 1);
                grid[i][j - 1] = '0';
            }

        }
    }
}
