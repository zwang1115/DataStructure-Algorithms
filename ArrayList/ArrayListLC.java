package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArrayListLC {
    /**
     * leetCode 215
     * Medium
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            }
            else if (pos + 1 > k) {
                right = pos - 1;
            }
            else {
                left = pos + 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * LeetCode 347
     * Medium
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int num : map.keySet()) {
            int freq = map.get(num);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }


    /**
     * LeetCode 378
     * Medium
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        while (low + 1 < high) {
            int mid = (high - low) / 2 + low;
            int num = count(matrix, mid);
            if (num >= k) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (count(matrix, high) <= k - 1) {
            return high;
        } else {
            return low;
        }

    }

    private int count(int[][] matrix, int mid) {
        int n = matrix.length;
        int res = 0;
        int i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] < mid) {
                res += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return res;
    }

    /**
     * LeetCode 56
     * Medium
     * Linear Search (PriorityQueue)
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur_interval = intervals[0];
        res.add(cur_interval);

        for (int[] interval : intervals) {
            int cur_Begin = cur_interval[0];
            int cur_End = cur_interval[1];
            int next_Begin = interval[0];
            int next_End = interval[1];

            if (cur_End >= next_Begin) {
                cur_interval[1] = Math.max(next_End, cur_End);
            }
            else {
                cur_interval = interval;
                res.add(cur_interval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    /**
     * LeetCode 57
     * Medium
     * Linear Search (PriorityQueue)
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        list.add(newInterval);
        while (i < n && intervals[i][0] > newInterval[1]) {
            list.add(intervals[i]);
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * LeetCode 252
     * Easy
     * Linear Search (PriorityQueue)
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }

    /**
     * LeetCode 253
     * Medium
     * Linear Search (PriorityQueue)
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int end = 0;
        int count = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[end]) {
                count++;
            }
            else {
                end++;
            }
        }
        return count;
    }

    /**
     * LeetCode 1
     * Easy
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }   else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}

