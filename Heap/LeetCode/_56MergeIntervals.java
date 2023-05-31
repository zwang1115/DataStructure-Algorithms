package Heap.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _56MergeIntervals {

    /**
     * LeetCode 56
     * Medium
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur_interval = intervals[0];
        res.add(cur_interval);

        for (int[] interval : intervals) {
            int cur_Begin = cur_interval[0];
            int cur_End = cur_interval[1];
            int next_Begin = interval[0];
            int next_End = interval[1];

            if (cur_End >= next_Begin) {
                cur_interval[1] = Math.max(next_End, cur_End);
            }
            else {
                cur_interval = interval;
                res.add(cur_interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
