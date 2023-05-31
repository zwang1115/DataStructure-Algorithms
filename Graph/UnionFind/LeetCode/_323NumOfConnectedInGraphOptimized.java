package Graph.UnionFind.LeetCode;

public class _323NumOfConnectedInGraphOptimized {

    int res;
    int count;
    int[] parents;

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        parents[xRoot] = yRoot;
        res--;
    }

    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index Out Of Bounds");
        }
        while (index != parents[index]) {
            index = parents[index];
        }
        return index;
    }
    public int countComponents(int n, int[][] edges) {
        res = n;
        this.count = n;
        parents = new int[count];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        for (int[] pairs : edges) {
            int xRoot = find(pairs[0]);
            int yRoot = find(pairs[1]);
            union(xRoot, yRoot);
        }
        return res;
    }
}
