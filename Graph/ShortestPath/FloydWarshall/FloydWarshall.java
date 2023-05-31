package Graph.ShortestPath.FloydWarshall;

/**
 * Time: O(n^3)
 */

public class FloydWarshall {

    public final static int INF = 9999;
    public void floydWarshall(int[][]graph) {
        int vertices = graph.length;
        int[][]minDist = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                minDist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (minDist[i][j] > minDist[i][k] + minDist[k][j]) {
                        minDist[i][j] = minDist[i][k] + minDist[k][j];
                    }
                }
            }
        }
        printMatrix(minDist);
    }

    public void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { { 0, 3, INF, 5 }, { 2, 0, INF, 4 }, { INF, 1, 0, INF }, { INF, INF, 2, 0 } };
        FloydWarshall floydWarshall = new FloydWarshall();
        floydWarshall.floydWarshall(graph);
    }
}








