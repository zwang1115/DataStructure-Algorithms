package Heap.LeetCode;

import java.util.PriorityQueue;

public class _295MedianFinder {

    private PriorityQueue<Long> small;
    private PriorityQueue<Long> large;
    public _295MedianFinder() {
        this.small = new PriorityQueue<>();
        this.large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2.0;
    }
}
