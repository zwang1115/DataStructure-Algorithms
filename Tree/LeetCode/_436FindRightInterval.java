package Tree.LeetCode;

import java.util.TreeMap;


public class _436FindRightInterval {
    /**
     * Time: O(nlogn)
     * Space: O(n)
     * @param intervals
     * @return
     */

    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }

        for (int i = 0; i < intervals.length; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key != null ? map.get(key) : -1;
        }
        return res;
    }
}
