package Graph.Prim;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * Time: O(ElogV)
 */

public class Prim {

    public void primMST(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        int[] minDists = new int[graph.vertices];
        int[] parents = new int[graph.vertices];

        Arrays.fill(minDists, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(graph.vertices, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int key1 = o1.getKey();
                int key2 = o2.getKey();
                return key1 - key2;
            }
        });

        minDists[0] = 0;
        pq.offer(new Pair<>(minDists[0], 0));
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int vertex = pair.getValue();
            visited[vertex] = true;
            List<Edge> list = graph.list[vertex];
            for (int i = 0; i < list.size(); i++) {
                Edge edge = list.get(i);
                if (!visited[edge.end]) {
                    int destination = edge.end;
                    int curDist = edge.weight;
                    if (curDist < minDists[destination]) {
                        pq.offer(new Pair<>(curDist, destination));
                        parents[destination] = vertex;
                        minDists[destination] = curDist;
                    }
                }
            }
        }
        print(parents, minDists, graph.vertices);
    }

    public void print(int[] parents, int[] minDists, int vertices) {
        int total = 0;
        System.out.println("MST :");
        for (int i = 1; i < parents.length; i++) {
            System.out.println("Edge : " + i + " - " + parents[i] + " minDist : " + minDists[i]);
            total += minDists[i];
        }
        System.out.println("Total : " + total);
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 6);
        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 4, 3);
        graph.addEdge(2, 4, 6);
        graph.addEdge(2, 3, 5);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 2);
        graph.addEdge(4, 5, 6);
        Prim prim = new Prim();
        prim.primMST(graph);
    }
}
