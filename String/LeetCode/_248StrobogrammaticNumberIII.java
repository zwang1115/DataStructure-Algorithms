package String.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _248StrobogrammaticNumberIII {

    /**
     * Time: Not sure
     * Space: O(n)
     * @param low
     * @param high
     * @return
     */
    public int strobogrammaticInRange(String low, String high) {
        int res = 0;
        List<String> list = new ArrayList<>();
        for (int i = low.length(); i <= high.length(); i++) {
            list.addAll(helper(i, i));
        }
        for (String num : list) {
            if ((num.length() == low.length() && num.compareTo(low) < 0)
                    || (num.length() == high.length() && num.compareTo(high) > 0)) {
                continue;
            } else {
                res++;
            }
        }
        return res;
    }

    private List<String> helper(int n, int m) {
        if (n == 0) return new ArrayList<>(Arrays.asList(""));
        if (n == 1) return new ArrayList<>(Arrays.asList("0", "1", "8"));
        List<String> list = helper(n - 2, n);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (n != m) {
                res.add("0" + s + "0");
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}
