package Graph.Basics;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    /**
     * Time: O(V + E)
     * Space: O(V)
     * @param graphNode
     */
    public static void bfs(GraphNode graphNode) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            for (GraphNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    public static void bfs2(GraphNode graphNode) {
        HashSet<GraphNode> visited = new HashSet<>();
        Queue<GraphNode> queue = new LinkedList<>();

        visited.add(graphNode);
        queue.offer(graphNode);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                 GraphNode node = queue.poll();
                 for (GraphNode neighbors : node.neighbors) {
                     if (!visited.contains(neighbors)) {
                         queue.offer(neighbors);
                         visited.add(neighbors);
                     }
                 }
            }
        }
    }

    /**
     * Time: O(V^2)
     * Space: O(V)
     * @param matrix
     */
    public static void bfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < visited.length; k++) {
                        Integer vertex = queue.poll();
                        for (int j = 0; j < matrix.length; j++) {
                            if (matrix[vertex][j] == 0) {
                                queue.offer(i);
                                visited[j] = 1;
                            }
                        }
                    }
                }
            }
        }
    }
}
