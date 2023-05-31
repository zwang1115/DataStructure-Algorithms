package Design.LeetCode;

import java.util.*;

public class _381InsertDeleteGetRandom {

    ArrayList<Integer> list;
    HashMap<Integer, Set<Integer>> map;
    Random rand = new Random();

    public _381InsertDeleteGetRandom() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Set<Integer>>();

    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) map.put(val, new LinkedHashSet<Integer>());
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        int remove_idx = map.get(val).iterator().next();
        map.get(val).remove(remove_idx);
        int last = list.get(list.size() - 1);
        list.set(remove_idx, last);
        map.get(last).add(remove_idx);
        map.get(last).remove(list.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
