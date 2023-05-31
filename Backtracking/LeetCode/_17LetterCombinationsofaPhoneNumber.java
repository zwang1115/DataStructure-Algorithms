package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _17LetterCombinationsofaPhoneNumber {

    /**
     * Time : O(4^n * 3^n)
     * Space: O(n^3)
     */
    private String[] mappings = new String[] {"0", "1", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        helper(res, digits, "", 0);
        return res;
    }

    private void helper(List<String> res, String digits, String s, int index) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        String letters = mappings[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            helper(res, digits, s + letters.charAt(i), index + 1);
        }
    }
}
