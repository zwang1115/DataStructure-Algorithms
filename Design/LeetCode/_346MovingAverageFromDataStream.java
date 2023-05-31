package Design.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _346MovingAverageFromDataStream {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    private Queue<Integer> queue;
    private double sum = 0;
    private int size;
    public _346MovingAverageFromDataStream(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == size) {
            sum -= queue.remove();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }
}
