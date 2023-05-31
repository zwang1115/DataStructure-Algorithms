package Graph.Skills;

import java.util.List;

public class GraphNode {

    int lable;

    List<GraphNode> neighbors;

    public GraphNode(int lable, List<GraphNode> neighbors) {
        this.lable = lable;
        this.neighbors = neighbors;
    }
}
