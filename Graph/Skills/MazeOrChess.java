package Graph.Skills;



import java.util.LinkedList;
import java.util.Queue;

public class MazeOrChess {

    private boolean MazeHasPath(int[][] maze, int[] start, int[] destination) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0 ,1}, {0, -1}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == destination[0] && cur.y == destination[1]) {
                return true;
            }
            for (int[] direction : directions) {
                int newX = cur.x + direction[0];
                int newY = cur.y + direction[1];
                if (isValid(maze, newX, newY) && !visited[newX][newY]) {
                    queue.offer(new Point(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1;
    }

    class Point {
        int x;
        int y;

        public Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    private int MazeShortestPath(int[][] maze, int[] start, int[] destination) {
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0 ,1}, {0, -1}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int res = 0;

        Queue<Point2> queue = new LinkedList<>();
        queue.offer(new Point2(start[0], start[1]));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point2 cur = queue.poll();
                if (cur.x == destination[0] && cur.y == destination[1]) {
                    return res - 1;
                }
                for (int[] direction : directions) {
                    int newX = cur.x + direction[0];
                    int newY = cur.y + direction[1];
                    if (isValid(maze, newX, newY) && !visited[newX][newY]) {
                        queue.offer(new Point2(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid2(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 1;
    }

    class Point2 {
        int x;
        int y;

        public Point2 (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {1, 1, 1, 0, 0},
                {1, 0, 1, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
        };
        MazeOrChess mazeOrChess = new MazeOrChess();
        System.out.println(mazeOrChess.MazeHasPath(maze, new int[]{0, 0}, new int[]{4, 4}));
        System.out.println(mazeOrChess.MazeShortestPath(maze, new int[]{0, 0}, new int[]{4, 4}));
    }
}
