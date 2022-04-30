class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> graph = new HashMap<>();
        buildGraph(graph,equations,values);
        double[] ans = new double[queries.size()];
        int idx=0;
        Arrays.fill(ans,-1.0);
        for(List<String> query:queries)
        {
            String valA = query.get(0);
            String valB = query.get(1);
            
            if(!graph.containsKey(valA)||!graph.containsKey(valB))
            {
                idx++;
                continue;
            }
            else{
                dfs(graph,valA,valB,ans,idx,new HashSet<>(),1.0);
                idx++;

            }
        
        }
        return ans;
    }
    
    private void dfs(HashMap<String,HashMap<String,Double>> graph,String a, String b,double[] res,int index,Set<String>visited,double tmp)
    {
        visited.add(a);
        
        if(graph.get(a).size()==0)
        {
            return;
        }
        
        if(graph.get(a).containsKey(b))
        {
            res[index]=graph.get(a).get(b)*tmp;
            return;
        }
        
        for(String next : graph.get(a).keySet())
        {
            if(visited.contains(next))
            {
                continue;
            }
            dfs(graph,next,b,res,index,visited,graph.get(a).get(next)*tmp);
        }
        return;
    }
    
    private void buildGraph(HashMap<String,HashMap<String,Double>> graph,List<List<String>> equations, double[] values)
    {
        int idx=0;
        for(List<String> equation:equations)
        {
            
            String nodeA = equation.get(0);
            String nodeB = equation.get(1);
            
            graph.putIfAbsent(nodeA,new HashMap<>());
            graph.putIfAbsent(nodeB,new HashMap<>());
            graph.get(nodeA).put(nodeB,values[idx]);
            graph.get(nodeB).put(nodeA,1/values[idx]);
            idx++;
            graph.get(nodeA).put(nodeA,1.0);
            graph.get(nodeB).put(nodeB,1.0);
        }
    }
}