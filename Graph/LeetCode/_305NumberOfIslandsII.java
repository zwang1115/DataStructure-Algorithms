package Graph.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UnionFind
 * Time: O(n^2)
 * Space: O(n * m)
 */
public class _305NumberOfIslandsII {

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;

        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        for (int[] pairs : positions) {
            int position = n * pairs[0] + pairs[1];
            if (roots[position] != -1) {
                res.add(count);
                continue;
            }
            roots[position] = position;
            count++;
            for (int[] dir : dirs) {
                int x = pairs[0] + dir[0];
                int y = pairs[1] + dir[1];
                int curPos = n * x + y;
                if (x < 0 || x >= m || y < 0 || y >= n || roots[curPos] == -1) {
                    continue;
                }
                int anotherIsland = find(roots, curPos);
                if (position != anotherIsland) {
                    roots[position] = anotherIsland;
                    position = anotherIsland;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private int find(int[] roots, int i) {
        while (i != roots[i]) {
            i = roots[i];
        }
        return i;
    }
}
