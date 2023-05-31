package Shape.Point;

public class PointsWithTriangle {

    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
    }

    public boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x,int y) {
        double A = area (x1, y1, x2, y2, x3, y3);
        double A1= area(x, y, x2, y2, x3, y3);
        double A2 = area(x1, y1, x, y, x3, y3);
        double A3 = area(x1, y1, x2, y2, x, y);

        if (A1 == 0 || A2 == 0 || A3 == 0) {
            return true;
        }
        return A == A1 + A2 + A3;

    }
}
