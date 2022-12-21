class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
       int[] color = new int[n+1];
       HashMap<Integer,List<Integer>> graph = new HashMap<>();
       for(int i=0;i<dislikes.length;i++)
       {
           int a = dislikes[i][0];
           int b = dislikes[i][1];
           List<Integer> list1 = graph.getOrDefault(a,new ArrayList<>());
           List<Integer> list2 = graph.getOrDefault(b,new ArrayList<>());
           list1.add(b);
           list2.add(a);
           graph.put(a,list1);
           graph.put(b,list2);
       }
       Set<Integer> set = new HashSet<>();
       for(int i=0;i<dislikes.length;i++)
       {
           int a = dislikes[i][0];
           int b = dislikes[i][1];
           set.add(a);
           helper(a,set,color,graph,1);
           set.add(b);
           helper(b,set,color,graph,1);

           if(color[a]==color[b])
           {
               return false;
           }
       }
       return true;
    }

    public void helper(int node,Set<Integer> set,int[] color,HashMap<Integer,List<Integer>> graph,int multiple)
    {
        List<Integer> adjNodes = graph.get(node);

        for(int adjNode:adjNodes)
        {
            if(set.contains(adjNode))
            {
                continue;
            }
            if(color[node]==0)
            {
                color[node] = 1*multiple;
            }
            if(color[adjNode]==0)
            {
                color[adjNode] = -1*multiple;
            }
            set.add(adjNode);
            helper(adjNode,set,color,graph,color[adjNode]);
        }
    }
}