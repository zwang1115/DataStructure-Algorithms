package Graph.UnionFind.LeetCode;

public class _323NumOfConnectedInGraph {

    int res;
    int count;
    int[] id;

    public void union(int x, int y){
        int A = find(x);
        int B = find(y);
        if (A == B) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == A) {
                id[i] = B;
            }
        }
        res--;
    }

    public int find(int index) {
        if (index < 0 || index >= count) return 0;
        return id[index];
    }
    public int countComponents(int n, int[][] edges) {
        res = n;
        this.count = n;
        id = new int[count];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

        for (int[] pairs : edges) {
            int A = find(pairs[0]);
            int B = find(pairs[1]);
            union(A, B);
        }
        return res;
    }
}
