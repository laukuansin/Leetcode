class Solution {
    public long countPairs(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        long result = 0;
        long prefixSum = 0;
        
        for(int i=0;i<n;i++)
        {
            graph.put(i,new ArrayList<>());
        }

        for(int[] edge:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++)
        {
            long nodeSize = dfs(graph,visited,i);
            result += prefixSum*nodeSize;
            prefixSum+=nodeSize;
        }

        return result;
    }

    public int dfs(HashMap<Integer,List<Integer>> graph,boolean[] visited,int node)
    {
        if(visited[node])
        {
            return 0;
        }
        visited[node] = true;
        int totalNode = 0;

        for(int adjNode:graph.get(node))
        {
            totalNode+=dfs(graph,visited,adjNode);
        }

        return totalNode+1;
    }
}