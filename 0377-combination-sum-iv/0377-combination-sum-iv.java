class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target+1];
        Arrays.sort(nums);
        return helper(nums,target,dp);
    }

    public int helper(int[] nums, int target,Integer[] dp)
    {
        if(dp[target]!=null)
        {
            return dp[target];
        }
        if(target==0)
        {   
            return 1;
        }

        int total = 0;
        for(int i = 0 ; i < nums.length ; i ++)
        {

            if(nums[i]>target)
                break;
            total+=helper(nums,target-nums[i],dp);
        }
        
        return dp[target]=total;
    }
}