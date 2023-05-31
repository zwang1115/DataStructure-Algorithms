package BinarySearch;

public class BinarySearch {
    /**
     * 递归写法
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */
    public static int binarySearch1(int[] nums, int low, int high, int target) {
        if (high < low) {
            return -1;
        }
        int mid = (high - low) / 2 + low;
        if (nums[mid] > target) {
            return binarySearch1(nums, low, mid - 1, target);
        }
        else if (nums[mid] < target) {
            return binarySearch1(nums, mid + 1, high, target);
        }
        else {
            return mid;
        }
    }


    /**
     * 迭代写法 <=
     * 程序结束: right < target < left
     * 程序结束: right + 1 = mid
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 迭代写法 <
     * 程序结束: target < left = right
     * 程序结束: left = right
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch3(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     *迭代写法 left + 1 < right
     * 程序结束: left < target < right
     * 程序结束: left + 1 = right
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch4(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target) {
                right = mid;
            }
            else if (nums[mid] < target) {
                left = mid;
            }
            else  {
                return mid;
            }
        }
        if (target == nums[left]) {
            return left;
        }
        else if (target == nums[right]) {
            return right;
        }
        return -1;
    }




    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5 ,7, 9};
        System.out.println(binarySearch1(nums, 0, 4, 6));
    }
}
