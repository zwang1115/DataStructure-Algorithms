package Shape.Shape;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()) {
                    Integer node = queue.poll();
                    for (int adjacent : graph[node]) {
                        if (color[adjacent] == color[node]) {
                            return false;
                        } else if (color[adjacent] == 0) {
                            queue.offer(adjacent);
                            color[adjacent] = -(color[node]);
                        }
                    }
                }
            }
        }
        return true;
    }
}
