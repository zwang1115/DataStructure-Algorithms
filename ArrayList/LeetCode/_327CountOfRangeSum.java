package ArrayList.LeetCode;

public class _327CountOfRangeSum {

    /**
     * Time: O(nlogn)
     * Space: O(n)
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        return helper(sum, new long[sum.length], 0, sum.length - 1, lower, upper);
    }

    private int helper(long[] sum, long[] helper, int low, int high, long lower, long upper) {
        if (low >= high) {
            return 0;
        }

        int mid = (high + 1 - low) / 2 + low;
        int count = helper(sum, helper, low, mid - 1, lower, upper)
                + helper(sum, helper, mid, high, lower, upper);

        int rangeStart = mid, rangeEnd = mid;
        for(int i = low; i < mid; i++) {
            while(rangeStart <= high && sum[rangeStart] - sum[i] < lower)
                rangeStart++;
            while(rangeEnd <= high && sum[rangeEnd] - sum[i] <= upper)
                rangeEnd++;

            count += rangeEnd - rangeStart;
        }

        merge(sum, helper, low, mid, high);
        return count;
    }

    private void merge(long[] sum, long[] helper, int low, int mid, int high) {
        int left = low, right = mid, idx = low;

        while(left < mid && right <= high) {
            if (sum[left] <= sum[right])
                helper[idx++] = sum[left++];
            else
                helper[idx++] = sum[right++];
        }

        while(left < mid)
            helper[idx++] = sum[left++];
        while(right <= high)
            helper[idx++] = sum[right++];

        System.arraycopy(helper, low, sum, low, high + 1 - low);
    }
}
