class Solution {
    public boolean increasingTriplet(int[] nums) {
        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            if(firstSmall>=nums[i])
                firstSmall = nums[i];
            else if (secondSmall>=nums[i])
                secondSmall=nums[i];
            else
                return true;
            
        }
        return false;
    }
}