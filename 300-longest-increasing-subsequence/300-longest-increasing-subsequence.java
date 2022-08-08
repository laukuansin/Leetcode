class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int ans =1;
        for(int i=1;i<nums.length;i++)
        {
            
            int max = 1;
            int num = nums[i];
            for(int j=0;j<i;j++)
            {
                if(num>nums[j])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}