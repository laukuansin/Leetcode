class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Integer[] dp = new Integer[51];
        return helper(s,dictionary,0,dp);
    }

    public int helper(String s,String[] dictionary,int index,Integer[] dp)
    {
        if(index==s.length())
        {
            return 0;
        }

        if(dp[index]!=null)
        {
            return dp[index];
        }

        dp[index] = 1+helper(s,dictionary,index+1,dp);

        for(String str:dictionary)
        {
            if(index+str.length()<=s.length()&&s.substring(index,index+str.length()).equals(str))
            {
                dp[index] = Math.min(dp[index],helper(s,dictionary,index+str.length(),dp));
            }
        }
        return dp[index];
    }
}