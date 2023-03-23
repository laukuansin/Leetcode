class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n-1>connections.length)
        {
            return -1;
        }

        UnionFind uf = new UnionFind(n);
        for(int[] connection:connections)
        {
            uf.union(connection[0],connection[1]);
        }
        return uf.distinct()-1;
    }
}
class UnionFind{
    int[] root;
    int size;
    UnionFind(int n)
    {
        size = n;
        root = new int[n];
        for(int i=0;i<n;i++)
        {
            root[i] = i;
        }
    }

    public int find(int x)
    {
        if(x==root[x])
        {
            return root[x];
        }

        return find(root[x]);
    }

    public void union(int x,int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if(rootX!=rootY)
        {
            root[rootX] = rootY;
        }
    }

    public int distinct()
    {
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<size;i++)
        {
            visited.add(find(i));
        }
        return visited.size();
    }
}