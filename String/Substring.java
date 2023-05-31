package String;

import java.util.HashMap;

public class Substring {

    /**
     * LeetCode 76
     * Hard
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] count = new int[256];
        int min = Integer.MAX_VALUE;
        int from = 0;
        int len = t.length();
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]-- > 0) {
                len--;
            }
            while (len == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++count[s.charAt(j++)] > 0) {
                    len++;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }

    /**
     * LeetCode 3
     * Medium
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    /**
     * LeetCode 340
     * Medium
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int res = 0, num = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)] ++ == 0) {
                num++;
            }
            if (num > k) {
                while (--count[s.charAt(j++)] > 0);
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    /**
     * LeetCode 395
     * Medium
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int uniqueTarget = 1; uniqueTarget <= 26; uniqueTarget++) {
            res = Math.max(res, helper(s, k , uniqueTarget));
        }
        return res;
    }
    private int helper(String s, int k, int uniqueTarget) {
        int[] count = new int[128];
        int res = 0;
        int start = 0;
        int end = 0;
        int numUnique = 0;
        int noLessThank = 0;
        while (end < s.length()) {
            if (count[s.charAt(end)]++ == 0) numUnique++;
            if (count[s.charAt(end++)] == k) noLessThank++;

            while (numUnique > uniqueTarget) {
                if (count[s.charAt(start)]-- == k) noLessThank--;
                if (count[s.charAt(start++)] == 0) numUnique--;
            }
            if (numUnique == uniqueTarget && numUnique == noLessThank) {
                res = Math.max(res, end - start);
            }
        }
        return res;
    }

    /**
     * LeetCode 159
     * Medium
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if(map.size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int num : map.values())
                    leftMost = Math.min(leftMost, num);
                map.remove(s.charAt(leftMost));
                start = leftMost + 1;
            }
            res = Math.max(res , end - start);
        }
        return res;
    }
}
