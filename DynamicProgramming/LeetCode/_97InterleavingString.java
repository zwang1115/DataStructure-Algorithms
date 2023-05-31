package DynamicProgramming.LeetCode;

public class _97InterleavingString {

    /**
     * Time: O(m * n)
     * Space: O(m * n)
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] dp = new boolean[len2 + 1][len1 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= len2; i++) {
            dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= len1; i++) {
            dp[0][i] = dp[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                dp[i][j] = dp[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1))
                        || dp[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[len2][len1];
    }
}
