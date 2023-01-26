class Solution {
    /*
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] neighbour : adj.get(curr[0])) {
                    int price = neighbour[1], neighbourNode = neighbour[0];
                    if (price + curr[1] >= minCost[neighbourNode]) continue;
                    minCost[neighbourNode] = price + curr[1];
                    q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }*/
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] dp = new int[n][k+2];

        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<=k+1;i++)
        {   
            dp[src][i] = 0;
        }

        for(int i=1;i<=k+1;i++)
        {
            for(int[] flight:flights)
            {
                if(dp[flight[0]][i-1]!=Integer.MAX_VALUE)
                {
                    dp[flight[1]][i] = Math.min(dp[flight[1]][i],dp[flight[0]][i-1]+flight[2]);
                }
            }
        }
        return dp[dst][k+1]==Integer.MAX_VALUE?-1:dp[dst][k+1];
    }
}