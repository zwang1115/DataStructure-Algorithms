package Graph.UnionFind.LeetCode;

public class _323NumOfConnectedInGraphOptimizedFinal {

    public int countComponents(int n, int[][] edges) {
        int res = n;
        int[] parents = new int[n];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] pairs : edges) {
            int x = find(parents, pairs[0]);
            int y = find(parents, pairs[1]);
            if (x != y) {
                parents[x] = y;
                res--;
            }
        }
        return res;
    }

    private int find(int[] parents, int index) {
        while (index != parents[index]) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return parents[index];
    }
}
