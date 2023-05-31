package Tree.SegmentTree.LeetCode;

public class _303RangeSumQuery_Immutable {

    private int[] sum;
    public _303RangeSumQuery_Immutable(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
