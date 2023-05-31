package DynamicProgramming.LeetCode;

public class _44WildcardMatching {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int pp = 0;
        int sp = 0;
        int match_index = 0;
        int star_index = -1;

        while (sp < s.length()) {
            if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
                pp++;
                sp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                star_index = pp;
                match_index = sp;
                pp++;
            } else if (star_index != - 1) {
                pp = star_index + 1;
                match_index++;
                sp = match_index;
            } else {
                return false;
            }
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }
        return pp == p.length();
    }

    /**
     * Time: O(m * n)
     * Space: O(m * n)
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
