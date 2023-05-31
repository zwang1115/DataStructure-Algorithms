package Graph.UnionFind;

public interface IUnionFind {

    int count();

    void union(int x, int y);

    int find(int index);

    boolean connect(int x, int y);
}
