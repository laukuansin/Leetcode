class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n==1)
            return true;
        UnionFind uf = new UnionFind(n);
        for(int i=0;i<edges.length;i++)
        {
            uf.union(edges[i][1],edges[i][0]);
        }
        return uf.find(source)==uf.find(destination);
    }
}

class UnionFind
{
    private int[] root;
    public UnionFind(int n)
    {
        root = new int[n];
        for(int i=0;i<n;i++)
        {
            root[i]=i;
        }
    }

    public int find(int x)
    {
        if(root[x]==x)
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
}