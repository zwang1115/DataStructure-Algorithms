package String.LeetCode;

public class _214ShortestPalindrome {

    /**
     * Time: O(n^2)
     * Space: O(n)
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            if (chars[i] == chars[j]) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }

}
