package String.LeetCode;

public class _158ReadNCharactersGivenRead4II {
    /**
     * Time: O(n)
     * Space: O(1)
     * @param buf
     * @param n
     * @return
     */
    private int count = 0;
    private int pointer = 0;
    char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int index = 0;
        while (index < n) {
            if (pointer == 0) {
                count = read4(temp);
            }
            if (count == 0) break;
            while (index < n && pointer < count) {
                buf[index++] = temp[pointer++];
            }
            if (pointer == count) pointer = 0;
        }
        return index;
    }



    public int read4(char[] temp) {
        return 0;
    }
}
