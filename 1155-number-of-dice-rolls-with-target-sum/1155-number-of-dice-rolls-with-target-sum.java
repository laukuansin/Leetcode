class Solution {
    
    int MOD = 1000000007;
    int[][] dp;
    
    Solution()
    {
        dp = new int[31][1001];
        for (int[] row: dp)
            Arrays.fill(row,-1);
    }
    
    public int numRollsToTarget(int n, int k, int target) {
        if(target<0)
            return 0;
        if(n==0)
        {
            return target==0?1:0;
        }
        
        if(dp[n][target]!=-1)
        {
            return dp[n][target];
        }
        int ans=0;
        for(int i=1;i<=k;i++)
        {
            ans=(ans+numRollsToTarget(n-1,k,target-i))%MOD;
        }
        dp[n][target]=ans%MOD;
        return dp[n][target];
    }
}