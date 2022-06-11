class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int i :nums)
        {
            sum+=i;
        }
        sum-=x;
        int ans=-1;
        int currentSum=0;
       
        for(int start=0,end=0;start<nums.length&&end<nums.length;end++)
        {
            currentSum+=nums[end];
          
            
            while(start<=end&&currentSum>sum)
            {
                currentSum-=nums[start++];
            }
              if(currentSum==sum)
            {
                ans=Math.max(ans,end-start+1);
            }
        }
        
        return ans==-1?-1:nums.length-ans;
    }
}