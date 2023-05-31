package Tree.LeetCode;

public class _285InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (p.val >= root.val) {
            return inorderSuccessor2(root.right, p);
        } else {
            TreeNode res = inorderSuccessor2(root.left, p);
            return res != null ? res : root;
        }
    }
}
