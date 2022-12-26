class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<2)
        {
            return true;
        }
        if(nums[0]==0)
            return false;
        int curMax = 0;
        for(int i=0;i<nums.length&&curMax>=i;i++)
        {
            curMax = Math.max(curMax,i+nums[i]);

            if(curMax>=nums.length-1)
            {
                return true;
            }

        }

        return false;
    }
}

/*
test case: 2,3,1,1,4

curMax = 2;

*/