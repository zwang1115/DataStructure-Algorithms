package Stack.LeetCode;

import java.util.Stack;

public class _155MinStack {

    /**
     * Time: O(1)
     * Space: O(n)
     */
    private Stack<Integer> stack;
    private int min;
    public _155MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
