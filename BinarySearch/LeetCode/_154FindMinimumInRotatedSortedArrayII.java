package BinarySearch.LeetCode;

public class _154FindMinimumInRotatedSortedArrayII {

    /**
     * Time: O(logn)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }
        return nums[start];
    }
}
