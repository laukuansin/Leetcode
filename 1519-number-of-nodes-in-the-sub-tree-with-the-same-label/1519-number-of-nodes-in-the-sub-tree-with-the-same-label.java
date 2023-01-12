class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] res = new int[n];
        HashMap<Integer,List<Integer>> graph = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            graph.put(i,new ArrayList<>());
        }

        for(int[] edge:edges)
        {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        dfs(0,-1,graph,labels.toCharArray(),res);
        return res;
    }

    public int[] dfs(int node,int parentNode,HashMap<Integer,List<Integer>> graph,char[] labelsArr,int[] res)
    {
        int[] labelCount = new int[26];
        for(int adjNode:graph.get(node))
        {
            if(adjNode!=parentNode)
            {
                int[] tmp=dfs(adjNode,node,graph,labelsArr,res);
                for(int i=0;i<26;i++)
                {
                    labelCount[i]+=tmp[i];
                }
            }
        }
        labelCount[labelsArr[node]-'a']++;
        res[node] = labelCount[labelsArr[node]-'a'];

        return labelCount;
    }
}