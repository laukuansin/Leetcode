class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        //dp[0] = Math.min(cost[0],cost[1]);
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length+1;i++)
        {
        
           dp[i] = (i<cost.length?cost[i]:0)+Math.min(dp[i-1],dp[i-2]);
            System.out.println(dp[i]);
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}