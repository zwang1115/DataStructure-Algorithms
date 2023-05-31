package Tree.LeetCode;

import java.util.Stack;

public class _255VerifyPreorderSequenceInBinarySearchTree {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int nums : preorder) {
            if (nums < min) {
                return false;
            }
            while (!stack.isEmpty() && nums > stack.peek()) {
                min = stack.pop();
            }
            stack.push(nums);
        }
        return true;
    }
}
