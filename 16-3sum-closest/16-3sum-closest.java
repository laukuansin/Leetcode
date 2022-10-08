class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<=size-3;i++)
        {
            int firstNum = nums[i];
            
            int start = i+1;
            int end = nums.length-1;
            
            while(start<end)
            {
                int tmpTotal =firstNum+nums[start]+nums[end];
                if(target == tmpTotal)
                {
                    return target;
                }
                if(Math.abs(target-res)>Math.abs(target-tmpTotal))
                {
                    res = tmpTotal;
                }
                
                if(target-nums[i]>nums[start]+nums[end])
                {
                    start++;
                }
                else{
                    end--;
                }
            }
        }
        
        return res;
    }
}