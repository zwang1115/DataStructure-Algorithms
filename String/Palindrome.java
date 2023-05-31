package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Palindrome {

    /**
     * LeetCode 125
     * Easy
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * LeetCode 9
     * Easy
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {
            return false;
        }
        int palindrome = x;
        int reverse = 0;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return palindrome == reverse;
    }

    /**
     * LeetCode 266
     * Easy
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        char[] count = new char[256];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                res++;
            }
        }
        return res <= 1;
    }

    /**
     * LeetCode 214
     * Hard
     * e
     * i j
     * a b c d a
     * @param s
     * @return
     */

    public String shortestPalindrome(String s) {
        int i = 0, j = s.length();
        int end = s.length();
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }

    /**
     * LeetCode 5
     * Medium
     */
    String res = "";
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        for (int i = 0; i < s.length(); i++) {
            helper(s, i ,i);
            helper(s, i, i + 1);
        }
        return res;
    }

    private void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }

    /**
     * LeetCode 336
     * Hard
     * @param words
     * @return
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindrome336(str1)) {
                    String str2reverse  = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2reverse) && map.get(str2reverse) != i) {
                        res.add(Arrays.asList(map.get(str2reverse), i));
                    }
                }
                if (str2.length() != 0 && isPalindrome336(str2)) {
                    String str1reverse = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1reverse) && map.get(str1reverse) != i) {
                        res.add(Arrays.asList(i, map.get(str1reverse)));
                    }
                }
            }
        }
        return res;

    }
    private boolean isPalindrome336(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * LeetCode 131
     * Medium
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(res, new ArrayList<>(), s);
        return res;
    }

    private void helper(List<List<String>> res, List<String> list, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome131(s.substring(0, i + 1))) {
                list.add(s.substring(0, i + 1));
                helper(res, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome131(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * LeetCode 267
     * Medium
     * @param s
     * @return
     */
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }
        if (odd > 1) return res;

        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) mid += key;
            for (int i = 0; i < val / 2; i++) {
                list.add(key);
            }

        }
        helper(list,mid,new boolean[list.size()], new StringBuilder(), res);
        return res;
    }

    private void helper(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
        if (sb.length() == list.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                helper(list, mid, used, sb, res);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    /**
     * LeetCode 132
     * Hard
     * @param s
     * @return
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cuts[j - 1] + 1);
                    cuts[i] = min;
                }
            }
        }
        return cuts[len - 1];
    }
}
