package BinarySearch.LeetCode;

public class _302SmallestRectangleEnclosingBlackPixels {

    /**
     * Time: O(m long n + n log m)
     * Space: O(1)
     * @param image
     * @param x
     * @param y
     * @return
     */
    public int minArea(char[][] image, int x, int y) {
        int rows = image.length;
        int cols = image[0].length;

        int left = binarySearchLeft(image, 0, y, true);
        int right = binarySearchRight(image, y, cols - 1, true);
        int top = binarySearchLeft(image, 0, x, false);
        int bottom = binarySearchRight(image, x, rows - 1, false);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int binarySearchLeft(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (hasBlack(image, left, isHor)) {
            return left;
        } else {
            return right;
        }
    }


    private int binarySearchRight(char[][] image, int left, int right, boolean isHor) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHor)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (hasBlack(image, right, isHor)) {
            return right;
        } else {
            return left;
        }
    }

    private boolean hasBlack(char[][] image, int x, boolean isHor) {
        if (isHor) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][x] == '1') return true;
            }
        } else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[x][i] == '1') return true;
            }
        }
        return false;
    }
}
