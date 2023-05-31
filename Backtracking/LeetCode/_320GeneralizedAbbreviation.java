package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _320GeneralizedAbbreviation {

    /**
     * Time: O(2^n)
     * Space: O(n)
     * @param word
     * @return
     */
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, word, 0, "", 0);
        return res;
    }

    public void helper(List<String> res, String word, int pos, String cur, int count) {
        if (pos == word.length()) {
            if (count > 0) cur += count;
            res.add(cur);
        } else {
            helper(res, word, pos + 1, cur, count + 1);
            helper(res, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
    }
}
