package Design.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _379DesignPhoneDirectory {

    int maxNumbers;
    HashSet<Integer> used;
    Queue<Integer> queue;
    public _379DesignPhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        this.used = new HashSet<>();
        this.queue = new LinkedList<>();
        for (int i = 0; i < maxNumbers; i++) {
            queue.offer(i);
        }
    }

    public int get() {
        Integer res = queue.poll();
        if (res == null) {
            return -1;
        }
        used.add(res);
        return res;
    }

    public boolean check(int number) {
        if (number >= maxNumbers || number < 0) {
            return false;
        }
        return !used.contains(number);
    }

    public void release(int number) {
        if (used.remove(number)) {
            queue.offer(number);
        }
    }
}
