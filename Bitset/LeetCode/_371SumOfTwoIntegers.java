package Bitset.LeetCode;

public class _371SumOfTwoIntegers {

    /**
     * Time: O(1) / O(logn)
     * Space: O(1)
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
