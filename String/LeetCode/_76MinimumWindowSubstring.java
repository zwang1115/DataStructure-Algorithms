package String.LeetCode;

public class _76MinimumWindowSubstring {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int[] count = new int[256];
        int min = Integer.MAX_VALUE;
        int from = 0;
        int total = t.length();
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]-- > 0) {
                total--;
            }
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++count[s.charAt(j++)] > 0) {
                    total++;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
}
