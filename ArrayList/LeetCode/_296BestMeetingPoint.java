package ArrayList.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _296BestMeetingPoint {

    /**
     * Time: O(m * n)
     * Space: O(n) linear
     * @param grid
     * @return
     */
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    J.add(j);
                }
            }
        }
        return min(I) + min(J);
    }

    private int min(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        int sum = 0;
        while (i < j) {
            sum += list.get(j--) - list.get(i++);
        }
        return sum;
    }
}
