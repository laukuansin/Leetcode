
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<Pair<Integer,Integer>>> hashMap = new HashMap<>();
        
        for(int[] time:times)
        {
            
            int target = time[1];
            int curTime = time[2];
            if(hashMap.containsKey(time[0]))
            {
                List<Pair<Integer,Integer>> pairs = hashMap.get(time[0]);
                Pair<Integer,Integer> pair = new Pair<>(curTime,target);
                pairs.add(pair);
                hashMap.put(time[0],pairs);
            }
            else{
                List<Pair<Integer,Integer>> pairs = new ArrayList<>();                                          Pair<Integer,Integer> pair = new Pair<>(curTime,target);
                pairs.add(pair);
                hashMap.put(time[0],pairs);
            }
            
           
        }
        
        // Sort the edges connecting to every node
        for (int node : hashMap.keySet()) {
            Collections.sort(hashMap.get(node), (a, b) -> a.getKey() - b.getKey());
        }
        
        int[] signalReceived = new int[n+1];
        Arrays.fill(signalReceived, Integer.MAX_VALUE);
        helper(hashMap,signalReceived,k,0);
        
        int ans=Integer.MIN_VALUE;
        for(int i =1;i<=n;i++)
        {
            ans =Math.max(ans,signalReceived[i]);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    
    public void helper(HashMap<Integer,List<Pair<Integer,Integer>>> hashMap,int[] signalReceived,int k, int curTime)
    {
        if(curTime>=signalReceived[k])
            return;
        
        signalReceived[k]=curTime;
        
        if(!hashMap.containsKey(k))
        {
            return;
        }
        
        for(Pair<Integer,Integer> pair : hashMap.get(k))
        {
            int time = pair.getKey();
            int node = pair.getValue();
            helper(hashMap,signalReceived,node,curTime+time);
        }
    }
}
