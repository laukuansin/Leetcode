class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<=firstSmall)
                firstSmall = nums[i];
            else if (nums[i]<=secondSmall)
                secondSmall=nums[i];
            else
                return true;
            
        }
        return false;
    }
}