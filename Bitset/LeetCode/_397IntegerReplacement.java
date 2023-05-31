package Bitset.LeetCode;

public class _397IntegerReplacement {

    /**
     * Time: O(logn)
     * Space: O(1)
     * @param n
     * @return
     */
    public int integerReplacement(int n) {
        Long N = (long)n;
        int res = 0;
        while (N != 1) {
            if (N % 2 == 0) {
                N >>= 1;
            } else {
                if (N == 3) {
                    res += 2;
                    break;
                } else {
                    N = (N & 2) == 2 ? N + 1 : N - 1;
                }
            }
            res++;
        }
        return res;
    }
}
