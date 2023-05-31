package Graph.ShortestPath.Dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Time: O(ElogE)
 */

public class Dijkstra {

    public void dijkstra(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        int[] minDist = new int[graph.vertices];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        });

        minDist[0] = 0;
        pq.offer(new Pair<>(minDist[0], 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            List<Edge> list = graph.list[vertex];
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if (!visited[edge.end]) {
                    int destination = edge.end;
                    int curDist = minDist[vertex] + edge.weight;
                    if (curDist < minDist[destination]) {
                        pq.offer(new Pair<>(curDist, destination));
                        minDist[destination] = curDist;
                    }
                }
            }
        }
        print(minDist);
    }

    public void print(int[] minDists) {
        System.out.println("Dijkstra :");
        for (int i = 0; i < minDists.length; i++) {
            System.out.println("Source Vertex 0 : to vertex : " + i + " minDist " + minDists[i] + " minDist : " + minDists[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 6);
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstra(graph);
    }
}
