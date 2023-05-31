package Graph.LeetCode;

import java.util.*;

public class _210CourseSchedule {

    /**
     * DFS
     * Time: O(N + M)
     * Space: O(N)
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pairs : prerequisites) {
            int prev = pairs[1];
            int next = pairs[0];
            graph.get(prev).add(next);
        }

        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            visited.put(i, 0);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.get(i) == 0) {
                if (!helper(graph, visited, res, i)) {
                    return new int[0];
                }
            }
        }

        int[] results = new int[numCourses];
        for (int i = 0; i < results.length; i++) {
            results[i] = res.get(numCourses - i - 1);
        }
        return results;
    }

    public boolean helper(List<List<Integer>> graph, HashMap<Integer, Integer> visited,
                          List<Integer> res, int i) {
        if (visited.get(i) == 2) return true;
        if (visited.get(i) == 1) return false;
        visited.put(i, 1);
        for (int j : graph.get(i)) {
            if (!helper(graph, visited, res, j)) {
                return false;
            }
        }
        visited.put(i, 2);
        res.add(i);
        return true;
    }

    /**
     * BFS (Better)
     * Time: O(N + M)
     * Space: O(N)
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int k = 0;

        int[] indegree = new int[numCourses];
        for (int[] pairs : prerequisites) {
            indegree[pairs[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int[] pairs : prerequisites) {
                if (pairs[1] == pre) {
                    indegree[pairs[0]]--;
                    if (indegree[pairs[0]] == 0) {
                        queue.offer(pairs[0]);
                        res[k++] = pairs[0];
                    }
                }
            }
        }
        return k == numCourses ? res : new int[0];
    }
}
