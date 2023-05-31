package Tree.LeetCode;

public class _104MaximumDepthOfBinaryTree {


    /**
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
}
