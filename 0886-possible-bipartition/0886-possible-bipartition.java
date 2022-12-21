class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
       int[] colors = new int[n+1];
       HashMap<Integer,List<Integer>> graph = new HashMap<>();
       for(int i=1;i<=n;i++)
       {
           graph.put(i,new ArrayList<>());
       }
       for(int i=0;i<dislikes.length;i++)
       {
           int a = dislikes[i][0];
           int b = dislikes[i][1];
          
           graph.get(a).add(b);
           graph.get(b).add(a);
       }

       for(int i=1;i<=n;i++)
       {
           if(colors[i]==0)
           {
               if(!helper(i,colors,graph,1))
               {
                   return false;
               }
           }
       }
       return true;
    }

    public boolean helper(int node,int[] colors,HashMap<Integer,List<Integer>> graph,int color)
    {   
        colors[node] = color;
        for(int adjNode:graph.get(node))
        {
            if(colors[adjNode]==0)
            {
                helper(adjNode,colors,graph,color*-1);
            }
            else if(colors[node]==colors[adjNode])
            {
                return false;
            }
        }
        return true;
    }
}