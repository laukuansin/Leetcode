
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0)
        {
            return 0;
        }
        int[] dp=new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0]=0;
        
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<coins.length;j++)
            {
                if(coins[j]<=i&&dp[i-coins[j]]!=-1)
                {
                    if(dp[i]==-1||dp[i]>dp[i-coins[j]]+1)
                    {
                        dp[i]=dp[i-coins[j]]+1;
                    }
                }
            }
        }
        return dp[amount];
    }
}