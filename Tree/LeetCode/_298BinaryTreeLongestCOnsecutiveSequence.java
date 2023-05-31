package Tree.LeetCode;

public class _298BinaryTreeLongestCOnsecutiveSequence {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, root.val);
        return res;
    }

    private void helper(TreeNode root, int max, int target) {
        if (root == null) return;
        if (target == root.val) {
            max++;
        } else {
            max = 1;
        }
        res = Math.max(res, max);
        helper(root.left, max, root.val + 1);
        helper(root.right, max, root.val + 1);
    }
}
