package BinarySearch.LeetCode;

public class _278FirstBadVersion {

    /**
     * Time: O(logn)
     * Space: O(1)
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }







    private boolean isBadVersion(int n) {
        return true;
    }
}
