package BinarySearch.LeetCode;

public class _162FindPeakElement {

    /**
     * Time: O(logn)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            if (start == end) {
                return start;
            }
            int mid = (end - start) / 2 + start;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
