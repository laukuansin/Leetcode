class Solution {
     int count =0;
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int x : nums) {
                if (x > i) {
                    continue;
                }

                dp[i] += dp[i - x];
            }
        }

        return dp[target];
    }
    
}