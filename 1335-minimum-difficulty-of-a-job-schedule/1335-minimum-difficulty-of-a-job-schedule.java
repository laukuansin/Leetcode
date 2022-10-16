class Solution {
   
    public int minDifficulty(int[] jobs, int d) {
        int n = jobs.length;
        if(d>n)
        {
            return -1;
        }
        int[][] dp = new int[d][n];
        int maxAll = 0;
        
        for(int i=0;i<n;i++)
        {
            maxAll = Math.max(maxAll,jobs[i]);
            dp[0][i]=maxAll;
        }
        for(int i=1;i<d;i++)
        {
            for(int j=i;j<n;j++)
            {
                int min = dp[i-1][j-1]+jobs[j];
                int max = jobs[j];
                for(int k=j;k>=i;k--)
                {
                    
                    max = Math.max(max,jobs[k]);
                    min=Math.min(min,dp[i-1][k-1]+max);
                }
                dp[i][j]=min;
            }
        }
        
        
        
        return dp[d-1][n-1];
    }
    
}