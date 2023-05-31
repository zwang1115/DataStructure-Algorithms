package String.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class _239SlidingWindowMaximum {

    /**
     * Time: O(n)
     * Space: O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length + 1 - k];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offerLast(i);
            if (i + 1 >= k) {
                res[i - k + 1] = nums[deque.peek()];
            }
        }
        return res;
    }
}
