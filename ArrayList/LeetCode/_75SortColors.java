package ArrayList.LeetCode;

public class _75SortColors {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param nums
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        int index = 0;

        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, index++, start++);
            }
            else if (nums[index] == 1) {
                index++;
            }
            else {
                swap(nums, index, end--);
            }
        }
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
