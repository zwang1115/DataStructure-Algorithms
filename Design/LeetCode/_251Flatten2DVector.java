package Design.LeetCode;

public class _251Flatten2DVector {

    /**
     * Time: O(n)
     * Space: O(1)
     */
    int indexList;
    int indexElement;
    int[][] vec;
    public _251Flatten2DVector(int[][] vec) {
        indexList = 0;
        indexElement = 0;
        this.vec = vec;
    }

    public int next() {
        if (hasNext()) {
            return vec[indexList][indexElement++];
        }
        return -1;
    }

    public boolean hasNext() {
        while (indexList < vec.length) {
            if (indexElement < vec[indexList].length) {
                return true;
            } else {
                indexList++;
                indexElement = 0;
            }
        }
        return false;
    }
}
