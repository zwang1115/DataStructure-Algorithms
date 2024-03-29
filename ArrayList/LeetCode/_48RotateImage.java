package ArrayList.LeetCode;

public class _48RotateImage {

    /**
     * Time: O(m * n)
     * Space: O(1)
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - 1- j];
                matrix[i][len - 1- j] = temp;
            }
        }
    }
}
