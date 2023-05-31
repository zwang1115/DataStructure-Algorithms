package BinarySearch.LeetCode;

public class _74SearchA2DMatrix {

    /**
     * Time: O(log(n * m)
     * Space: O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            int value = matrix[mid / col][mid % col];
            if (value == target) {
                return true;
            } else if (value <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
