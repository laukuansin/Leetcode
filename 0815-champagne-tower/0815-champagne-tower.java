class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        if(poured == 0)
            return 0.0;

        double[][] dp = new double[100][100];
        dp[0][0] = poured;
        
        for(int i =  1 ; i <= query_row ; i++)
        {
            for(int j = 0 ; j <= i ; j ++)
            {
                if(j == 0)
                {
                    double previous = (dp[i-1][j]-1)/2;
                    dp[i][j] = previous>0?previous:0;
                }
                else if(j == i)
                {   
                    double previous = (dp[i-1][j-1]-1)/2;
                    dp[i][j] = previous>0?previous:0;
                }
                else{
                    double previous1 = (dp[i-1][j]-1)/2;
                    double previous2 = (dp[i-1][j-1]-1)/2;
                    dp[i][j] = (previous1>0?previous1:0)+(previous2>0?previous2:0);
                }
            }
        }   

        return Math.min(dp[query_row][query_glass],1);
    }
}