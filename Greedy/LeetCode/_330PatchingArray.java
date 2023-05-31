package Greedy.LeetCode;

public class _330PatchingArray {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @param n
     * @return
     */
    public int minPatches(int[] nums, int n) {
        int i = 0;
        int res = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                res++;
            }
        }
        return res;
    }
}
