package BinarySearch;
public class binarySearchLeetcode {
    /**
     *
     * 4 5 6 7 0 1 2
     *
     * 4 5 6 0 1 2 3
     */
    public int searchLC33(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
            else {
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }

    public boolean searchLC88(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start++;
                end--;
            }
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            }
            else {
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return false;
    }


    public boolean searchMatrixLC74(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int value = matrix[mid / col][mid % col];
            if (value == target) {
                return true;
            } else if (value > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }


    public boolean searchMatrixLC240(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }



    class Solution {
        int[][] matrix;
        int n;
        public int kthSmallest(int[][] matrix, int k) {
            this.matrix=matrix;
            n = matrix.length;
            int low = matrix[0][0];
            int high = matrix[n-1][n-1];
            int ans=0;
            while(low<=high)
            {
                int mid = low+(high-low)/2;
                if(count(mid)>=k)
                {
                    ans=mid;
                    high =mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            return ans;
        }
        int count(int mid)
        {
            int r=0;
            int c=n-1;
            int count=0;
            while(r<n && c>=0)
            {
                if(matrix[r][c]<mid)
                {
                    r++;
                    count=count+1+c;
                }
                else
                {
                    while(c>=0 && matrix[r][c]>mid)
                        c--;
                    count=count+c+1;
                    r++;
                }
            }
            return count;
        }

    }
}
