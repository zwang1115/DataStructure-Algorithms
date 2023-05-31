package Bitset.LeetCode;

public class _260SingleNumberIII {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
