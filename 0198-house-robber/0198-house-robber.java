class Solution {
    public int rob(int[] nums) {
        int size = nums.length;
        if(size<2)
            return nums[0];
        int[] dp = new int[size];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i = 2; i < size; i++)
        {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }

        return dp[size-1];
    }
}