package Design.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class _170TwoSumIII {

    private HashMap<Integer, Integer> map;
    public _170TwoSumIII() {
        map = new HashMap<>();
    }

    //Time: O(1)
    public void add(int number) {
        if (!map.containsKey(number)) {
            map.put(number, 1);
        } else {
            map.put(number, map.get(number) + 1);
        }
    }

    //Time: O(n)
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = value - i;
            if (i == j && entry.getValue() > 1 || (i != j && map.containsKey(j))) {
                return true;
            }
        }
        return false;
    }
}
