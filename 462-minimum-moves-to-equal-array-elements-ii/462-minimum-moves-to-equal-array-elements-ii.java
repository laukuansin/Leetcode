class Solution {
    public int minMoves2(int[] nums) {
        if(nums.length<2)
            return 0;
        if(nums.length<3)
            return Math.abs(nums[0]-nums[1]);
        
        int ans=0;
        int median = -1;
        
        Arrays.sort(nums);
        
        if(nums.length%2==0)
        {
            median = nums.length/2;
            for(int i=0;i<nums.length;i++)
            {
                if(i==median)
                    continue;
                ans+=Math.abs(nums[i]-nums[median]);
            }
            median = (nums.length/2)-1;
            int temp=0;
            for(int i=0;i<nums.length;i++)
            {
                if(i==median)
                    continue;
                temp+=Math.abs(nums[i]-nums[median]);
            }
            ans=Math.min(ans,temp);
        }
        else{
            median = nums.length/2;
            for(int i=0;i<nums.length;i++)
            {
                if(i==median)
                    continue;
                ans+=Math.abs(nums[i]-nums[median]);
            }
        }
        
        
        return ans;
    }
}