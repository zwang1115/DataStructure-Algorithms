package Graph.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _339NestedListWeightSum {
    /**
     * Constructor For LeetCode 339
     */
    public class NestedInteger {
        Integer value;
        List<NestedInteger> list;

        NestedInteger() {
            list = new ArrayList<>();
        }
        NestedInteger(int value) {
            this.value = value;
        }
        NestedInteger(int value, List<NestedInteger> list) {
            this.value = value;
            this.list = list;
        }

        public boolean isInteger() {
            return value != null;
        }

        public Integer getInteger() {
            return value;
        }

        public List<NestedInteger> getList() {
            return list;
        }
        public Integer next() {
            return value;
        }

        public boolean hasNext() {
            return true;
        }
    }


    /**
     * DFS
     * Time: O(n)
     * Space: O(n)
     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                res += n.getInteger() * depth;
            } else {
                res += helper(n.getList(), depth + 1);
            }
        }
        return res;
    }


    /**
     * BFS
     * Time: O(n)
     * Space: O(n)
     * @param nestedList
     * @return
     */
    public int depthSum2(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int res = 0;
        int depth = 1;

        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nest = queue.poll();
                if (nest.isInteger()) {
                    res += nest.getInteger() * depth;
                } else {
                    queue.addAll(nest.getList());
                }
            }
            depth++;
        }
        return res;
    }



}
