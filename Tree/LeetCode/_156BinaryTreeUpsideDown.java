package Tree.LeetCode;

public class _156BinaryTreeUpsideDown {

    /**
     * Time: O(n)
     * Space: O(h)
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) return root;
        TreeNode newRoot =  upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;

        return newRoot;
    }
}
