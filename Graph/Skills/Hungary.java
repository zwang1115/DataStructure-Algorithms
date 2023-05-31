package Graph.Skills;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Time: O(n * m)
 */
public class Hungary {

    int[] person;
    int[] places;

    public void match(int[][] matrix) {
        person = new int[4];
        places = new int[3];
        Arrays.fill(person, -1);
        Arrays.fill(places,-1);

        boolean[] visited;
        int res = 0;
        for (int i = 0; i < person.length; i++) {
            visited = new boolean[places.length];
            if (hungary(matrix, i, visited)) {
                res++;
            }
        }
    }

    public boolean hungary(int[][] matrix, int start, boolean[] visited) {
        for (int end = 0; end < places.length; end++) {
            if (matrix[start][end + 4] == 0 || visited[end]) {
                continue;
            }
            visited[end] = true;
            if (places[end] == -1 || hungary(matrix, places[end], visited)) {
                person[start] = end;
                places[end] = start;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
