package Graph.Basics;

import Graph.Basics.GraphNode;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class DFS {

    /**
     * Time: O(V + E)
     * Space: O(V)
     * @param list
     */
    public static void dfs(List<GraphNode> list) {
        HashSet<GraphNode> visited = new HashSet<>();
        for (GraphNode node : list) {
            if (!visited.contains(node)) {
                helper(node, visited);
            }
        }
    }

    public static void dfs2(GraphNode node) {
        helper(node, new HashSet<>());
    }

    public static void helper(GraphNode node, HashSet<GraphNode> visited) {
        visited.add(node);
        for (GraphNode neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                helper(neighbor, visited);
            }
        }
    }

    public static void dfsIteration(GraphNode graphNode) {
        Stack<GraphNode> stack = new Stack<>();
        HashSet<GraphNode> visited = new HashSet<>();
        stack.push(graphNode);
        visited.add(graphNode);
        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            for (GraphNode neighbor : node.neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }

    /**
     * Time: O(V^2)
     * Space: O(V)
     * @param matrix
     */
    public static void dfsMatrix(int[][] matrix) {
        int[] visited = new int[matrix.length];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                helper(matrix, visited, i);
            }
        }
    }

    public static void helper(int[][] matrix, int[] visted, int vertex) {
        visted[vertex] = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[vertex][i]== 1) {
                if (visted[i] == 0) {
                    helper(matrix, visted, i);
                }
            }
        }
    }

    public static void dfsMatrixIteration(int[][] matrix) {
        int[] visited = new int[matrix.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                stack.push(i);
                while (!stack.isEmpty()) {
                    Integer vertex = stack.pop();
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[vertex][j] == 0) {
                            stack.push(j);
                            visited[j] = 1;
                        }
                    }
                }
            }
        }
    }
}
