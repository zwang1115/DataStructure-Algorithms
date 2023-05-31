package Tree.Traversal;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Time: O(n)
 * Space: O(h)
 */
public class Postorder {

    public void postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return;
        }
        helper(res, root);
        print(res);
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(list, root.left);
        helper(list, root.right);
        list.add(root.val);
    }

    private void postorder2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            res.addFirst(cur.val);
        }
        print(res);
    }

    private void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get((i)) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
        Postorder postorder = new Postorder();
        postorder.postorder2(root);
    }
}
