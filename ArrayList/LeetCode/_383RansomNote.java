package ArrayList.LeetCode;

public class _383RansomNote {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--count[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
