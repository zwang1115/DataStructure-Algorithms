package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _282ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        helper(res, num, "", target, 0, 0, 0);
        return res;
    }

    private void helper(List<String> res, String num, String path, int target, int pos, long val, long pre) {
        if (pos == num.length()) {
            if (target == val) {
                res.add(path);
                return;
            }
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(res, num, path + cur, target, i + 1, cur, cur);
            } else {
                helper(res, num, path + "+" + cur, target, i + 1, val + cur, cur);
                helper(res, num, path + "-" + cur, target, i + 1, val - cur, -cur);
                helper(res, num, path + "*" + cur, target, i + 1, val - pre + pre * cur, pre * cur);
            }
        }
    }
}
