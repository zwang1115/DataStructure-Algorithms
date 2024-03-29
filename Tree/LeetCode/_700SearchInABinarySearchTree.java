package Tree.LeetCode;

public class _700SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return  val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
