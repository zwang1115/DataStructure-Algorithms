package Stack.LeetCode;

import java.util.Stack;

public class _232ImplementQueueUsingStacks {


    Stack<Integer> stack1;
    Stack<Integer>stack2;
    public _232ImplementQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //Time: O(n)
    public void push(int x) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    //Time: O(1)
    public int pop() {
        return stack1.pop();
    }
    //Time: O(1)
    public int peek() {
        return stack1.peek();
    }
    //Time: O(1)
    public boolean empty() {
        return stack1.isEmpty();
    }
}
