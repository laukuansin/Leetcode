public class UnionFind{
    public int[] group;
    public int[] rank;
    
    public UnionFind(int size)
    {
        group = new int[size];
        rank = new int[size];
        for(int i=0;i<size;i++)
        {
            group[i]=i;
        }
    }
    
    public int find(int node)
    {
        if(group[node]!=node)
        {
            group[node]=find(group[node]);
        }
        return group[node];
    }
    
    public bool union(int nodeA, int nodeB)
    {
        int group1 = find(nodeA);
        int group2 = find(nodeB);
        
        if(group1==group2)
        {
            return false;
        }
        
        if(rank[group1]>rank[group2])
        {
            group[group2]=group1;
        }
        else if(rank[group1]<rank[group2])
        {
            group[group1]=group2;
        }
        else{
            group[group1]=group2;
            rank[group2]+=1;
        }
        return true;
    }
}
public class Solution {
    public int MinCostConnectPoints(int[][] points) {
        int n=points.Length;
        List<int[]> allEdges = new List<int[]>();
        for(int i=0;i<n-1;i++)
        {
            for(int j=i;j<n;j++)
            {
                int weight = Math.Abs(points[i][0]-points[j][0])+Math.Abs(points[i][1]-points[j][1]);
                int[] currEdge = {weight,i,j};
                allEdges.Add(currEdge);
            }
        }
         //Collections.sort(allEdges, (a, b) -> Integer.compare(a[0], b[0]));
        allEdges =allEdges.OrderBy(o=>o[0]).ToList();
        
        UnionFind uf = new UnionFind(n);
        
        int mstCost = 0;
        int edgesUsed =0;
        
        for(int i=0;i<allEdges.Count&&edgesUsed<n-1;i++)
        {
            int node1 = allEdges[i][1];
            int node2 = allEdges[i][2];
            int weight = allEdges[i][0];
            if (uf.union(node1, node2)) {
                mstCost += weight;
                edgesUsed++;
            }
        }
        return mstCost;
        
    }
}