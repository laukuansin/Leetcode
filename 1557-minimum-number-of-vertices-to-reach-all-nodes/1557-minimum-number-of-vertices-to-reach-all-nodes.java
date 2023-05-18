class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        UnionFind uf = new UnionFind(n);
        for(List<Integer> edge:edges)
        {
            uf.union(edge.get(1),edge.get(0));
        }

        return uf.getSet();
    }
}

class UnionFind{
    int[] root;

    UnionFind(int size)
    {
        root = new int[size];
        for(int i=0;i<size;i++)
        {
            root[i] = i;
        }
    }

    int find(int x)
    {
        if(root[x]==x)
        {
            return root[x];
        }

        return find(root[x]);
    }

    void union(int x,int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
        {root[x] = y;
        }
    }

    List<Integer> getSet()
    {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<root.length;i++)
        {
            if(root[i]==i)
                list.add(root[i]);
        }

        return list;
    }
}