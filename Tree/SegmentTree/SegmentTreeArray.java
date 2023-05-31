package Tree.SegmentTree;

public class SegmentTreeArray {

    private int[] segmentTree;

    private int length;

    public SegmentTreeArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        segmentTree = new int[4 * nums.length];
        length = nums.length - 1;
        buildTree(nums, 0, nums.length - 1, 0);
    }

    private int buildTree(int[] nums, int start, int end, int index) {
        if (start == end) {
            segmentTree[index] = nums[start];
            return segmentTree[index];
        }
        int mid = start + (end - start) / 2;
        int left = buildTree(nums, start, mid, index * 2 + 1);
        int right = buildTree(nums, mid + 1, end, index * 2 + 2);
        segmentTree[index] = left + right;
        return segmentTree[index];
    }

    public void update(int i, int val) {
        update(0, length, 0, i, val);
    }

    private void update(int start, int end, int index, int pos, int val) {
        if (start == end) {
            segmentTree[index] = val;
        }
        int mid = start + (end - start) / 2;
        if (pos <= mid) {
            update(start, mid, index * 2 + 1, pos, val);
        } else {
            update(mid + 1, end, index * 2 + 2, pos, val);
        }
        segmentTree[index] = segmentTree[index * 2 + 1] + segmentTree[index * 2 + 2];
    }

    public int sumRange(int i, int j) {
        return sumRange(0, length, 0, i, j);
    }

    private int sumRange(int start, int end, int index, int left, int right) {
        if (left <= start && end <= right) {
            return segmentTree[index];
        }
        int mid = start + (end - start) / 2;
        if (right < mid) {
            return sumRange(start, mid, index * 2 + 1, left, right);
        } else if (left > mid) {
            return sumRange(mid + 1, end, index * 2 + 2, left, right);
        } else {
            return sumRange(start, mid, index * 2 + 1, left, right)
                    + sumRange(mid + 1, end, index * 2 + 2, left, right);
        }
    }
}
