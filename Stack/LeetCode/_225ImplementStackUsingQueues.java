package Stack.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _225ImplementStackUsingQueues {

    Queue<Integer> queue;
    public _225ImplementStackUsingQueues() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
