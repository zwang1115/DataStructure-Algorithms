package String.LeetCode;

public class _171ExcelSheetColumnNumber {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
