package Tree.LeetCode;

public class _230KthSmallestElementInABST {

    /**
     * Time: O(n)
     * Space: O(n)
     */

    int count;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        res = 0;
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}
