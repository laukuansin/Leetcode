class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int num:nums)
        {
            sum+=num;
        }

        sum-=x;
        if(sum<0)
        {
            return -1;
        }

        int curSum = 0;
        int start = 0;
        int end = 0;
        
        while(start<n&&end<n)
        {
            curSum+=nums[end];
            while(start<n&&sum-curSum<0)
            {
                curSum-=nums[start++];
            }
            if(sum-curSum==0)
            {
                ans = Math.max(ans,end-start+1);
            }
            end++;
        }

        return ans==Integer.MIN_VALUE?-1:n-ans;
    }

}