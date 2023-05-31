package Bitset.LeetCode;

public class _191NumberOf1Bits {


    /**
     * Time: O(1)
     * Space: O(1)
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            n &= (n-1);
            count++;
        }
        return count;
    }

    /**
     * Time: O(1)
     * Space: O(1)
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }
}
