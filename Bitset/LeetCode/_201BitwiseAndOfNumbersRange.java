package Bitset.LeetCode;

public class _201BitwiseAndOfNumbersRange {

    /**
     * Time: < O(n)
     * Space: O(1)
     * @param left
     * @param right
     * @return
     */
    public int rangeBitwiseAnd(int left, int right) {
        int offset = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            offset++;
        }
        return left << offset;
    }
}
