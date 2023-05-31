package Graph.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _133CloneGraph {

    /**
     * BFS
     * Time: O(N + M)
     * Space: O(N)
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            map.get(cur).neighbors = new ArrayList<>();
            for (Node n : cur.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    queue.offer(n);
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    /**
     * DFS
     * Time: O(N + M)
     * Space: O(N)
     */
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph2(Node node) {
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (node == null) return null;
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node duplicate = new Node(node.val);
        map.put(node, duplicate);
        for (Node n : node.neighbors) {
            Node clone = dfs(n);
            duplicate.neighbors.add(clone);
        }
        return duplicate;
    }
}
