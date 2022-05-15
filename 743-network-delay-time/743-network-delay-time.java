/*
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
                Pair<Integer,Integer> pair = new Pair<>(target,curTime);
                pairs.add(pair);
                
                hashMap.put(time[0],pairs);
            }
            else{
                List<Pair<Integer,Integer>> pairs = new ArrayList<>();
                Pair<Integer,Integer> pair = new Pair<>(target,curTime);
                pairs.add(pair);
                hashMap.put(time[0],pairs);
            }
            
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            hashMap.putIfAbsent(source, new ArrayList<>());
            hashMap.get(source).add(new Pair(dest, travelTime));
        }
        
        // Sort the edges connecting to every node
        for (int node : hashMap.keySet()) {
            Collections.sort(hashMap.get(node), (a, b) -> a.getKey() - b.getKey());
        }
        
        int[] signalReceived = new int[n+1];
        Arrays.fill(signalReceived, Integer.MAX_VALUE);
        helper(hashMap,signalReceived,k,0);
        int ans=0;
        for(int i =1;i<=n;i++)
        {
            ans =Math.max(ans,signalReceived[i]);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    
    public void helper(HashMap<Integer,List<Pair<Integer,Integer>>> hashMap,int[] signalReceived,int k, int curTime)
    {
        if(curTime>signalReceived[k])
            return;
        
        signalReceived[k]=curTime;
        
        if(!hashMap.containsKey(k))
        {
            return;
        }
        
        for(Pair<Integer,Integer> pair : hashMap.get(k))
        {
            int node = pair.getKey();
            int time = pair.getValue();
            helper(hashMap,signalReceived,node,curTime+time);
        }
    }
}
*/
class Solution {
    // Adjacency list
    Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    private void DFS(int[] signalReceivedAt, int currNode, int currTime) {
        // If the current time is greater than or equal to the fastest signal received
        // Then no need to iterate over adjacent nodes
        if (currTime >= signalReceivedAt[currNode]) {
            return;
        }

        // Fastest signal time for currNode so far
        signalReceivedAt[currNode] = currTime;
        
        if (!adj.containsKey(currNode)) {
            return;
        }
        
        // Broadcast the signal to adjacent nodes
        for (Pair<Integer, Integer> edge : adj.get(currNode)) {
            int travelTime = edge.getKey();
            int neighborNode = edge.getValue();
            
            // currTime + time : time when signal reaches neighborNode
            DFS(signalReceivedAt, neighborNode, currTime + travelTime);
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build the adjacency list
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }
        
        // Sort the edges connecting to every node
        for (int node : adj.keySet()) {
            Collections.sort(adj.get(node), (a, b) -> a.getKey() - b.getKey());
        }
        
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        
        DFS(signalReceivedAt, k, 0);
        
        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++) {
            answer = Math.max(answer, signalReceivedAt[node]);
        }
        
        // Integer.MAX_VALUE signifies atleat one node is unreachable
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}