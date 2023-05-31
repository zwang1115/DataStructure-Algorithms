package Design.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _362DesignHitCounter {

    private Queue<Integer> queue;
    public _362DesignHitCounter() {
        this.queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        queue.offer(timestamp);
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peek() >= 300) {
            queue.poll();
        }
        return queue.size();
    }
}
