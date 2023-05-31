package Graph.UnionFind.impl;

import Graph.UnionFind.IUnionFind;

/**
 * Union: O(1)
 * Find: O(1)
 */

public class QuickUnionImpl implements IUnionFind {

    int count;

    private int[] parents;

    public QuickUnionImpl(int count) {
        this.count = count;
        parents = new int[count];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
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
        parents[xRoot] = yRoot;
    }

    @Override
    public int find(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index Out Of Bounds");
        }
        while (index != parents[index]) {
            index = parents[index];
        }
        return index;
    }

    @Override
    public boolean connect(int x, int y) {
        return find(x) == find(y);
    }
}
