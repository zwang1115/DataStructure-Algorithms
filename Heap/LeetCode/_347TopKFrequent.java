package Heap.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class _347TopKFrequent {

    /**
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {

        if (k == nums.length) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        Queue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b));


        for (int num : map.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            res[i] = pq.poll();
        }
        return res;
    }
}
