package DynamicProgramming.LeetCode;

public class _198HouseRobber {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int prevNo = 0;
        int cur = 0;
        for (int num : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, cur);
            cur = num + temp;
        }
        return Math.max(prevNo, cur);
    }
}
