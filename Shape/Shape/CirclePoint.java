package Shape.Shape;

public class CirclePoint {
    public int circlePoint(double r){
        int res = 0;
        for (int x = 0; x <= r; x++) {
            int y = (int)Math.sqrt(r * r - x * x);
            res += y;
        }
        return res * 4 + 1;
    }
}
