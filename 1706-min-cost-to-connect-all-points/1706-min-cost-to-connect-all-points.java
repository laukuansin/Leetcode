class Solution {
    public int minCostConnectPoints(int[][] points) {
        int ans = 0;
        boolean[] visited = new boolean[points.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0});

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,0);
        while(!pq.isEmpty())
        {
            int[] top = pq.poll();
            int weight = top[0];
            int u = top[1];

            if(visited[u]|| hashMap.getOrDefault(u,Integer.MAX_VALUE)<weight)
                continue;
            visited[u] = true;
            ans+=weight;

            for(int v = 0 ; v < points.length ; v++)
            {
                if(visited[v])
                    continue;
                int new_dist = Math.abs(points[u][0]-points[v][0])+Math.abs(points[u][1]-points[v][1]);
                if(new_dist<hashMap.getOrDefault(v,Integer.MAX_VALUE))
                {
                    hashMap.put(v,new_dist);
                    pq.add(new int[]{new_dist,v});
                }
            }    
        }

        return ans;
    }
}