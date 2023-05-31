package Backtracking.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _93RestoreIPAddress {

    /**
     * Time: O(1)
     * Space: O(1)
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, "");
        return res;
    }

    private void helper(List<String> res, String s, int index, int count, String ret) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
            res.add(ret);
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (index + i > s.length()) break;
            String temp = s.substring(index, index + i);
            if (temp.startsWith("0") && temp.length() > 1 ||
                    i == 3 && Integer.parseInt(temp) >= 256) {
                continue;
            }
            helper(res, s, index + i, count + 1, ret + temp + (count == 3 ? "" : "."));
        }
    }
}
