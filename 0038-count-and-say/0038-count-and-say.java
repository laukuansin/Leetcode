class Solution {
    public String countAndSay(int n) {
        String[] dp = new String[n+1];
        dp[1]="1";
        
        if(n==1)
            return dp[n];
        for(int i=2;i<=n;i++)
        {
            char[] charArr = dp[i-1].toCharArray();
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int j=1;
            for(;j<charArr.length;j++)
            {
                if(charArr[j]==charArr[j-1])
                {
                    count++;
                }
                else{
                    sb.append(count);
                    sb.append(charArr[j-1]);
                    count=1;
                }
            }
            sb.append(count);
            sb.append(charArr[j-1]);
            dp[i] = sb.toString();
        }
        
        return dp[n];
    }
}