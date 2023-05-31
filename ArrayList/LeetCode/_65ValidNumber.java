package ArrayList.LeetCode;

public class _65ValidNumber {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        s = s.toLowerCase().trim();
        boolean numSeen = false;
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numberAfterE = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numSeen && numberAfterE;
    }
}
