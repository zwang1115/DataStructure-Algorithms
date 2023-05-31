package Graph.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class _364NestedListWeightSumII {

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
     * Time: O(n)
     * Space: O(n)
     * @param nestedList
     * @return
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int res) {
        List<NestedInteger> list = new LinkedList<>(nestedList);
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger();
            } else {
                list.addAll(nest.getList());
            }
        }
        res += list.isEmpty() ? 0 : helper(list, res);
        return res;
    }
}
