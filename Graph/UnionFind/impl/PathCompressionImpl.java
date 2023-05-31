package Graph.UnionFind.impl;

import Graph.UnionFind.IUnionFind;

/**
 * Time: O(1)
 * Space: O(n)
 */

public class PathCompressionImpl implements IUnionFind {

    int count;

    private int[] parents;

    private int[] size;

    public PathCompressionImpl(int count) {
        this.count = count;
        parents = new int[count];
        this.size = new int[count];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        if (size[xRoot] < size[yRoot]) {
            parents[xRoot] = yRoot;
            size[yRoot] += size[xRoot];
        } else {
            parents[yRoot] = xRoot;
            size[xRoot] += size[yRoot];
        }
    }

    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index Out Of Bounds");
        }
        while (index != parents[index]) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    public int find2(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index Out Of Bounds");
        }
        if (index != parents[index]) {
            parents[index] = find(parents[index]);
        }
        return parents[index];
    }

    @Override
    public boolean connect(int x, int y) {
        return find(x) == find(y);
    }
}
