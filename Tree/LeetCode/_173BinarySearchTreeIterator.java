package Tree.LeetCode;

import java.util.Stack;

public class _173BinarySearchTreeIterator {

    /**
     * Time: O(n)
     * Space: O(h)
     */
    class BSTIterator {
        private TreeNode cur;
        private Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int val = cur.val;
            cur = cur.right;
            return val;
        }

        public boolean hasNext() {
            if (!stack.isEmpty() || cur != null) {
                return true;
            }
            return false;
        }
    }
}
