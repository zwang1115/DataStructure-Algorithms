package String.LeetCode;

import java.util.HashMap;

public class _294FlipGameII {

    /**
     * Time: O(2^n) not sure
     * Space: O(2^n)
     * @param currentState
     * @return
     */
    public boolean canWin(String currentState) {
        if (currentState == null || currentState.length() == 0) return false;
        HashMap<String, Boolean> map = new HashMap<>();
        return helper(currentState, map);
    }

    private boolean helper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opps = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(opps, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
