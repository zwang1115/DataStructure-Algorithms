package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _140WordBreakII {

    /**
     * Time: O(n * 2^n)
     * Space: O(n)
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        helper(s, res, 0, new ArrayList<>(), set);
        return res;
    }

    private void helper(String s, List<String> res, int index, List<String> path, HashSet<String> set) {
        if (index == s.length()) {
            res.add(String.join(" ", path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String str = s.substring(index, i + 1);
            if (set.contains(str)) {
                path.add(str);
                helper(s, res, i + 1, path, set);
                path.remove(path.size() - 1);
            }
        }
    }
}
