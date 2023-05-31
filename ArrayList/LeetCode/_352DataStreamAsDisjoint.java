package ArrayList.LeetCode;


import java.util.TreeMap;

public class _352DataStreamAsDisjoint {

    /**
     * Time: O(logn)
     */
    TreeMap<Integer, int[]> map;
    public _352DataStreamAsDisjoint() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {
        if (map.containsKey(value)) return;
        Integer lowerKey = map.lowerKey(value);
        Integer higherKey = map.higherKey(value);

        if (lowerKey != null && higherKey != null && map.get(lowerKey)[1] + 1 == value
                && map.get(higherKey)[0] == value + 1) {
            map.get(lowerKey)[1] = map.get(higherKey)[1];
            map.remove(higherKey);
        } else if (lowerKey != null && value <= map.get(lowerKey)[1] + 1) {
            map.get(lowerKey)[1] = Math.max(value, map.get(lowerKey)[1]);
        } else if (higherKey != null && value == map.get(higherKey)[0] - 1) {
            map.put(value, new int[]{value, map.get(higherKey)[1]});
            map.remove(higherKey);
        } else {
            map.put(value, new int[]{value, value});
        }
    }

    public int[][] getIntervals() {
        return map.values().toArray(new int[][]{});
    }
}
