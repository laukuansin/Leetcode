class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int res = -1;
        int min = Integer.MAX_VALUE;
        long total = 0;
        long start = 0;
        
        for(int num:nums)
        {
            total+=num;
        }
        
        for(int i=0;i<n;i++)
        {
            start+=nums[i];
            total-=nums[i];
            
            int frontCount = i+1;
            int endCount = n-i-1;
            
            int frontAve = Math.round(start/frontCount);
            int endAve = i==n-1?0:Math.round(total/endCount);
            
            int currAbs = Math.abs(frontAve-endAve);
            if(currAbs<min)
            {
                min = currAbs;
                res = i;
            }
            
        }
        return res;
        
    }
}