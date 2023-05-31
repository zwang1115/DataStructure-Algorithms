package Backtracking.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class _291WordPatternII {

    /**
     * Time: O(2^n) Not sure
     * Space: O(n)
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPatternMatch(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        return helper(s, 0, pattern, 0, map, set);
    }

    public boolean helper(String s, int i, String pattern, int j, HashMap<Character, String> map, HashSet<String> set) {
        if (i == s.length() && j == pattern.length()) return true;
        if (i == s.length() || j == pattern.length()) return false;
        char c = pattern.charAt(j);
        if (map.containsKey(c)) {
            String str = map.get(c);
            if (!s.startsWith(str, i)) {
                return false;
            }
            return helper(s, i + str.length(), pattern, j + 1, map, set);
        }
        for (int k = i; k < s.length(); k++) {
            String p = s.substring(i, k + 1);
            if (set.contains(p)) {
                continue;
            }
            map.put(c, p);
            set.add(p);
            if (helper(s, k + 1, pattern, j + 1, map, set)) {
                return true;
            }
            map.remove(c);
            set.remove(p);
        }
        return false;
    }
}
