package Tree.LeetCode;

public class _129SumRootToLeafNumbers {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return helper(root, 0);
    }

    private int helper(TreeNode root, int num) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val);
    }
}
