package Shape.LeetCode;

import java.util.HashMap;

public class _149MaxPointsOnALine {

    /**
     * Time: O(n^2)
     * Space: O(n)
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length < 2) {
            return points.length;
        }
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoints = 0;
            int sameXaxis = 1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                        samePoints++;
                    }
                    if (points[i][0] == points[j][0]) {
                        sameXaxis++;
                        continue;
                    }
                    int numerator = points[i][1] - points[j][1];
                    int denominator = points[i][0] - points[j][0];
                    int gcd = gcd(numerator, denominator);
                    String hashstr = (numerator / gcd) + "/" + (denominator / gcd);
                    map.put(hashstr, map.getOrDefault(hashstr, 1) + 1);
                    res = Math.max(res, map.get(hashstr) + samePoints);
                }
            }
            res = Math.max(res, sameXaxis);
        }
        return res;
    }

    private int gcd(int a ,int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
