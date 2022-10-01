class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        char[] charArr= s.toCharArray();
        if(charArr[0]=='0')
        {
            return 0;
        }
        dp[0]=1;
        
        for(int i=1;i<s.length();i++)
        {
           if(charArr[i]!='0')
           {
               dp[i]=dp[i-1];
           }
            
            if(charArr[i-1]=='1'||(charArr[i-1]=='2'&&charArr[i]<='6'))
            {
                if(i-2>=0)
                    dp[i]+=dp[i-2];
                else
                    dp[i]++;
            }
        }
        return dp[s.length()-1];
    }
}