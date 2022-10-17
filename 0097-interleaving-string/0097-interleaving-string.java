class Solution {
  
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        
        if(m+n!=s3.length()) return false;
        
        boolean[][] dp = new boolean[m+1][n+1];
        
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                if(i==0&&j==0)//default case
                {
                    dp[i][j]=true;//if str1 is empty and str2 is empty, then it is true to interleave an empty str3
                }
                else if(i==0)
                {
                    dp[i][j] = s2.charAt(j-1)==s3.charAt(j-1)&&dp[i][j-1];//s2.substring(0,j).equals(s3.substring(0,j));
                }
                else if(j==0)
                {
                    dp[i][j] = s1.charAt(i-1)==s3.charAt(i-1)&&dp[i-1][j];//s1.substring(0,i).equals(s3.substring(0,i));
                }
                else{
                    dp[i][j] = (s1.charAt(i-1)==s3.charAt(i+j-1)&& dp[i-1][j])||(s2.charAt(j-1)==s3.charAt(i+j-1)&&dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
        
    }
    
  
}