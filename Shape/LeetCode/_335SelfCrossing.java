package Shape.LeetCode;

public class _335SelfCrossing {

    /**
     * Time: O(n)
     * Space: O(1)
     * @param distance
     * @return
     */
    public boolean isSelfCrossing(int[] distance) {
        for (int i = 3, l = distance.length; i < l; i++) {
            if (distance[i] >= distance[i  - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            } else if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            } else if (i >= 5 && distance[i - 2] >= distance[i - 4] && distance[i] + distance[i -4] >= distance[i - 2]
            && distance[i - 1] <= distance[i - 3] && distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
