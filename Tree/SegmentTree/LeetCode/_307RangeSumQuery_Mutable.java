package Tree.SegmentTree.LeetCode;

public class _307RangeSumQuery_Mutable {

    int[] tree;
    int[] nums;
    int n;
    public _307RangeSumQuery_Mutable(int[] nums) {
        n = nums.length;
        tree = new int[n + 1];
        this.nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        for (int j = index + 1; j <= nums.length; j += j & (-j)) {
            tree[j] += diff;
        }
    }

    public int sumRange(int left, int right) {
        return sum(right + 1) - sum(left);
    }

    public int sum(int k) {
        int sum = 0;
        for (int i = k; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
}
