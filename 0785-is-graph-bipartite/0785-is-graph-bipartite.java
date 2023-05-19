class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean res = true;
        for(int i=0;i<graph.length;i++)
        {
            res = res&&dfs(graph, new int[graph.length],i,1);
        }

        return res;
    }

    public boolean dfs(int[][] graph,int[] flags,int node,int curFlag)
    {
        int[] curListNode = graph[node];
        flags[node] = curFlag;
        boolean check = true;
        for(int neigh:curListNode)
        {
            if(flags[neigh]!=0)
            {
                if(flags[neigh]==curFlag)
                {
                    return false;
                }
                else{
                    continue;
                }
            }
            check = check&&dfs(graph,flags,neigh,curFlag==1?2:1);
        }
        return check;
    }
}