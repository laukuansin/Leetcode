class Solution {   
    public int minimumOperations(String num) {
        Integer[][] dp = new Integer[num.length()+1][25];
        return helper(num,0,0,dp);
    }

    public int helper(String num, int val, int index,Integer[][] dp)
    {
        if(index==num.length())
        {
            if(val%25==0)
            {
                return 0;
            }
            return num.length();
        }
        if(dp[index][val]!=null)
        {
            return dp[index][val];
        }
        int digit = num.charAt(index)-'0';

        int non_pick = 1+helper(num,val,index+1,dp);
        int pick = helper(num,((val*10)+digit)%25,index+1,dp);

        return dp[index][val] = Math.min(non_pick,pick);
    }
    
}