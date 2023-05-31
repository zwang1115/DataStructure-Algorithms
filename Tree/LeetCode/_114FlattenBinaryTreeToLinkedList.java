package Tree.LeetCode;

import java.util.Stack;

public class _114FlattenBinaryTreeToLinkedList {

    /**
     * Time: O(n)
     * Space: O(h)
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.isEmpty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }

    TreeNode prev = null;
    public void flatten2(TreeNode root) {
        if (root == null) return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
