package Graph.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int res = numCourses;
        for (int[] pairs : prerequisites) {
            indegree[pairs[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int pre = queue.poll();
            res--;
            for (int[] pairs : prerequisites) {
                if (pairs[1] == pre) {
                    indegree[pairs[0]]--;
                    if (indegree[pairs[0]] == 0) {
                        queue.offer(pairs[0]);
                    }
                }
            }
        }
        return res == 0;
    }
}
