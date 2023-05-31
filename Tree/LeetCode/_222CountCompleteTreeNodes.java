package Tree.LeetCode;

public class _222CountCompleteTreeNodes {

    /**
     * Time: O(logn * logn)
     * Space: O(logn)
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root, true);
        int right = helper(root, false);

        if (left == right) {
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        return isLeft ? helper(root.left, isLeft) + 1 : helper(root.right, isLeft) + 1;
    }
}
