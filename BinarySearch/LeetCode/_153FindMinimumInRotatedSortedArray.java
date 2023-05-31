package BinarySearch.LeetCode;

public class _153FindMinimumInRotatedSortedArray {

    /**
     * Time: O(logn)
     * Space: O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left - 1];
    }
}
