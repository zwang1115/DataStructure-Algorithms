package DynamicProgramming.LeetCode;

public class _132PalindromePartitioningII {

    /**
     * Time: O(m * n)
     * Space: O(m * n)
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
