package Tree.LeetCode;

public class _270ClosestBinarySearchTreeValue {

    /**
     * Time: O(h)
     * Space: O(1)
     * @param root
     * @param target
     * @return
     */
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)
                    || (Math.abs(root.val - target) == Math.abs(res - target) && root.val < res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }
}
