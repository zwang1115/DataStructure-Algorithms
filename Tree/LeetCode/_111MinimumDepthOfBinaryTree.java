package Tree.LeetCode;

public class _111MinimumDepthOfBinaryTree {

    /**
     * Time: O(n)
     * Space: O(h)
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        if (root.left == null || root.right == null) {
            return Math.max(left, right);
        }
        return Math.min(left, right);
    }
}
