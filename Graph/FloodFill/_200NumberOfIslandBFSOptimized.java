package Graph.FloodFill;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 200
 * Medium
 * Time: O(m * n)
 * Space: Not sure
 */
public class _200NumberOfIslandBFSOptimized {

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
        grid[x][y] = '0';
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0 ,1}, {0, -1}};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] direction : directions) {
                int newX = cur.x + direction[0];
                int newY = cur.y + direction[1];
                if (isValid(grid, newX, newY)) {
                    queue.offer(new Point(newX, newY));
                    grid[newX][newY] = '0';
                }
            }
        }
    }

    private boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1';
    }

    class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

