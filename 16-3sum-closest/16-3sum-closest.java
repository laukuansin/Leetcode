class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int res =0;
        int minDis = Integer.MAX_VALUE;
        for(int i=0;i<=size-3;i++)
        {
            if(i>0&&nums[i]==nums[i-1])
                continue;
            int start = i+1;
            int end = nums.length-1;
            
            while(start<end)
            {
                int tmpTotal =nums[i]+nums[start]+nums[end];
                int distance = Math.abs(target-tmpTotal);
                
                if(distance==0)
                {
                    return target;
                }
                
                
                while(start<end&&nums[start]==nums[start+1])
                    start++;
                while(start<end&&nums[end]==nums[end-1])
                    end--;
                if(tmpTotal<target)
                {
                    start++;
                }
                else{
                    end--;
                }
                
                if(distance<minDis)
                {
                    minDis=distance;
                    res = tmpTotal;
                }
            }
        }
        
        return res;
    }
}