package Shape.Shape;
import java.util.HashSet;
import java.util.List;

public class NumberOfRecOnPoints {

    public int rectangle(List<Shape.Point.Point> list) {
        if (list.size() == 0) return 0;
        int res = 0;
        HashSet<Shape.Point.Point> set = new HashSet<>();
        for (Shape.Point.Point point : list) {
            set.add(point);
        }
        HashSet<String> duplicate = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {
            Shape.Point.Point node1 = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Shape.Point.Point node2 = list.get(j);
                if (node1.equals(node2)) {
                    continue;
                }
                Point left = new Point(node1.x, node2.y);
                Point right = new Point(node2.x, node1.y);
                if (set.contains(left) && set.contains(right)) {
                    long distance = (left.x - right.x) * (left.x - right.x) + (left.y - right.y) * (left.y - right.y);
                    double centerX = (double)(left.x + right.x) / 2;
                    double centerY = (double)(left.y + right.y) / 2;
                    String info = "" + distance + "+" + centerX + "+" + centerY;
                    if (!duplicate.contains(info)) {
                        duplicate.add(info);
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
