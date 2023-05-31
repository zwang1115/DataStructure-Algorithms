package Graph.LeetCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Time: O(V + E)
 * Space: O(n)
 */
public class _399EvaluateDivision {

    HashMap<String, List<GraphNode>> map;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            if (!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), new ArrayList<>());
            }
            map.get(equation.get(0)).add(new GraphNode(equation.get(1), values[i]));
            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), new ArrayList<>());
            }
            map.get(equation.get(1)).add(new GraphNode(equation.get(0), 1 / values[i]));
        }

        double[] res = new double[queries.size()];
        for (int i = 0 ; i < res.length; i++) {
            res[i] = find(queries.get(i).get(0), queries.get(i).get(1), 1, new HashSet<>());
        }
        return res;
    }

    private double find(String start, String end, double value, HashSet<String> visited) {
        if (visited.contains(start)) return -1;
        if (!map.containsKey(start)) return -1;
        if (start.equals(end)) return value;
        visited.add(start);

        for (GraphNode next : map.get(start)) {
            double sub = find(next.den, end, value * next.val, visited);
            if (sub != -1.0) return sub;
        }
        visited.remove(start);
        return -1;
    }

    class GraphNode {
        String den;
        double val;

        GraphNode(String den, double val) {
            this.den = den;
            this.val = val;
        }
    }
}
