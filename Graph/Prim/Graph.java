package Graph.Prim;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    int vertices;
    List<Edge>[] list;

    public Graph(int vertices) {
        this.vertices = vertices;
        list = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            list[i] = new ArrayList<>();
        }
    }

    public void addEdge(int start, int end, int weight) {
        Edge edge = new Edge(start, end, weight);
        list[start].add(edge);

        edge = new Edge(end, start, weight);
        list[end].add(edge);
    }
}
